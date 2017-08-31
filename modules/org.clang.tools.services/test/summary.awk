BEGIN {
    T=0;
    ALL_TOKENS[1]="";
    NUM_LEXED_FILES[1]="";
    NUM_UNIQUE_FILES[1]="";
    TOTAL_LEXED_FILES_SIZE[1]="";
    NUM_UNRESOLVED_FILES[1]="";
    TOTAL_CLANK_VALUE[1]="";
    USED_TIME[1]="";
}
/Num Threads/           {n=split($0,A," "); T=A[n]}
/All Tokens/            {n=split($0,A," "); ALL_TOKENS[T]=A[n]}
/Num Lexed Files/       {n=split($0,A," "); NUM_LEXED_FILES[T]=A[n]}
/Num Unique Files/      {n=split($0,A," "); NUM_UNIQUE_FILES[T]=A[4]}
/Total Lexed Files Size/{n=split($0,A," "); TOTAL_LEXED_FILES_SIZE[T]=A[n]}
/Num Unresolved files/  {n=split($0,A," "); NUM_UNRESOLVED_FILES[T]=A[n]}
/.*TotalClankValue/     {n=split($0,A," "); TOTAL_CLANK_VALUE[T]=A[n]}
/Used time/             {n=split($0,A," "); USED_TIME[T]=A[3]}
{ next }
END {
    print "<div title='For more information see artifacts report.txt, report2.txt and report4.txt'>"
    print "<h2>Summary " name "</h2>"
    print "<table border=1 style='text-align: right; border: 1px; border-style: ridge;'>"
    print "<tr><th style='text-align: right'>Num Threads</th><th>1</th><th>2</th><th>4</th></tr>"
    print "<tr><th style='text-align: right'>Num Unresolved files</th><td>"   NUM_UNRESOLVED_FILES[1]   "</td><td>" NUM_UNRESOLVED_FILES[2]   "</td><td>" NUM_UNRESOLVED_FILES[4]   "</td></tr>"
    print "<tr><th style='text-align: right'>Num Unique Files</th><td>"       NUM_UNIQUE_FILES[1]       "</td><td>" NUM_UNIQUE_FILES[2]       "</td><td>" NUM_UNIQUE_FILES[4]       "</td></tr>"
    print "<tr><th style='text-align: right'>Num Lexed Files</th><td>"        NUM_LEXED_FILES[1]        "</td><td>" NUM_LEXED_FILES[2]        "</td><td>" NUM_LEXED_FILES[4]        "</td></tr>"
    print "<tr><th style='text-align: right'>Total Lexed Files Size</th><td>" TOTAL_LEXED_FILES_SIZE[1] "</td><td>" TOTAL_LEXED_FILES_SIZE[2] "</td><td>" TOTAL_LEXED_FILES_SIZE[4] "</td></tr>"
    print "<tr><th style='text-align: right'>All Tokens</th><td>"             ALL_TOKENS[1]             "</td><td>" ALL_TOKENS[2]             "</td><td>" ALL_TOKENS[4]             "</td></tr>"
    print "<tr><th style='text-align: right'>Total Clank Value</th><td>"      TOTAL_CLANK_VALUE[1]      "</td><td>" TOTAL_CLANK_VALUE[2]      "</td><td>" TOTAL_CLANK_VALUE[4]      "</td></tr>"
    print "<tr><th style='text-align: right'>Used time</th><td>"              USED_TIME[1]*1            "</td><td>" USED_TIME[2]*1            "</td><td>" USED_TIME[4]*1            "</td></tr>"
    if (USED_TIME[2] != "")
    print "<tr><th style='text-align: right'>Scalability</th><td>"            "1"                       "</td><td>" USED_TIME[1]/USED_TIME[2] "</td><td>" USED_TIME[1]/USED_TIME[4] "</td></tr>"
    print "</table>"
    print "</div>"
}
