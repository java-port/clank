FILE_NAME = ulong$ptr$array
CLASS_SUFFIX =
POINTER_NAME = ulong$ptr
REFERENCE_NAME = ulong$ref
TYPE = long
SB_APPEND_ELEMENT_I=sb.append((i == this.index) ? "*[" : " [").append(String.format(fmt, i)).append("]");\n\t\t\t\tsb.append(b).append(NEW_LINE)
SET_IMPL=return array[(int)(this.index + index)] = value;
ADDITIONAL_ASSIGNMENTS=
ADDITIONAL_MODIFY_VALUE_SECTION_START =
ADDITIONAL_MODIFY_VALUE_SECTION_END =
BUILTIN_TYPE_MODIFY_VALUE_SECTION_START=
BUILTIN_TYPE_MODIFY_VALUE_SECTION_END=
