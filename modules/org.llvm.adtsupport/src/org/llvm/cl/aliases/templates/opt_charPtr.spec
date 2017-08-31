FILE_NAME = optCharPtr
DATA_TYPE = org.clank.support.aliases.char$ptr
PARSER = parserCharPtr
DEFAULT_VALUE = org.clank.java.std.string.EMPTY.c_str()
EXTRA_OPT_IMPLEMENTS=implements org.clank.java.std.ConvertableToStdString
EXTRA_OPT_METHODS=\n\
\t@Override public org.clank.java.std.string std$string() {\n\
\t  Object s = super.$T();\n\
\t  if (s instanceof org.clank.support.aliases.char$ptr) {\n\
\t    return new org.clank.java.std.string((org.clank.support.aliases.char$ptr)s);\n\
\t  } else if (s instanceof org.clank.java.std.string) {\n\
\t    return (org.clank.java.std.string)s;\n\
\t  } else {\n\
\t    throw new IllegalArgumentException("Unexpected value class " + s.getClass());\n\
\t  }\n\
\t}\n\
