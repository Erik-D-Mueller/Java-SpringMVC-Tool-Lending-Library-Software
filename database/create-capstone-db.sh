#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres toollib &&
psql -U postgres -d toollib -f "$BASEDIR/schema.sql" &&
psql -U postgres -d toollib -f "$BASEDIR/user.sql" &&
psql -U postgres -d toollib -f "$BASEDIR/data.sql"