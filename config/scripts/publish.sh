#!/usr/bin/env bash

# This script shall be executed only by @changesets/action that will trigger a GitHub release with
# the newly tag created.
# Jitpack will later react to the new tag and publish a new artifact in their Maven registry.

tag=v$(cat package.json | grep version | cut -d '"' -f 4)

git tag $tag | echo "New tag: $tag"