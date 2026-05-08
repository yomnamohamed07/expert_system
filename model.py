import numpy as np


class NeuralNetwork:
    """
    3-layer feedforward network:
        Input  (6)  →  Hidden (8, sigmoid)  →  Output (4, softmax)
    Trained with mini-batch gradient descent + cross-entropy loss.
    """

    def __init__(self, input_size=6, hidden_size=8, output_size=4, lr=0.1):
        self.lr = lr
        np.random.seed(42)
        self.W1 = np.random.randn(input_size, hidden_size) * 0.5
        self.b1 = np.zeros((1, hidden_size))
        self.W2 = np.random.randn(hidden_size, output_size) * 0.5
        self.b2 = np.zeros((1, output_size))

    # ── Activations ────────────────────────────────────────────────
    def sigmoid(self, z):
        return 1 / (1 + np.exp(-z))

    def sigmoid_derivative(self, z):
        s = self.sigmoid(z)
        return s * (1 - s)

    def softmax(self, z):
        e = np.exp(z - np.max(z, axis=1, keepdims=True))
        return e / e.sum(axis=1, keepdims=True)

    # ── Forward pass ───────────────────────────────────────────────
    def forward(self, X):
        self.z1 = X @ self.W1 + self.b1
        self.a1 = self.sigmoid(self.z1)
        self.z2 = self.a1 @ self.W2 + self.b2
        self.a2 = self.softmax(self.z2)
        return self.a2

    # ── Backward pass (backpropagation) ────────────────────────────
    def backward(self, X, Y):
        m = X.shape[0]

        dz2 = self.a2 - Y
        dW2 = self.a1.T @ dz2 / m
        db2 = dz2.mean(axis=0, keepdims=True)

        da1 = dz2 @ self.W2.T
        dz1 = da1 * self.sigmoid_derivative(self.z1)
        dW1 = X.T @ dz1 / m
        db1 = dz1.mean(axis=0, keepdims=True)

        self.W2 -= self.lr * dW2
        self.b2 -= self.lr * db2
        self.W1 -= self.lr * dW1
        self.b1 -= self.lr * db1

    # ── Training loop ──────────────────────────────────────────────
    def train(self, X, Y, epochs=1000):
        print("\n" + "=" * 55)
        print("   TRAINING THE NEURAL NETWORK...")
        print("=" * 55)

        for epoch in range(epochs):
            output = self.forward(X)
            self.backward(X, Y)

            if (epoch + 1) % 200 == 0:
                loss = -np.mean(Y * np.log(output + 1e-8))
                preds = np.argmax(output, axis=1)
                acc = np.mean(preds == np.argmax(Y, axis=1)) * 100
                print(f"  Epoch {epoch+1:4d} | Loss: {loss:.4f} | Accuracy: {acc:.1f}%")

        print("   Training Complete!\n")

    # ── Inference ──────────────────────────────────────────────────
    def predict(self, x):
        """x: 1-D list or array of 6 binary symptom values."""
        output = self.forward(np.array([x], dtype=float))
        idx = int(np.argmax(output))
        return idx, output[0]
