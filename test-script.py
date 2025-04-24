import requests
import random
import uuid
import time

GENDERS = ["male", "female", "other"]
REGIONS = ["US-East", "US-West", "EU-Central", "Asia/Singapore"]

url = "http://localhost:8080/surveys"

def generate_random_survey():
    return {
        "age": random.randint(18, 65),
        "gender": random.choice(GENDERS),
        "region": random.choice(REGIONS),
        "surveyID": str(uuid.uuid4()),
        "score": random.randint(1, 5)
    }

for _ in range(10):
    payload = generate_random_survey()
    response = requests.post(url, json=payload)
    print(response.status_code, response.text)
    time.sleep(2)
