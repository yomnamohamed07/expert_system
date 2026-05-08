from data import DISEASE_NAMES, DISEASE_ADVICE, HIERARCHY, SYMPTOM_NAMES


def show_hierarchy():
    """Print the expert-system knowledge hierarchy to the terminal."""
    print("\n" + "=" * 55)
    print("   EXPERT SYSTEM KNOWLEDGE HIERARCHY")
    print("=" * 55)

    for level, content in HIERARCHY.items():
        print(f"\n {level}:")
        if isinstance(content, list):
            for item in content:
                print(f"      • {item}")
        else:
            for group, symptoms in content.items():
                print(f"      ▶ {group}: {', '.join(symptoms)}")

    print("=" * 55)


def ask_symptoms():
    """Prompt the user for each symptom (1/0) and return a list of floats."""
    print("\n" + "=" * 55)
    print("   EXPERT SYSTEM - DISEASE DIAGNOSIS")
    print("=" * 55)
    print("Please answer the following questions (1=Yes, 0=No):\n")

    questions = [
        "Do you have a Fever?       ",
        "Do you have a Cough?       ",
        "Do you feel Fatigue?       ",
        "Do you have a Headache?    ",
        "Do you have a Sore Throat? ",
        "Do you have Body Aches?    ",
    ]

    symptoms = []
    for q in questions:
        while True:
            try:
                val = int(input(f"  {q}(1/0): "))
                if val in [0, 1]:
                    symptoms.append(float(val))
                    break
                else:
                    print("     Please enter 1 or 0 only.")
            except ValueError:
                print("     Invalid input. Enter 1 or 0.")

    return symptoms


def show_group_analysis(symptoms):
    """Print which symptom groups are active based on input."""
    groups = {
        "Respiratory Group":  [symptoms[1], symptoms[4]],
        "Systemic Group":     [symptoms[0], symptoms[2], symptoms[5]],
        "Neurological Group": [symptoms[3]],
    }
    print("\n Symptom Group Analysis (Hierarchy Level 2):")
    for group, vals in groups.items():
        status = "ACTIVE" if any(v == 1 for v in vals) else "Clear"
        print(f"   • {group}: {status}")


def show_result(disease_idx, confidence):
    """Print the final diagnosis and advice."""
    disease = DISEASE_NAMES[disease_idx]
    conf_pct = confidence[disease_idx] * 100

    print("\n" + "=" * 55)
    print(f"   Neural Network Diagnosis : {disease}")
    print(f"   Confidence               : {conf_pct:.1f}%")
    print(f"\n   All class probabilities:")
    for i, name in enumerate(DISEASE_NAMES):
        bar = "█" * int(confidence[i] * 30)
        print(f"     {name:<10} {bar:<30} {confidence[i]*100:.1f}%")
    print(f"\n   Advice: {DISEASE_ADVICE[disease]}")
    print("=" * 55)


def run_diagnosis_loop(nn):
    """Main interactive loop: ask → analyse → diagnose → repeat."""
    while True:
        symptoms = ask_symptoms()
        show_group_analysis(symptoms)

        disease_idx, confidence = nn.predict(symptoms)
        show_result(disease_idx, confidence)

        again = input("\n  Another diagnosis? (y/n): ").strip().lower()
        if again != "y":
            print("\n  Goodbye! Stay healthy.\n")
            break
