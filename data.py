import numpy as np


X = np.array([
    [1, 1, 1, 1, 0, 1],   # Flu
    [1, 1, 1, 1, 0, 1],   # Flu
    [0, 1, 0, 0, 1, 0],   # Cold
    [0, 1, 0, 0, 1, 0],   # Cold
    [1, 1, 1, 1, 1, 1],   # COVID
    [1, 1, 1, 1, 1, 1],   # COVID
    [0, 0, 0, 0, 0, 0],   # Healthy
    [0, 0, 0, 0, 0, 0],   # Healthy
    [1, 0, 1, 1, 0, 1],   # Flu
    [0, 1, 0, 0, 1, 0],   # Cold
    [1, 1, 1, 0, 1, 1],   # COVID
    [0, 0, 0, 0, 0, 0],   # Healthy
    [1, 1, 1, 1, 0, 0],   # Flu
    [0, 1, 1, 0, 1, 0],   # Cold
    [1, 0, 1, 1, 0, 1],   # Flu
    [1, 1, 1, 1, 1, 0],   # COVID
    [0, 0, 1, 0, 0, 0],   # Healthy
    [0, 1, 0, 1, 1, 0],   # Cold
    [1, 1, 0, 1, 0, 1],   # Flu
    [1, 1, 1, 1, 1, 1],   # COVID
], dtype=float)


y_raw = np.array([0, 0, 1, 1, 2, 2, 3, 3, 0, 1, 2, 3, 0, 1, 0, 2, 3, 1, 0, 2])

DISEASE_NAMES = ["Flu", "Cold", "COVID-19", "Healthy"]

SYMPTOM_NAMES = ["Fever", "Cough", "Fatigue", "Headache", "Sore Throat", "Body Ache"]

DISEASE_ADVICE = {
    "Flu":      "Rest, drink fluids, take fever reducers. See a doctor if symptoms worsen.",
    "Cold":     "Rest, warm liquids, throat lozenges. Should improve in 7-10 days.",
    "COVID-19": "Isolate immediately! Contact your doctor and get tested.",
    "Healthy":  "You seem healthy! Keep up the good habits.",
}

HIERARCHY = {
    "Level 1 - Raw Symptoms": SYMPTOM_NAMES,
    "Level 2 - Symptom Groups": {
        "Respiratory Group":  ["Cough", "Sore Throat"],
        "Systemic Group":     ["Fever", "Fatigue", "Body Ache"],
        "Neurological Group": ["Headache"],
    },
    "Level 3 - Diseases": DISEASE_NAMES,
}


def one_hot(y, num_classes):
    result = np.zeros((len(y), num_classes))
    for i, label in enumerate(y):
        result[i][label] = 1
    return result


Y = one_hot(y_raw, 4)
