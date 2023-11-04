#!/usr/bin/env bash

# Starts the release process by updating the package changelog.
npx changeset

# Requires manual stage + commit since @changeset/cli installed globally is not able to
# resolve internal modules: https://github.com/changesets/changesets/issues/945
git add .changeset/ && git commit -m "docs(changeset): release changeset" && git push