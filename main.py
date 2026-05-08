from data import X, Y
from model import NeuralNetwork
from ui import show_hierarchy, run_diagnosis_loop


def main():
    print("\n" + " " * 15)
    print("  NEURAL NETWORK EXPERT SYSTEM")
    print("  Disease Diagnosis using Mini Dataset")
    print(" " * 15)

    # Step 1 — show knowledge hierarchy
    show_hierarchy()

    # Step 2 — build and train the network
    nn = NeuralNetwork(input_size=6, hidden_size=8, output_size=4, lr=0.1)
    nn.train(X, Y, epochs=1000)

    # Step 3 — interactive diagnosis
    run_diagnosis_loop(nn)


if __name__ == "__main__":
    main()
