FILE_NAME = char$ptr$array
CLASS_SUFFIX =
POINTER_NAME = char$ptr
REFERENCE_NAME = char$ref
TYPE = byte
SB_APPEND_ELEMENT_I=if (b==0) { sb.append("<EOF>"); break; } else { sb.append((char)b); }
SET_IMPL=return array[(int)(this.index + index)] = value;
ADDITIONAL_ASSIGNMENTS =else if (value instanceof org.clank.support.char$ptr$CharSequence) {\n\
\t\t\t  org.clank.support.char$ptr$CharSequence val = (org.clank.support.char$ptr$CharSequence) value;\n\
\t\t\t  array = org.clank.support.NativePointer.new$char(val.getCharSequence().length() + 1);\n\
\t\t\t  org.clank.java.std.memcpy(org.clank.support.NativePointer.create_char$ptr(array), org.clank.support.NativePointer.create_char$ptr(val.getCharSequence()), array.length);\n\
\t\t\t  index = val.$index();\n\
\t\t\t  // keep constness of copied value\n\
\t\t\t  super.$toConstContent();\n\
\t\t\t  return this;\n\
\t\t\t} else if (value instanceof char$ptr$heavy) {\n\
\t\t\t  byte[] mem = org.clank.support.Native.$extract_chars(((char$ptr$heavy) value).$memory());\n\
\t\t\t  assert mem != null;\n\
\t\t\t  array = mem;\n\
\t\t\t  index = value.$index();\n\
\t\t\t  return this;\n\
\t\t\t}
ADDITIONAL_MODIFY_VALUE_SECTION_START =
ADDITIONAL_MODIFY_VALUE_SECTION_END =
BUILTIN_TYPE_MODIFY_VALUE_SECTION_START=
BUILTIN_TYPE_MODIFY_VALUE_SECTION_END=
