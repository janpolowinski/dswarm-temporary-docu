To keep the code base manageable, we need to enforce consistency. Even though some rules may sound restrictive, a consistent code base facilitates reading and understanding the code by new developers. 

## New to git?

If you are new to git, its worth getting familiar with the concepts and syntax.

* Have a look at the [git tutorial](https://www.atlassian.com/git/tutorial). It takes some time but is essential to understand the work flow.
* Use the [visualisation of Git concepts](http://www.wei-wang.com/ExplainGitWithD3/) (see "Free Playground") to use what you have learned.
* See the [official and comprehensive man pages](http://git-scm.com/documentation) for full details on git.
* use GitHub web interface to
  * get an overview of the d:swarm repositories 
  * fork the central repositories
  * create pull requests


## Feature Implementation

1. Create a feature branch in your repository fork by deriving the new branch from the builds/unstable of your repository fork or of the main repository (i.e. not from another feature branch), e.g., *sprint-10/dd-329*

        git checkout -b sprint-10/dd-329 builds/unstable
hint: not too fine grained, corse-grained á la story ticket number is enough

2. Commit all your changes to this branch until the feature is completely implemented and ensure that all tests of the project are still executing successfully (ideally).
note: please commit (+ push) early and often - to guarantee (somehow) that no code will get lost by other circumstances, e.g., commit (+ push) even your unfinished/not running code at the end of a working day to save the code somewhere else

3. Clean up ([rebase](https://www.atlassian.com/git/tutorial/rewriting-git-history)) your feature branch if you did work-in-progress commits

4. Merge your feature branch back to the *builds/unstable* branch of your repository fork.
To avoid unnecessary complex merge conflicts, checkout *builds/unstable* and pull upstream changes before your merge, .e.g

        git checkout builds/unstable
        git pull origin builds/unstable # or whatever your upstream remote is called, .e.g. slub
        git merge sprint-10/dd-329

5. Create a [[pull request|https://help.github.com/articles/using-pull-requests]] from the *builds/unstable* branch of your repository fork to the *builds/unstable* branch of the main repository (where your fork was created from)
 * note: within minutes, a Jenkins build is automatically triggered. Jenkins adds the start of the build as a comment to the pull request and adds another comment with build results.
    + In case the build was successful and tests have passed, the assignee can start reviewing the pull request.
    + In case the build or tests failed, it is up to the developer that created the request to solve the problems. A new commit will trigger Jenkins to build again. 
 * important: if you commit new change sets to the builds/unstable branch in your repository fork in between, then these changes will automatically be included in the change set of the pull request as well - so be careful when committing changes to the builds/unstable branch of your repository fork until the pull request was approved (or closed) by the assignee of the pull request. As a rule of thumb, only push to your builds/unstable when there are no pending pull requests.

6. The pull request will be processed by the project maintainers.


## Commit Message Format

 The commit message format is based on [[typo 3's format|http://wiki.typo3.org/CommitMessage_Format_(Git)]]. Basically, a message consists of a topic description in the first line and optional details, separated by a single blank line.

Topic description (first line):
 * Prefix the line with a proper tag: _[BUGFIX]_, _[IMPROVEMENT]_ or _[TASK]_, followed by a reference to the corresponding JIRA issue, e.g. _[DD-123]_.
 *Keep the whole line below 52 characters if possible, but below 80 in any case. 

Possible tags are:
 * _[IMPROVEMENT]_: A new feature (also small additions). Most likely it will be an added feature, but it could also be removed.
 * _[BUGFIX]_: A fix for a bug.
 * _[TASK]_: Anything not covered by the above categories, e.g. coding style cleanup.

Additionally other flags might be added under certain circumstances:

* _[!!!]_: Breaking change. After this patch, something works differently than before and the user / admin / developer will have to change something. If used, tag must be the first one to not be overseen.
* _[DB]_: Something has changed in the database definition and requires a database reset after merging.
* _[CONF]_: Some configuration changed. That could be a changed default value, a new setting or the removal of some setting that used to exist.
* _[WIP]_: Work In Progress. Not to be committed to upstream, must be rebased before pull request.

Example message:

    [!!!][DB][BUGFIX][DD-567] fix schema inconsistencies
    
    Fix relational database schema inconsistencies. Some attribute namings of n:m relationships are inverted.
    
    When merging this fix, one needs to reset the database and manually remove the renamed tables: 
    DROP TABLE IF EXISTS attributes_attribute_paths; 
    DROP TABLE IF EXISTS attribute_paths_schemas;

(The message describes a database bug fix, as described in JIRA issue DD-567, that alters the schema. It therefore causes others to take extra precaution when merging since a reset of the db is required.)

## Code clean-up

Use separate clean-up commits if you clean-up a lot of code. Do not mix clean-ups with feature implementation, bug fixes etc. within one commit. This makes it easier to understand changesets and (more or less) ignore clean-up commits when reviewing a pull request and understanding the changes in commits later on. 

See also [[Code Quality]].