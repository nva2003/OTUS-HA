FROM python:3.9-slim-buster

WORKDIR /app

# By copying over requirements first, we make sure that Docker will cache
# our installed requirements rather than reinstall them on every build
COPY requirements.txt /app/requirements.txt
RUN pip3 install -r requirements.txt

# Now copy in our code, and run it
#COPY . .

COPY ./AddUsers .
#COPY ./AddUsers /app
#CMD [ "python3", "-m" , "flAddUsers/generateUsers.pyask", "run", ]
CMD ["-u","generateUsers.py"]
ENTRYPOINT ["python3"]