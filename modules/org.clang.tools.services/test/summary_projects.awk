BEGIN {
    PROJECTS="";
    ALL_TOKENS="";
    NUM_LEXED_FILES="";
    NUM_UNIQUE_FILES="";
    TOTAL_LEXED_FILES_SIZE="";
    NUM_UNRESOLVED_FILES="";
    TOTAL_CLANK_VALUE="";
    USED_TIME="";
}
/Project Name/          {n=split($0,A," "); PROJECTS=PROJECTS "<th>" A[n] "</th>"}
/All Tokens/            {n=split($0,A," "); ALL_TOKENS = ALL_TOKENS "<td>" A[n] "</td>"}
/Num Lexed Files/       {n=split($0,A," "); NUM_LEXED_FILES=NUM_LEXED_FILES "<td>" A[n] "</td>"}
/Num Unique Files/      {n=split($0,A," "); NUM_UNIQUE_FILES=NUM_UNIQUE_FILES "<td>" A[4] "</td>"}
/Total Lexed Files Size/{n=split($0,A," "); TOTAL_LEXED_FILES_SIZE=TOTAL_LEXED_FILES_SIZE "<td>" A[n] "</td>"}
/Num Unresolved files/  {n=split($0,A," "); NUM_UNRESOLVED_FILES=NUM_UNRESOLVED_FILES "<td>" A[n] "</td>"}
/.*TotalClankValue/     {n=split($0,A," "); TOTAL_CLANK_VALUE=TOTAL_CLANK_VALUE "<td>" A[n] "</td>"}
/Used time/             {n=split($0,A," "); USED_TIME=USED_TIME "<td>" A[3]*1 "</td>"}
{ next }
END {
    print "<div title='For more information see artifacts report.txt, openjdk8.txt, firefox.txt and boost.txt'>"
    print "<h2>Projects Summary</h2>"
    print "<table border=1 style='text-align: right; border: 1px; border-style: ridge;'>"
    print "<tr><th style='text-align: right'>Project</th>" PROJECTS "</tr>"
    print "<tr><th style='text-align: right'>Num Unresolved files</th>" NUM_UNRESOLVED_FILES "</tr>"
    print "<tr><th style='text-align: right'>Num Unique Files</th>" NUM_UNIQUE_FILES "</tr>"
    print "<tr><th style='text-align: right'>Num Lexed Files</th>"  NUM_LEXED_FILES "</tr>"
    print "<tr><th style='text-align: right'>Total Lexed Files Size</th>" TOTAL_LEXED_FILES_SIZE "</tr>"
    print "<tr><th style='text-align: right'>All Tokens</th>" ALL_TOKENS "</tr>"
    print "<tr><th style='text-align: right'>Total Clank Value</th>" TOTAL_CLANK_VALUE "</tr>"
    print "<tr><th style='text-align: right'>Used time</th>" USED_TIME "</tr>"
    print "</table>"
    print "</div>"
}
