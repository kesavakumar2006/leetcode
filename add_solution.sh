#!/usr/bin/env bash
# Usage: ./add_solution.sh "Two Sum" "https://leetcode.com/problems/two-sum/" java 2026-08-09
# Creates a dated solution file under solutions/YYYY-MM/ and commits & pushes it.
set -e

TITLE="$1"
URL="$2"
LANG="$3"
DATE="${4:-$(date -I)}"  # optional 4th arg to override date (format YYYY-MM-DD)

if [ -z "$TITLE" ]; then
  echo "Usage: $0 \"Problem Title\" <url> <language> [YYYY-MM-DD]"
  exit 1
fi

# normalize
YEAR_MONTH="${DATE:0:7}"
DIR="solutions/$YEAR_MONTH"
mkdir -p "$DIR"

# extension mapping (add more if you want)
case "${LANG,,}" in
  java) EXT="java" ;;
  python|py) EXT="py" ;;
  cpp|c++) EXT="cpp" ;;
  js|javascript) EXT="js" ;;
  *) EXT="md" ;;
esac

# safe filename
SAFE_TITLE=$(echo "$TITLE" | tr ' ' '-' | tr -cd '[:alnum:]-' | tr 'A-Z' 'a-z')
FILENAME="$DIR/${DATE} - ${SAFE_TITLE}.${EXT}"

cat > "$FILENAME" <<EOF
# $TITLE

LeetCode: $URL
Date: $DATE
Language: $LANG

## Problem
(brief description or link)

## Solution
\
\
# paste your solution here
\
\
## Notes
- Complexity:
- Thoughts:
EOF

# If in a CI environment without git configured, skip commit steps gracefully
if git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
  git add "$FILENAME"
  git commit -m "Add LeetCode solution: $TITLE ($DATE)" || true
  # Push if the current branch has a remote
  if git rev-parse --abbrev-ref --symbolic-full-name @{u} >/dev/null 2>&1; then
    git push
  else
    echo "No upstream branch configured; committed locally only."
  fi
else
  echo "Created: $FILENAME (git not configured in this environment)"
fi

echo "Created: $FILENAME"
