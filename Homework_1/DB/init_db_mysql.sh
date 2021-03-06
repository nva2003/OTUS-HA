#!/bin/bash

# Initialize MySQL database.
# ADD this file into the container via Dockerfile.
# Assuming you specify a VOLUME ["/var/lib/mysql"] or `-v /var/lib/mysql` on the `docker run` command…
# Once built, do e.g. `docker run your_image /path/to/docker-mysql-initialize.sh`
# Again, make sure MySQL is persisting data outside the container for this to have any effect.

mysql -P 3306 --protocol=tcp -u root -p"password" < /tmp/schema.sql

#mysql -P 3306 --protocol=tcp -u root -p
#connect myDB

# Start the MySQL daemon in the background.
#/usr/sbin/mysqld &
#mysql_pid=$!
#heroku addons:create heroku-postgresql:hobby-dev  --app otus-ha-social-network
#until mysqladmin ping >/dev/null 2>&1; do
#  echo -n "."; sleep 0.2
#done

# create the default database from the ADDed file.
#mysql < /tmp/schema.sql

# Tell the MySQL daemon to shutdown.
#mysqladmin shutdown

# Wait for the MySQL daemon to exit.
#wait $mysql_pid

# create a tar file with the database as it currently exists
#tar czvf default_mysql.tar.gz /var/lib/mysql

# the tarfile contains the initialized state of the database.
# when the container is started, if the database is empty (/var/lib/mysql)
# then it is unpacked from default_mysql.tar.gz from
# the ENTRYPOINT /tmp/run_db script
