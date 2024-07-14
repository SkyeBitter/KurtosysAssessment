import requests
import pytest


def test_kurtosys_api():
    url = "https://www.kurtosys.com"

    # Send a GET request to the url
    response = requests.get(url)

    # Assert that the response status is 200
    assert response.status_code == 200, f"Expected status code 200, but got {response.status_code}"

    # Assert that the response time is less than 2 seconds
    assert response.elapsed.total_seconds() < 2, (f"Response time is too slow: {response.elapsed.total_seconds()} "
                                                  f"seconds")

    # Assert that the server header is 'Cloudflare'
    server_header = response.headers.get('Server')
    assert server_header == "Cloudflare", f"Expected server header to be 'Cloudflare', but got {server_header}"


if __name__ == "_main_":
    pytest.main()
