FILE_NAME = float$ptr$array
CLASS_SUFFIX =
POINTER_NAME = float$ptr
REFERENCE_NAME = float$ref
TYPE = float
SB_APPEND_ELEMENT_I=sb.append((i == this.index) ? "*[" : " [").append(String.format(fmt, i)).append("]");\n\t\t\t\tsb.append(b).append(NEW_LINE)
SET_IMPL=return array[(int)(this.index + index)] = value;
ADDITIONAL_ASSIGNMENTS=
ADDITIONAL_MODIFY_VALUE_SECTION_START =
ADDITIONAL_MODIFY_VALUE_SECTION_END =
BUILTIN_TYPE_MODIFY_VALUE_SECTION_START=
BUILTIN_TYPE_MODIFY_VALUE_SECTION_END=
