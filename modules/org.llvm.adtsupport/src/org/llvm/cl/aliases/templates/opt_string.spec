FILE_NAME = optString
DATA_TYPE = org.clank.java.std.string
PARSER = parserString
DEFAULT_VALUE = org.clank.java.std.string.EMPTY
EXTRA_OPT_IMPLEMENTS=implements org.clank.java.std.ConvertableToStdString
EXTRA_OPT_METHODS=\n\
\t@Override public org.clank.java.std.string $DataType() {\n\
\t  return std$string();\n\
\t}\n\
\t\n\
\t@Override public org.clank.java.std.string $T() {\n\
\t  return std$string();\n\
\t}\n\
\t\n\
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
