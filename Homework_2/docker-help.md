###### docker context

> docker context list
> docker context use default

###### Create a new image from a container’s changes
[Create a new image from a container’s changes](https://docs.docker.com/engine/reference/commandline/commit/)

[How to Create a Docker Image From a Container](https://www.sentinelone.com/blog/create-docker-image/)

###### copy Docker images from one host to another without using a repository

[docker save](https://docs.docker.com/engine/reference/commandline/save/)

You will need to save the Docker image as a tar file:

    docker save -o <path for generated tar file> <image name>
Then copy your image to a new system with regular file transfer tools such as cp, scp or rsync(preferred for big files). After that you will have to load the image into Docker:

    docker load -i <path to image tar file>

PS: You may need to sudo all commands.

EDIT: You should add filename (not just directory) with -o, for example:

    docker save -o c:/myfile.tar centos:16

