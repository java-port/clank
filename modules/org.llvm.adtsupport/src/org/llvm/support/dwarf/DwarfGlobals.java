/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.llvm.support.dwarf;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.StringRef;
import org.llvm.adt.StringSwitchUInt;
import org.llvm.support.llvm_unreachable;


//<editor-fold defaultstate="collapsed" desc="static type DwarfGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.dwarf.DwarfGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf10CaseStringEj;_ZN4llvm5dwarf10getMacinfoENS_9StringRefE;_ZN4llvm5dwarf11getLanguageENS_9StringRefE;_ZN4llvm5dwarf13MacinfoStringEj;_ZN4llvm5dwarf13getVirtualityENS_9StringRefE;_ZN4llvm5dwarf14AtomTypeStringEj;_ZN4llvm5dwarf14ChildrenStringEj;_ZN4llvm5dwarf14LanguageStringEj;_ZN4llvm5dwarf15AttributeStringEj;_ZN4llvm5dwarf15CallFrameStringEj;_ZN4llvm5dwarf15EndianityStringEj;_ZN4llvm5dwarf16ArrayOrderStringEj;_ZN4llvm5dwarf16ConventionStringEj;_ZN4llvm5dwarf16InlineCodeStringEj;_ZN4llvm5dwarf16LNExtendedStringEj;_ZN4llvm5dwarf16LNStandardStringEj;_ZN4llvm5dwarf16VirtualityStringEj;_ZN4llvm5dwarf16VisibilityStringEj;_ZN4llvm5dwarf17DecimalSignStringEj;_ZN4llvm5dwarf18DiscriminantStringEj;_ZN4llvm5dwarf18FormEncodingStringEj;_ZN4llvm5dwarf19AccessibilityStringEj;_ZN4llvm5dwarf19ApplePropertyStringEj;_ZN4llvm5dwarf20AttributeValueStringEtj;_ZN4llvm5dwarf20getAttributeEncodingENS_9StringRefE;_ZN4llvm5dwarf20getCallingConventionENS_9StringRefE;_ZN4llvm5dwarf20getOperationEncodingENS_9StringRefE;_ZN4llvm5dwarf23AttributeEncodingStringEj;_ZN4llvm5dwarf23GDBIndexEntryKindStringENS0_17GDBIndexEntryKindE;_ZN4llvm5dwarf23OperationEncodingStringEj;_ZN4llvm5dwarf26GDBIndexEntryLinkageStringENS0_20GDBIndexEntryLinkageE;_ZN4llvm5dwarf6getTagENS_9StringRefE;_ZN4llvm5dwarf6isTypeENS0_3TagE;_ZN4llvm5dwarf9TagStringEj;_ZN4llvm5dwarfL11DW64_CIE_IDE;_ZN4llvm5dwarfL9DW_CIE_IDE; -static-type=DwarfGlobals -package=org.llvm.support.dwarf")
//</editor-fold>
public final class DwarfGlobals {


// Special ID values that distinguish a CIE from a FDE in DWARF CFI.
// Not inside an enum because a 64-bit value is needed.
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::DW_CIE_ID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 54,
 FQN="llvm::dwarf::DW_CIE_ID", NM="_ZN4llvm5dwarfL9DW_CIE_IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarfL9DW_CIE_IDE")
//</editor-fold>
public static /*const*//*uint32_t*/int DW_CIE_ID = UINT32_MAX;
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::DW64_CIE_ID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 55,
 FQN="llvm::dwarf::DW64_CIE_ID", NM="_ZN4llvm5dwarfL11DW64_CIE_IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarfL11DW64_CIE_IDE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ DW64_CIE_ID = UINT64_MAX;
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::isType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 65,
 FQN="llvm::dwarf::isType", NM="_ZN4llvm5dwarf6isTypeENS0_3TagE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf6isTypeENS0_3TagE")
//</editor-fold>
public static /*inline*/ boolean isType(/*Tag*//*uint16_t*/char T) {
  switch (T) {
   case Tag.DW_TAG_array_type:
   case Tag.DW_TAG_class_type:
   case Tag.DW_TAG_interface_type:
   case Tag.DW_TAG_enumeration_type:
   case Tag.DW_TAG_pointer_type:
   case Tag.DW_TAG_reference_type:
   case Tag.DW_TAG_rvalue_reference_type:
   case Tag.DW_TAG_string_type:
   case Tag.DW_TAG_structure_type:
   case Tag.DW_TAG_subroutine_type:
   case Tag.DW_TAG_union_type:
   case Tag.DW_TAG_ptr_to_member_type:
   case Tag.DW_TAG_set_type:
   case Tag.DW_TAG_subrange_type:
   case Tag.DW_TAG_base_type:
   case Tag.DW_TAG_const_type:
   case Tag.DW_TAG_file_type:
   case Tag.DW_TAG_packed_type:
   case Tag.DW_TAG_volatile_type:
   case Tag.DW_TAG_typedef:
    return true;
   default:
    return false;
  }
}


/// \defgroup DwarfConstantsDumping Dwarf constants dumping functions
///
/// All these functions map their argument's value back to the
/// corresponding enumerator name or return nullptr if the value isn't
/// known.
///
/// @{
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::TagString">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 21,
 FQN="llvm::dwarf::TagString", NM="_ZN4llvm5dwarf9TagStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf9TagStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ TagString(/*uint*/int _Tag) {
  switch (_Tag) {
   default:
    return null;
   case Tag.DW_TAG_array_type:
    return $("DW_TAG_array_type");
   case Tag.DW_TAG_class_type:
    return $("DW_TAG_class_type");
   case Tag.DW_TAG_entry_point:
    return $("DW_TAG_entry_point");
   case Tag.DW_TAG_enumeration_type:
    return $("DW_TAG_enumeration_type");
   case Tag.DW_TAG_formal_parameter:
    return $("DW_TAG_formal_parameter");
   case Tag.DW_TAG_imported_declaration:
    return $("DW_TAG_imported_declaration");
   case Tag.DW_TAG_label:
    return $("DW_TAG_label");
   case Tag.DW_TAG_lexical_block:
    return $("DW_TAG_lexical_block");
   case Tag.DW_TAG_member:
    return $("DW_TAG_member");
   case Tag.DW_TAG_pointer_type:
    return $("DW_TAG_pointer_type");
   case Tag.DW_TAG_reference_type:
    return $("DW_TAG_reference_type");
   case Tag.DW_TAG_compile_unit:
    return $("DW_TAG_compile_unit");
   case Tag.DW_TAG_string_type:
    return $("DW_TAG_string_type");
   case Tag.DW_TAG_structure_type:
    return $("DW_TAG_structure_type");
   case Tag.DW_TAG_subroutine_type:
    return $("DW_TAG_subroutine_type");
   case Tag.DW_TAG_typedef:
    return $("DW_TAG_typedef");
   case Tag.DW_TAG_union_type:
    return $("DW_TAG_union_type");
   case Tag.DW_TAG_unspecified_parameters:
    return $("DW_TAG_unspecified_parameters");
   case Tag.DW_TAG_variant:
    return $("DW_TAG_variant");
   case Tag.DW_TAG_common_block:
    return $("DW_TAG_common_block");
   case Tag.DW_TAG_common_inclusion:
    return $("DW_TAG_common_inclusion");
   case Tag.DW_TAG_inheritance:
    return $("DW_TAG_inheritance");
   case Tag.DW_TAG_inlined_subroutine:
    return $("DW_TAG_inlined_subroutine");
   case Tag.DW_TAG_module:
    return $("DW_TAG_module");
   case Tag.DW_TAG_ptr_to_member_type:
    return $("DW_TAG_ptr_to_member_type");
   case Tag.DW_TAG_set_type:
    return $("DW_TAG_set_type");
   case Tag.DW_TAG_subrange_type:
    return $("DW_TAG_subrange_type");
   case Tag.DW_TAG_with_stmt:
    return $("DW_TAG_with_stmt");
   case Tag.DW_TAG_access_declaration:
    return $("DW_TAG_access_declaration");
   case Tag.DW_TAG_base_type:
    return $("DW_TAG_base_type");
   case Tag.DW_TAG_catch_block:
    return $("DW_TAG_catch_block");
   case Tag.DW_TAG_const_type:
    return $("DW_TAG_const_type");
   case Tag.DW_TAG_constant:
    return $("DW_TAG_constant");
   case Tag.DW_TAG_enumerator:
    return $("DW_TAG_enumerator");
   case Tag.DW_TAG_file_type:
    return $("DW_TAG_file_type");
   case Tag.DW_TAG_friend:
    return $("DW_TAG_friend");
   case Tag.DW_TAG_namelist:
    return $("DW_TAG_namelist");
   case Tag.DW_TAG_namelist_item:
    return $("DW_TAG_namelist_item");
   case Tag.DW_TAG_packed_type:
    return $("DW_TAG_packed_type");
   case Tag.DW_TAG_subprogram:
    return $("DW_TAG_subprogram");
   case Tag.DW_TAG_template_type_parameter:
    return $("DW_TAG_template_type_parameter");
   case Tag.DW_TAG_template_value_parameter:
    return $("DW_TAG_template_value_parameter");
   case Tag.DW_TAG_thrown_type:
    return $("DW_TAG_thrown_type");
   case Tag.DW_TAG_try_block:
    return $("DW_TAG_try_block");
   case Tag.DW_TAG_variant_part:
    return $("DW_TAG_variant_part");
   case Tag.DW_TAG_variable:
    return $("DW_TAG_variable");
   case Tag.DW_TAG_volatile_type:
    return $("DW_TAG_volatile_type");
   case Tag.DW_TAG_dwarf_procedure:
    return $("DW_TAG_dwarf_procedure");
   case Tag.DW_TAG_restrict_type:
    return $("DW_TAG_restrict_type");
   case Tag.DW_TAG_interface_type:
    return $("DW_TAG_interface_type");
   case Tag.DW_TAG_namespace:
    return $("DW_TAG_namespace");
   case Tag.DW_TAG_imported_module:
    return $("DW_TAG_imported_module");
   case Tag.DW_TAG_unspecified_type:
    return $("DW_TAG_unspecified_type");
   case Tag.DW_TAG_partial_unit:
    return $("DW_TAG_partial_unit");
   case Tag.DW_TAG_imported_unit:
    return $("DW_TAG_imported_unit");
   case Tag.DW_TAG_condition:
    return $("DW_TAG_condition");
   case Tag.DW_TAG_shared_type:
    return $("DW_TAG_shared_type");
   case Tag.DW_TAG_type_unit:
    return $("DW_TAG_type_unit");
   case Tag.DW_TAG_rvalue_reference_type:
    return $("DW_TAG_rvalue_reference_type");
   case Tag.DW_TAG_template_alias:
    return $("DW_TAG_template_alias");
   case Tag.DW_TAG_coarray_type:
    
    // New in DWARF v5.
    return $("DW_TAG_coarray_type");
   case Tag.DW_TAG_generic_subrange:
    return $("DW_TAG_generic_subrange");
   case Tag.DW_TAG_dynamic_type:
    return $("DW_TAG_dynamic_type");
   case Tag.DW_TAG_MIPS_loop:
    
    // User-defined tags.
    return $("DW_TAG_MIPS_loop");
   case Tag.DW_TAG_format_label:
    return $("DW_TAG_format_label");
   case Tag.DW_TAG_function_template:
    return $("DW_TAG_function_template");
   case Tag.DW_TAG_class_template:
    return $("DW_TAG_class_template");
   case Tag.DW_TAG_GNU_template_template_param:
    return $("DW_TAG_GNU_template_template_param");
   case Tag.DW_TAG_GNU_template_parameter_pack:
    return $("DW_TAG_GNU_template_parameter_pack");
   case Tag.DW_TAG_GNU_formal_parameter_pack:
    return $("DW_TAG_GNU_formal_parameter_pack");
   case Tag.DW_TAG_APPLE_property:
    return $("DW_TAG_APPLE_property");
   case Tag.DW_TAG_BORLAND_property:
    return $("DW_TAG_BORLAND_property");
   case Tag.DW_TAG_BORLAND_Delphi_string:
    return $("DW_TAG_BORLAND_Delphi_string");
   case Tag.DW_TAG_BORLAND_Delphi_dynamic_array:
    return $("DW_TAG_BORLAND_Delphi_dynamic_array");
   case Tag.DW_TAG_BORLAND_Delphi_set:
    return $("DW_TAG_BORLAND_Delphi_set");
   case Tag.DW_TAG_BORLAND_Delphi_variant:
    return $("DW_TAG_BORLAND_Delphi_variant");
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::ChildrenString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 38,
 FQN="llvm::dwarf::ChildrenString", NM="_ZN4llvm5dwarf14ChildrenStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf14ChildrenStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ChildrenString(/*uint*/int Children) {
  switch (Children) {
   case Constants.DW_CHILDREN_no:
    return $("DW_CHILDREN_no");
   case Constants.DW_CHILDREN_yes:
    return $("DW_CHILDREN_yes");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::AttributeString">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 46,
 FQN="llvm::dwarf::AttributeString", NM="_ZN4llvm5dwarf15AttributeStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf15AttributeStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ AttributeString(/*uint*/int _Attribute) {
  switch (_Attribute) {
   case Attribute.DW_AT_sibling:
    return $("DW_AT_sibling");
   case Attribute.DW_AT_location:
    return $("DW_AT_location");
   case Attribute.DW_AT_name:
    return $("DW_AT_name");
   case Attribute.DW_AT_ordering:
    return $("DW_AT_ordering");
   case Attribute.DW_AT_byte_size:
    return $("DW_AT_byte_size");
   case Attribute.DW_AT_bit_offset:
    return $("DW_AT_bit_offset");
   case Attribute.DW_AT_bit_size:
    return $("DW_AT_bit_size");
   case Attribute.DW_AT_stmt_list:
    return $("DW_AT_stmt_list");
   case Attribute.DW_AT_low_pc:
    return $("DW_AT_low_pc");
   case Attribute.DW_AT_high_pc:
    return $("DW_AT_high_pc");
   case Attribute.DW_AT_language:
    return $("DW_AT_language");
   case Attribute.DW_AT_discr:
    return $("DW_AT_discr");
   case Attribute.DW_AT_discr_value:
    return $("DW_AT_discr_value");
   case Attribute.DW_AT_visibility:
    return $("DW_AT_visibility");
   case Attribute.DW_AT_import:
    return $("DW_AT_import");
   case Attribute.DW_AT_string_length:
    return $("DW_AT_string_length");
   case Attribute.DW_AT_common_reference:
    return $("DW_AT_common_reference");
   case Attribute.DW_AT_comp_dir:
    return $("DW_AT_comp_dir");
   case Attribute.DW_AT_const_value:
    return $("DW_AT_const_value");
   case Attribute.DW_AT_containing_type:
    return $("DW_AT_containing_type");
   case Attribute.DW_AT_default_value:
    return $("DW_AT_default_value");
   case Attribute.DW_AT_inline:
    return $("DW_AT_inline");
   case Attribute.DW_AT_is_optional:
    return $("DW_AT_is_optional");
   case Attribute.DW_AT_lower_bound:
    return $("DW_AT_lower_bound");
   case Attribute.DW_AT_producer:
    return $("DW_AT_producer");
   case Attribute.DW_AT_prototyped:
    return $("DW_AT_prototyped");
   case Attribute.DW_AT_return_addr:
    return $("DW_AT_return_addr");
   case Attribute.DW_AT_start_scope:
    return $("DW_AT_start_scope");
   case Attribute.DW_AT_bit_stride:
    return $("DW_AT_bit_stride");
   case Attribute.DW_AT_upper_bound:
    return $("DW_AT_upper_bound");
   case Attribute.DW_AT_abstract_origin:
    return $("DW_AT_abstract_origin");
   case Attribute.DW_AT_accessibility:
    return $("DW_AT_accessibility");
   case Attribute.DW_AT_address_class:
    return $("DW_AT_address_class");
   case Attribute.DW_AT_artificial:
    return $("DW_AT_artificial");
   case Attribute.DW_AT_base_types:
    return $("DW_AT_base_types");
   case Attribute.DW_AT_calling_convention:
    return $("DW_AT_calling_convention");
   case Attribute.DW_AT_count:
    return $("DW_AT_count");
   case Attribute.DW_AT_data_member_location:
    return $("DW_AT_data_member_location");
   case Attribute.DW_AT_decl_column:
    return $("DW_AT_decl_column");
   case Attribute.DW_AT_decl_file:
    return $("DW_AT_decl_file");
   case Attribute.DW_AT_decl_line:
    return $("DW_AT_decl_line");
   case Attribute.DW_AT_declaration:
    return $("DW_AT_declaration");
   case Attribute.DW_AT_discr_list:
    return $("DW_AT_discr_list");
   case Attribute.DW_AT_encoding:
    return $("DW_AT_encoding");
   case Attribute.DW_AT_external:
    return $("DW_AT_external");
   case Attribute.DW_AT_frame_base:
    return $("DW_AT_frame_base");
   case Attribute.DW_AT_friend:
    return $("DW_AT_friend");
   case Attribute.DW_AT_identifier_case:
    return $("DW_AT_identifier_case");
   case Attribute.DW_AT_macro_info:
    return $("DW_AT_macro_info");
   case Attribute.DW_AT_namelist_item:
    return $("DW_AT_namelist_item");
   case Attribute.DW_AT_priority:
    return $("DW_AT_priority");
   case Attribute.DW_AT_segment:
    return $("DW_AT_segment");
   case Attribute.DW_AT_specification:
    return $("DW_AT_specification");
   case Attribute.DW_AT_static_link:
    return $("DW_AT_static_link");
   case Attribute.DW_AT_type:
    return $("DW_AT_type");
   case Attribute.DW_AT_use_location:
    return $("DW_AT_use_location");
   case Attribute.DW_AT_variable_parameter:
    return $("DW_AT_variable_parameter");
   case Attribute.DW_AT_virtuality:
    return $("DW_AT_virtuality");
   case Attribute.DW_AT_vtable_elem_location:
    return $("DW_AT_vtable_elem_location");
   case Attribute.DW_AT_allocated:
    return $("DW_AT_allocated");
   case Attribute.DW_AT_associated:
    return $("DW_AT_associated");
   case Attribute.DW_AT_data_location:
    return $("DW_AT_data_location");
   case Attribute.DW_AT_byte_stride:
    return $("DW_AT_byte_stride");
   case Attribute.DW_AT_entry_pc:
    return $("DW_AT_entry_pc");
   case Attribute.DW_AT_use_UTF8:
    return $("DW_AT_use_UTF8");
   case Attribute.DW_AT_extension:
    return $("DW_AT_extension");
   case Attribute.DW_AT_ranges:
    return $("DW_AT_ranges");
   case Attribute.DW_AT_trampoline:
    return $("DW_AT_trampoline");
   case Attribute.DW_AT_call_column:
    return $("DW_AT_call_column");
   case Attribute.DW_AT_call_file:
    return $("DW_AT_call_file");
   case Attribute.DW_AT_call_line:
    return $("DW_AT_call_line");
   case Attribute.DW_AT_description:
    return $("DW_AT_description");
   case Attribute.DW_AT_binary_scale:
    return $("DW_AT_binary_scale");
   case Attribute.DW_AT_decimal_scale:
    return $("DW_AT_decimal_scale");
   case Attribute.DW_AT_small:
    return $("DW_AT_small");
   case Attribute.DW_AT_decimal_sign:
    return $("DW_AT_decimal_sign");
   case Attribute.DW_AT_digit_count:
    return $("DW_AT_digit_count");
   case Attribute.DW_AT_picture_string:
    return $("DW_AT_picture_string");
   case Attribute.DW_AT_mutable:
    return $("DW_AT_mutable");
   case Attribute.DW_AT_threads_scaled:
    return $("DW_AT_threads_scaled");
   case Attribute.DW_AT_explicit:
    return $("DW_AT_explicit");
   case Attribute.DW_AT_object_pointer:
    return $("DW_AT_object_pointer");
   case Attribute.DW_AT_endianity:
    return $("DW_AT_endianity");
   case Attribute.DW_AT_elemental:
    return $("DW_AT_elemental");
   case Attribute.DW_AT_pure:
    return $("DW_AT_pure");
   case Attribute.DW_AT_recursive:
    return $("DW_AT_recursive");
   case Attribute.DW_AT_signature:
    return $("DW_AT_signature");
   case Attribute.DW_AT_main_subprogram:
    return $("DW_AT_main_subprogram");
   case Attribute.DW_AT_data_bit_offset:
    return $("DW_AT_data_bit_offset");
   case Attribute.DW_AT_const_expr:
    return $("DW_AT_const_expr");
   case Attribute.DW_AT_enum_class:
    return $("DW_AT_enum_class");
   case Attribute.DW_AT_linkage_name:
    return $("DW_AT_linkage_name");
   case Attribute.DW_AT_string_length_bit_size:
    return $("DW_AT_string_length_bit_size");
   case Attribute.DW_AT_string_length_byte_size:
    return $("DW_AT_string_length_byte_size");
   case Attribute.DW_AT_rank:
    return $("DW_AT_rank");
   case Attribute.DW_AT_str_offsets_base:
    return $("DW_AT_str_offsets_base");
   case Attribute.DW_AT_addr_base:
    return $("DW_AT_addr_base");
   case Attribute.DW_AT_ranges_base:
    return $("DW_AT_ranges_base");
   case Attribute.DW_AT_dwo_id:
    return $("DW_AT_dwo_id");
   case Attribute.DW_AT_dwo_name:
    return $("DW_AT_dwo_name");
   case Attribute.DW_AT_reference:
    return $("DW_AT_reference");
   case Attribute.DW_AT_rvalue_reference:
    return $("DW_AT_rvalue_reference");
   case Attribute.DW_AT_MIPS_loop_begin:
    return $("DW_AT_MIPS_loop_begin");
   case Attribute.DW_AT_MIPS_tail_loop_begin:
    return $("DW_AT_MIPS_tail_loop_begin");
   case Attribute.DW_AT_MIPS_epilog_begin:
    return $("DW_AT_MIPS_epilog_begin");
   case Attribute.DW_AT_MIPS_loop_unroll_factor:
    return $("DW_AT_MIPS_loop_unroll_factor");
   case Attribute.DW_AT_MIPS_software_pipeline_depth:
    return $("DW_AT_MIPS_software_pipeline_depth");
   case Attribute.DW_AT_MIPS_linkage_name:
    return $("DW_AT_MIPS_linkage_name");
   case Attribute.DW_AT_MIPS_stride:
    return $("DW_AT_MIPS_stride");
   case Attribute.DW_AT_MIPS_abstract_name:
    return $("DW_AT_MIPS_abstract_name");
   case Attribute.DW_AT_MIPS_clone_origin:
    return $("DW_AT_MIPS_clone_origin");
   case Attribute.DW_AT_MIPS_has_inlines:
    return $("DW_AT_MIPS_has_inlines");
   case Attribute.DW_AT_MIPS_stride_byte:
    return $("DW_AT_MIPS_stride_byte");
   case Attribute.DW_AT_MIPS_stride_elem:
    return $("DW_AT_MIPS_stride_elem");
   case Attribute.DW_AT_MIPS_ptr_dopetype:
    return $("DW_AT_MIPS_ptr_dopetype");
   case Attribute.DW_AT_MIPS_allocatable_dopetype:
    return $("DW_AT_MIPS_allocatable_dopetype");
   case Attribute.DW_AT_MIPS_assumed_shape_dopetype:
    return $("DW_AT_MIPS_assumed_shape_dopetype");
   case Attribute.DW_AT_sf_names:
    return $("DW_AT_sf_names");
   case Attribute.DW_AT_src_info:
    return $("DW_AT_src_info");
   case Attribute.DW_AT_mac_info:
    return $("DW_AT_mac_info");
   case Attribute.DW_AT_src_coords:
    return $("DW_AT_src_coords");
   case Attribute.DW_AT_body_begin:
    return $("DW_AT_body_begin");
   case Attribute.DW_AT_body_end:
    return $("DW_AT_body_end");
   case Attribute.DW_AT_GNU_vector:
    return $("DW_AT_GNU_vector");
   case Attribute.DW_AT_GNU_template_name:
    return $("DW_AT_GNU_template_name");
   case Attribute.DW_AT_GNU_odr_signature:
    return $("DW_AT_GNU_odr_signature");
   case Attribute.DW_AT_MIPS_assumed_size:
    return $("DW_AT_MIPS_assumed_size");
   case Attribute.DW_AT_lo_user:
    return $("DW_AT_lo_user");
   case Attribute.DW_AT_hi_user:
    return $("DW_AT_hi_user");
   case Attribute.DW_AT_BORLAND_property_read:
    return $("DW_AT_BORLAND_property_read");
   case Attribute.DW_AT_BORLAND_property_write:
    return $("DW_AT_BORLAND_property_write");
   case Attribute.DW_AT_BORLAND_property_implements:
    return $("DW_AT_BORLAND_property_implements");
   case Attribute.DW_AT_BORLAND_property_index:
    return $("DW_AT_BORLAND_property_index");
   case Attribute.DW_AT_BORLAND_property_default:
    return $("DW_AT_BORLAND_property_default");
   case Attribute.DW_AT_BORLAND_Delphi_unit:
    return $("DW_AT_BORLAND_Delphi_unit");
   case Attribute.DW_AT_BORLAND_Delphi_class:
    return $("DW_AT_BORLAND_Delphi_class");
   case Attribute.DW_AT_BORLAND_Delphi_record:
    return $("DW_AT_BORLAND_Delphi_record");
   case Attribute.DW_AT_BORLAND_Delphi_metaclass:
    return $("DW_AT_BORLAND_Delphi_metaclass");
   case Attribute.DW_AT_BORLAND_Delphi_constructor:
    return $("DW_AT_BORLAND_Delphi_constructor");
   case Attribute.DW_AT_BORLAND_Delphi_destructor:
    return $("DW_AT_BORLAND_Delphi_destructor");
   case Attribute.DW_AT_BORLAND_Delphi_anonymous_method:
    return $("DW_AT_BORLAND_Delphi_anonymous_method");
   case Attribute.DW_AT_BORLAND_Delphi_interface:
    return $("DW_AT_BORLAND_Delphi_interface");
   case Attribute.DW_AT_BORLAND_Delphi_ABI:
    return $("DW_AT_BORLAND_Delphi_ABI");
   case Attribute.DW_AT_BORLAND_Delphi_return:
    return $("DW_AT_BORLAND_Delphi_return");
   case Attribute.DW_AT_BORLAND_Delphi_frameptr:
    return $("DW_AT_BORLAND_Delphi_frameptr");
   case Attribute.DW_AT_BORLAND_closure:
    return $("DW_AT_BORLAND_closure");
   case Attribute.DW_AT_APPLE_optimized:
    return $("DW_AT_APPLE_optimized");
   case Attribute.DW_AT_APPLE_flags:
    return $("DW_AT_APPLE_flags");
   case Attribute.DW_AT_APPLE_isa:
    return $("DW_AT_APPLE_isa");
   case Attribute.DW_AT_APPLE_block:
    return $("DW_AT_APPLE_block");
   case Attribute.DW_AT_APPLE_major_runtime_vers:
    return $("DW_AT_APPLE_major_runtime_vers");
   case Attribute.DW_AT_APPLE_runtime_class:
    return $("DW_AT_APPLE_runtime_class");
   case Attribute.DW_AT_APPLE_omit_frame_ptr:
    return $("DW_AT_APPLE_omit_frame_ptr");
   case Attribute.DW_AT_APPLE_property_name:
    return $("DW_AT_APPLE_property_name");
   case Attribute.DW_AT_APPLE_property_getter:
    return $("DW_AT_APPLE_property_getter");
   case Attribute.DW_AT_APPLE_property_setter:
    return $("DW_AT_APPLE_property_setter");
   case Attribute.DW_AT_APPLE_property_attribute:
    return $("DW_AT_APPLE_property_attribute");
   case Attribute.DW_AT_APPLE_property:
    return $("DW_AT_APPLE_property");
   case Attribute.DW_AT_APPLE_objc_complete_type:
    return $("DW_AT_APPLE_objc_complete_type");
   case Attribute.DW_AT_LLVM_include_path:
    return $("DW_AT_LLVM_include_path");
   case Attribute.DW_AT_LLVM_config_macros:
    return $("DW_AT_LLVM_config_macros");
   case Attribute.DW_AT_LLVM_isysroot:
    return $("DW_AT_LLVM_isysroot");
   case Attribute.DW_AT_GNU_dwo_name:
    
    // DWARF5 Fission Extension Attribute
    return $("DW_AT_GNU_dwo_name");
   case Attribute.DW_AT_GNU_dwo_id:
    return $("DW_AT_GNU_dwo_id");
   case Attribute.DW_AT_GNU_ranges_base:
    return $("DW_AT_GNU_ranges_base");
   case Attribute.DW_AT_GNU_addr_base:
    return $("DW_AT_GNU_addr_base");
   case Attribute.DW_AT_GNU_pubnames:
    return $("DW_AT_GNU_pubnames");
   case Attribute.DW_AT_GNU_pubtypes:
    return $("DW_AT_GNU_pubtypes");
   case Attribute.DW_AT_GNU_discriminator:
    return $("DW_AT_GNU_discriminator");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::FormEncodingString">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 226,
 FQN="llvm::dwarf::FormEncodingString", NM="_ZN4llvm5dwarf18FormEncodingStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf18FormEncodingStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ FormEncodingString(/*uint*/int _Encoding) {
  switch (_Encoding) {
   case Form.DW_FORM_addr:
    return $("DW_FORM_addr");
   case Form.DW_FORM_block2:
    return $("DW_FORM_block2");
   case Form.DW_FORM_block4:
    return $("DW_FORM_block4");
   case Form.DW_FORM_data2:
    return $("DW_FORM_data2");
   case Form.DW_FORM_data4:
    return $("DW_FORM_data4");
   case Form.DW_FORM_data8:
    return $("DW_FORM_data8");
   case Form.DW_FORM_string:
    return $("DW_FORM_string");
   case Form.DW_FORM_block:
    return $("DW_FORM_block");
   case Form.DW_FORM_block1:
    return $("DW_FORM_block1");
   case Form.DW_FORM_data1:
    return $("DW_FORM_data1");
   case Form.DW_FORM_flag:
    return $("DW_FORM_flag");
   case Form.DW_FORM_sdata:
    return $("DW_FORM_sdata");
   case Form.DW_FORM_strp:
    return $("DW_FORM_strp");
   case Form.DW_FORM_udata:
    return $("DW_FORM_udata");
   case Form.DW_FORM_ref_addr:
    return $("DW_FORM_ref_addr");
   case Form.DW_FORM_ref1:
    return $("DW_FORM_ref1");
   case Form.DW_FORM_ref2:
    return $("DW_FORM_ref2");
   case Form.DW_FORM_ref4:
    return $("DW_FORM_ref4");
   case Form.DW_FORM_ref8:
    return $("DW_FORM_ref8");
   case Form.DW_FORM_ref_udata:
    return $("DW_FORM_ref_udata");
   case Form.DW_FORM_indirect:
    return $("DW_FORM_indirect");
   case Form.DW_FORM_sec_offset:
    return $("DW_FORM_sec_offset");
   case Form.DW_FORM_exprloc:
    return $("DW_FORM_exprloc");
   case Form.DW_FORM_flag_present:
    return $("DW_FORM_flag_present");
   case Form.DW_FORM_ref_sig8:
    return $("DW_FORM_ref_sig8");
   case Form.DW_FORM_GNU_addr_index:
    
    // DWARF5 Fission Extension Forms
    return $("DW_FORM_GNU_addr_index");
   case Form.DW_FORM_GNU_str_index:
    return $("DW_FORM_GNU_str_index");
   case Form.DW_FORM_GNU_ref_alt:
    
    // Alternate debug sections proposal (output of "dwz" tool).
    return $("DW_FORM_GNU_ref_alt");
   case Form.DW_FORM_GNU_strp_alt:
    return $("DW_FORM_GNU_strp_alt");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::OperationEncodingString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 265,
 FQN="llvm::dwarf::OperationEncodingString", NM="_ZN4llvm5dwarf23OperationEncodingStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf23OperationEncodingStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ OperationEncodingString(/*uint*/int Encoding) {
  switch (Encoding) {
   default:
    return null;
   case LocationAtom.DW_OP_addr:
    return $("DW_OP_addr");
   case LocationAtom.DW_OP_deref:
    return $("DW_OP_deref");
   case LocationAtom.DW_OP_const1u:
    return $("DW_OP_const1u");
   case LocationAtom.DW_OP_const1s:
    return $("DW_OP_const1s");
   case LocationAtom.DW_OP_const2u:
    return $("DW_OP_const2u");
   case LocationAtom.DW_OP_const2s:
    return $("DW_OP_const2s");
   case LocationAtom.DW_OP_const4u:
    return $("DW_OP_const4u");
   case LocationAtom.DW_OP_const4s:
    return $("DW_OP_const4s");
   case LocationAtom.DW_OP_const8u:
    return $("DW_OP_const8u");
   case LocationAtom.DW_OP_const8s:
    return $("DW_OP_const8s");
   case LocationAtom.DW_OP_constu:
    return $("DW_OP_constu");
   case LocationAtom.DW_OP_consts:
    return $("DW_OP_consts");
   case LocationAtom.DW_OP_dup:
    return $("DW_OP_dup");
   case LocationAtom.DW_OP_drop:
    return $("DW_OP_drop");
   case LocationAtom.DW_OP_over:
    return $("DW_OP_over");
   case LocationAtom.DW_OP_pick:
    return $("DW_OP_pick");
   case LocationAtom.DW_OP_swap:
    return $("DW_OP_swap");
   case LocationAtom.DW_OP_rot:
    return $("DW_OP_rot");
   case LocationAtom.DW_OP_xderef:
    return $("DW_OP_xderef");
   case LocationAtom.DW_OP_abs:
    return $("DW_OP_abs");
   case LocationAtom.DW_OP_and:
    return $("DW_OP_and");
   case LocationAtom.DW_OP_div:
    return $("DW_OP_div");
   case LocationAtom.DW_OP_minus:
    return $("DW_OP_minus");
   case LocationAtom.DW_OP_mod:
    return $("DW_OP_mod");
   case LocationAtom.DW_OP_mul:
    return $("DW_OP_mul");
   case LocationAtom.DW_OP_neg:
    return $("DW_OP_neg");
   case LocationAtom.DW_OP_not:
    return $("DW_OP_not");
   case LocationAtom.DW_OP_or:
    return $("DW_OP_or");
   case LocationAtom.DW_OP_plus:
    return $("DW_OP_plus");
   case LocationAtom.DW_OP_plus_uconst:
    return $("DW_OP_plus_uconst");
   case LocationAtom.DW_OP_shl:
    return $("DW_OP_shl");
   case LocationAtom.DW_OP_shr:
    return $("DW_OP_shr");
   case LocationAtom.DW_OP_shra:
    return $("DW_OP_shra");
   case LocationAtom.DW_OP_xor:
    return $("DW_OP_xor");
   case LocationAtom.DW_OP_skip:
    return $("DW_OP_skip");
   case LocationAtom.DW_OP_bra:
    return $("DW_OP_bra");
   case LocationAtom.DW_OP_eq:
    return $("DW_OP_eq");
   case LocationAtom.DW_OP_ge:
    return $("DW_OP_ge");
   case LocationAtom.DW_OP_gt:
    return $("DW_OP_gt");
   case LocationAtom.DW_OP_le:
    return $("DW_OP_le");
   case LocationAtom.DW_OP_lt:
    return $("DW_OP_lt");
   case LocationAtom.DW_OP_ne:
    return $("DW_OP_ne");
   case LocationAtom.DW_OP_lit0:
    return $("DW_OP_lit0");
   case LocationAtom.DW_OP_lit1:
    return $("DW_OP_lit1");
   case LocationAtom.DW_OP_lit2:
    return $("DW_OP_lit2");
   case LocationAtom.DW_OP_lit3:
    return $("DW_OP_lit3");
   case LocationAtom.DW_OP_lit4:
    return $("DW_OP_lit4");
   case LocationAtom.DW_OP_lit5:
    return $("DW_OP_lit5");
   case LocationAtom.DW_OP_lit6:
    return $("DW_OP_lit6");
   case LocationAtom.DW_OP_lit7:
    return $("DW_OP_lit7");
   case LocationAtom.DW_OP_lit8:
    return $("DW_OP_lit8");
   case LocationAtom.DW_OP_lit9:
    return $("DW_OP_lit9");
   case LocationAtom.DW_OP_lit10:
    return $("DW_OP_lit10");
   case LocationAtom.DW_OP_lit11:
    return $("DW_OP_lit11");
   case LocationAtom.DW_OP_lit12:
    return $("DW_OP_lit12");
   case LocationAtom.DW_OP_lit13:
    return $("DW_OP_lit13");
   case LocationAtom.DW_OP_lit14:
    return $("DW_OP_lit14");
   case LocationAtom.DW_OP_lit15:
    return $("DW_OP_lit15");
   case LocationAtom.DW_OP_lit16:
    return $("DW_OP_lit16");
   case LocationAtom.DW_OP_lit17:
    return $("DW_OP_lit17");
   case LocationAtom.DW_OP_lit18:
    return $("DW_OP_lit18");
   case LocationAtom.DW_OP_lit19:
    return $("DW_OP_lit19");
   case LocationAtom.DW_OP_lit20:
    return $("DW_OP_lit20");
   case LocationAtom.DW_OP_lit21:
    return $("DW_OP_lit21");
   case LocationAtom.DW_OP_lit22:
    return $("DW_OP_lit22");
   case LocationAtom.DW_OP_lit23:
    return $("DW_OP_lit23");
   case LocationAtom.DW_OP_lit24:
    return $("DW_OP_lit24");
   case LocationAtom.DW_OP_lit25:
    return $("DW_OP_lit25");
   case LocationAtom.DW_OP_lit26:
    return $("DW_OP_lit26");
   case LocationAtom.DW_OP_lit27:
    return $("DW_OP_lit27");
   case LocationAtom.DW_OP_lit28:
    return $("DW_OP_lit28");
   case LocationAtom.DW_OP_lit29:
    return $("DW_OP_lit29");
   case LocationAtom.DW_OP_lit30:
    return $("DW_OP_lit30");
   case LocationAtom.DW_OP_lit31:
    return $("DW_OP_lit31");
   case LocationAtom.DW_OP_reg0:
    return $("DW_OP_reg0");
   case LocationAtom.DW_OP_reg1:
    return $("DW_OP_reg1");
   case LocationAtom.DW_OP_reg2:
    return $("DW_OP_reg2");
   case LocationAtom.DW_OP_reg3:
    return $("DW_OP_reg3");
   case LocationAtom.DW_OP_reg4:
    return $("DW_OP_reg4");
   case LocationAtom.DW_OP_reg5:
    return $("DW_OP_reg5");
   case LocationAtom.DW_OP_reg6:
    return $("DW_OP_reg6");
   case LocationAtom.DW_OP_reg7:
    return $("DW_OP_reg7");
   case LocationAtom.DW_OP_reg8:
    return $("DW_OP_reg8");
   case LocationAtom.DW_OP_reg9:
    return $("DW_OP_reg9");
   case LocationAtom.DW_OP_reg10:
    return $("DW_OP_reg10");
   case LocationAtom.DW_OP_reg11:
    return $("DW_OP_reg11");
   case LocationAtom.DW_OP_reg12:
    return $("DW_OP_reg12");
   case LocationAtom.DW_OP_reg13:
    return $("DW_OP_reg13");
   case LocationAtom.DW_OP_reg14:
    return $("DW_OP_reg14");
   case LocationAtom.DW_OP_reg15:
    return $("DW_OP_reg15");
   case LocationAtom.DW_OP_reg16:
    return $("DW_OP_reg16");
   case LocationAtom.DW_OP_reg17:
    return $("DW_OP_reg17");
   case LocationAtom.DW_OP_reg18:
    return $("DW_OP_reg18");
   case LocationAtom.DW_OP_reg19:
    return $("DW_OP_reg19");
   case LocationAtom.DW_OP_reg20:
    return $("DW_OP_reg20");
   case LocationAtom.DW_OP_reg21:
    return $("DW_OP_reg21");
   case LocationAtom.DW_OP_reg22:
    return $("DW_OP_reg22");
   case LocationAtom.DW_OP_reg23:
    return $("DW_OP_reg23");
   case LocationAtom.DW_OP_reg24:
    return $("DW_OP_reg24");
   case LocationAtom.DW_OP_reg25:
    return $("DW_OP_reg25");
   case LocationAtom.DW_OP_reg26:
    return $("DW_OP_reg26");
   case LocationAtom.DW_OP_reg27:
    return $("DW_OP_reg27");
   case LocationAtom.DW_OP_reg28:
    return $("DW_OP_reg28");
   case LocationAtom.DW_OP_reg29:
    return $("DW_OP_reg29");
   case LocationAtom.DW_OP_reg30:
    return $("DW_OP_reg30");
   case LocationAtom.DW_OP_reg31:
    return $("DW_OP_reg31");
   case LocationAtom.DW_OP_breg0:
    return $("DW_OP_breg0");
   case LocationAtom.DW_OP_breg1:
    return $("DW_OP_breg1");
   case LocationAtom.DW_OP_breg2:
    return $("DW_OP_breg2");
   case LocationAtom.DW_OP_breg3:
    return $("DW_OP_breg3");
   case LocationAtom.DW_OP_breg4:
    return $("DW_OP_breg4");
   case LocationAtom.DW_OP_breg5:
    return $("DW_OP_breg5");
   case LocationAtom.DW_OP_breg6:
    return $("DW_OP_breg6");
   case LocationAtom.DW_OP_breg7:
    return $("DW_OP_breg7");
   case LocationAtom.DW_OP_breg8:
    return $("DW_OP_breg8");
   case LocationAtom.DW_OP_breg9:
    return $("DW_OP_breg9");
   case LocationAtom.DW_OP_breg10:
    return $("DW_OP_breg10");
   case LocationAtom.DW_OP_breg11:
    return $("DW_OP_breg11");
   case LocationAtom.DW_OP_breg12:
    return $("DW_OP_breg12");
   case LocationAtom.DW_OP_breg13:
    return $("DW_OP_breg13");
   case LocationAtom.DW_OP_breg14:
    return $("DW_OP_breg14");
   case LocationAtom.DW_OP_breg15:
    return $("DW_OP_breg15");
   case LocationAtom.DW_OP_breg16:
    return $("DW_OP_breg16");
   case LocationAtom.DW_OP_breg17:
    return $("DW_OP_breg17");
   case LocationAtom.DW_OP_breg18:
    return $("DW_OP_breg18");
   case LocationAtom.DW_OP_breg19:
    return $("DW_OP_breg19");
   case LocationAtom.DW_OP_breg20:
    return $("DW_OP_breg20");
   case LocationAtom.DW_OP_breg21:
    return $("DW_OP_breg21");
   case LocationAtom.DW_OP_breg22:
    return $("DW_OP_breg22");
   case LocationAtom.DW_OP_breg23:
    return $("DW_OP_breg23");
   case LocationAtom.DW_OP_breg24:
    return $("DW_OP_breg24");
   case LocationAtom.DW_OP_breg25:
    return $("DW_OP_breg25");
   case LocationAtom.DW_OP_breg26:
    return $("DW_OP_breg26");
   case LocationAtom.DW_OP_breg27:
    return $("DW_OP_breg27");
   case LocationAtom.DW_OP_breg28:
    return $("DW_OP_breg28");
   case LocationAtom.DW_OP_breg29:
    return $("DW_OP_breg29");
   case LocationAtom.DW_OP_breg30:
    return $("DW_OP_breg30");
   case LocationAtom.DW_OP_breg31:
    return $("DW_OP_breg31");
   case LocationAtom.DW_OP_regx:
    return $("DW_OP_regx");
   case LocationAtom.DW_OP_fbreg:
    return $("DW_OP_fbreg");
   case LocationAtom.DW_OP_bregx:
    return $("DW_OP_bregx");
   case LocationAtom.DW_OP_piece:
    return $("DW_OP_piece");
   case LocationAtom.DW_OP_deref_size:
    return $("DW_OP_deref_size");
   case LocationAtom.DW_OP_xderef_size:
    return $("DW_OP_xderef_size");
   case LocationAtom.DW_OP_nop:
    return $("DW_OP_nop");
   case LocationAtom.DW_OP_push_object_address:
    return $("DW_OP_push_object_address");
   case LocationAtom.DW_OP_call2:
    return $("DW_OP_call2");
   case LocationAtom.DW_OP_call4:
    return $("DW_OP_call4");
   case LocationAtom.DW_OP_call_ref:
    return $("DW_OP_call_ref");
   case LocationAtom.DW_OP_form_tls_address:
    return $("DW_OP_form_tls_address");
   case LocationAtom.DW_OP_call_frame_cfa:
    return $("DW_OP_call_frame_cfa");
   case LocationAtom.DW_OP_bit_piece:
    return $("DW_OP_bit_piece");
   case LocationAtom.DW_OP_implicit_value:
    return $("DW_OP_implicit_value");
   case LocationAtom.DW_OP_stack_value:
    return $("DW_OP_stack_value");
   case LocationAtom.DW_OP_GNU_push_tls_address:
    
    // Extensions for GNU-style thread-local storage.
    return $("DW_OP_GNU_push_tls_address");
   case LocationAtom.DW_OP_GNU_addr_index:
    
    // Extensions for Fission proposal.
    return $("DW_OP_GNU_addr_index");
   case LocationAtom.DW_OP_GNU_const_index:
    return $("DW_OP_GNU_const_index");
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::AttributeEncodingString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 282,
 FQN="llvm::dwarf::AttributeEncodingString", NM="_ZN4llvm5dwarf23AttributeEncodingStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf23AttributeEncodingStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ AttributeEncodingString(/*uint*/int Encoding) {
  switch (Encoding) {
   default:
    return null;
   case TypeKind.DW_ATE_address:
    
    // DWARF attribute type encodings.
    return $("DW_ATE_address");
   case TypeKind.DW_ATE_boolean:
    return $("DW_ATE_boolean");
   case TypeKind.DW_ATE_complex_float:
    return $("DW_ATE_complex_float");
   case TypeKind.DW_ATE_float:
    return $("DW_ATE_float");
   case TypeKind.DW_ATE_signed:
    return $("DW_ATE_signed");
   case TypeKind.DW_ATE_signed_char:
    return $("DW_ATE_signed_char");
   case TypeKind.DW_ATE_unsigned:
    return $("DW_ATE_unsigned");
   case TypeKind.DW_ATE_unsigned_char:
    return $("DW_ATE_unsigned_char");
   case TypeKind.DW_ATE_imaginary_float:
    return $("DW_ATE_imaginary_float");
   case TypeKind.DW_ATE_packed_decimal:
    return $("DW_ATE_packed_decimal");
   case TypeKind.DW_ATE_numeric_string:
    return $("DW_ATE_numeric_string");
   case TypeKind.DW_ATE_edited:
    return $("DW_ATE_edited");
   case TypeKind.DW_ATE_signed_fixed:
    return $("DW_ATE_signed_fixed");
   case TypeKind.DW_ATE_unsigned_fixed:
    return $("DW_ATE_unsigned_fixed");
   case TypeKind.DW_ATE_decimal_float:
    return $("DW_ATE_decimal_float");
   case TypeKind.DW_ATE_UTF:
    return $("DW_ATE_UTF");
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::DecimalSignString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 299,
 FQN="llvm::dwarf::DecimalSignString", NM="_ZN4llvm5dwarf17DecimalSignStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf17DecimalSignStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ DecimalSignString(/*uint*/int Sign) {
  switch (Sign) {
   case DecimalSignEncoding.DW_DS_unsigned:
    return $("DW_DS_unsigned");
   case DecimalSignEncoding.DW_DS_leading_overpunch:
    return $("DW_DS_leading_overpunch");
   case DecimalSignEncoding.DW_DS_trailing_overpunch:
    return $("DW_DS_trailing_overpunch");
   case DecimalSignEncoding.DW_DS_leading_separate:
    return $("DW_DS_leading_separate");
   case DecimalSignEncoding.DW_DS_trailing_separate:
    return $("DW_DS_trailing_separate");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::EndianityString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 310,
 FQN="llvm::dwarf::EndianityString", NM="_ZN4llvm5dwarf15EndianityStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf15EndianityStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ EndianityString(/*uint*/int Endian) {
  switch (Endian) {
   case EndianityEncoding.DW_END_default:
    return $("DW_END_default");
   case EndianityEncoding.DW_END_big:
    return $("DW_END_big");
   case EndianityEncoding.DW_END_little:
    return $("DW_END_little");
   case EndianityEncoding.DW_END_lo_user:
    return $("DW_END_lo_user");
   case EndianityEncoding.DW_END_hi_user:
    return $("DW_END_hi_user");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::AccessibilityString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 321,
 FQN="llvm::dwarf::AccessibilityString", NM="_ZN4llvm5dwarf19AccessibilityStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf19AccessibilityStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ AccessibilityString(/*uint*/int Access) {
  switch (Access) {
   case AccessAttribute.DW_ACCESS_public:
    // Accessibility codes
    return $("DW_ACCESS_public");
   case AccessAttribute.DW_ACCESS_protected:
    return $("DW_ACCESS_protected");
   case AccessAttribute.DW_ACCESS_private:
    return $("DW_ACCESS_private");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::VisibilityString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 331,
 FQN="llvm::dwarf::VisibilityString", NM="_ZN4llvm5dwarf16VisibilityStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf16VisibilityStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ VisibilityString(/*uint*/int Visibility) {
  switch (Visibility) {
   case VisibilityAttribute.DW_VIS_local:
    return $("DW_VIS_local");
   case VisibilityAttribute.DW_VIS_exported:
    return $("DW_VIS_exported");
   case VisibilityAttribute.DW_VIS_qualified:
    return $("DW_VIS_qualified");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::VirtualityString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 340,
 FQN="llvm::dwarf::VirtualityString", NM="_ZN4llvm5dwarf16VirtualityStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf16VirtualityStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ VirtualityString(/*uint*/int Virtuality) {
  switch (Virtuality) {
   default:
    return null;
   case VirtualityAttribute.DW_VIRTUALITY_none:
    
    // DWARF virtuality codes.
    return $("DW_VIRTUALITY_none");
   case VirtualityAttribute.DW_VIRTUALITY_virtual:
    return $("DW_VIRTUALITY_virtual");
   case VirtualityAttribute.DW_VIRTUALITY_pure_virtual:
    return $("DW_VIRTUALITY_pure_virtual");
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::LanguageString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 359,
 FQN="llvm::dwarf::LanguageString", NM="_ZN4llvm5dwarf14LanguageStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf14LanguageStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LanguageString(/*uint*/int Language) {
  switch (Language) {
   default:
    return null;
   case SourceLanguage.DW_LANG_C89:
    
    // DWARF languages.
    return $("DW_LANG_C89");
   case SourceLanguage.DW_LANG_C:
    return $("DW_LANG_C");
   case SourceLanguage.DW_LANG_Ada83:
    return $("DW_LANG_Ada83");
   case SourceLanguage.DW_LANG_C_plus_plus:
    return $("DW_LANG_C_plus_plus");
   case SourceLanguage.DW_LANG_Cobol74:
    return $("DW_LANG_Cobol74");
   case SourceLanguage.DW_LANG_Cobol85:
    return $("DW_LANG_Cobol85");
   case SourceLanguage.DW_LANG_Fortran77:
    return $("DW_LANG_Fortran77");
   case SourceLanguage.DW_LANG_Fortran90:
    return $("DW_LANG_Fortran90");
   case SourceLanguage.DW_LANG_Pascal83:
    return $("DW_LANG_Pascal83");
   case SourceLanguage.DW_LANG_Modula2:
    return $("DW_LANG_Modula2");
   case SourceLanguage.DW_LANG_Java:
    return $("DW_LANG_Java");
   case SourceLanguage.DW_LANG_C99:
    return $("DW_LANG_C99");
   case SourceLanguage.DW_LANG_Ada95:
    return $("DW_LANG_Ada95");
   case SourceLanguage.DW_LANG_Fortran95:
    return $("DW_LANG_Fortran95");
   case SourceLanguage.DW_LANG_PLI:
    return $("DW_LANG_PLI");
   case SourceLanguage.DW_LANG_ObjC:
    return $("DW_LANG_ObjC");
   case SourceLanguage.DW_LANG_ObjC_plus_plus:
    return $("DW_LANG_ObjC_plus_plus");
   case SourceLanguage.DW_LANG_UPC:
    return $("DW_LANG_UPC");
   case SourceLanguage.DW_LANG_D:
    return $("DW_LANG_D");
   case SourceLanguage.DW_LANG_Python:
    
    // New in DWARF 5:
    return $("DW_LANG_Python");
   case SourceLanguage.DW_LANG_OpenCL:
    return $("DW_LANG_OpenCL");
   case SourceLanguage.DW_LANG_Go:
    return $("DW_LANG_Go");
   case SourceLanguage.DW_LANG_Modula3:
    return $("DW_LANG_Modula3");
   case SourceLanguage.DW_LANG_Haskell:
    return $("DW_LANG_Haskell");
   case SourceLanguage.DW_LANG_C_plus_plus_03:
    return $("DW_LANG_C_plus_plus_03");
   case SourceLanguage.DW_LANG_C_plus_plus_11:
    return $("DW_LANG_C_plus_plus_11");
   case SourceLanguage.DW_LANG_OCaml:
    return $("DW_LANG_OCaml");
   case SourceLanguage.DW_LANG_Rust:
    return $("DW_LANG_Rust");
   case SourceLanguage.DW_LANG_C11:
    return $("DW_LANG_C11");
   case SourceLanguage.DW_LANG_Swift:
    return $("DW_LANG_Swift");
   case SourceLanguage.DW_LANG_Julia:
    return $("DW_LANG_Julia");
   case SourceLanguage.DW_LANG_Dylan:
    return $("DW_LANG_Dylan");
   case SourceLanguage.DW_LANG_C_plus_plus_14:
    return $("DW_LANG_C_plus_plus_14");
   case SourceLanguage.DW_LANG_Fortran03:
    return $("DW_LANG_Fortran03");
   case SourceLanguage.DW_LANG_Fortran08:
    return $("DW_LANG_Fortran08");
   case SourceLanguage.DW_LANG_Mips_Assembler:
    return $("DW_LANG_Mips_Assembler");
   case SourceLanguage.DW_LANG_GOOGLE_RenderScript:
    return $("DW_LANG_GOOGLE_RenderScript");
   case SourceLanguage.DW_LANG_BORLAND_Delphi:
    return $("DW_LANG_BORLAND_Delphi");
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::CaseString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 377,
 FQN="llvm::dwarf::CaseString", NM="_ZN4llvm5dwarf10CaseStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf10CaseStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CaseString(/*uint*/int Case) {
  switch (Case) {
   case CaseSensitivity.DW_ID_case_sensitive:
    return $("DW_ID_case_sensitive");
   case CaseSensitivity.DW_ID_up_case:
    return $("DW_ID_up_case");
   case CaseSensitivity.DW_ID_down_case:
    return $("DW_ID_down_case");
   case CaseSensitivity.DW_ID_case_insensitive:
    return $("DW_ID_case_insensitive");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::ConventionString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 387,
 FQN="llvm::dwarf::ConventionString", NM="_ZN4llvm5dwarf16ConventionStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf16ConventionStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ConventionString(/*uint*/int CC) {
  switch (CC) {
   default:
    return null;
   case CallingConvention.DW_CC_normal:
    
    // DWARF calling convention codes.
    return $("DW_CC_normal");
   case CallingConvention.DW_CC_program:
    return $("DW_CC_program");
   case CallingConvention.DW_CC_nocall:
    return $("DW_CC_nocall");
   case CallingConvention.DW_CC_GNU_borland_fastcall_i386:
    return $("DW_CC_GNU_borland_fastcall_i386");
   case CallingConvention.DW_CC_BORLAND_safecall:
    return $("DW_CC_BORLAND_safecall");
   case CallingConvention.DW_CC_BORLAND_stdcall:
    return $("DW_CC_BORLAND_stdcall");
   case CallingConvention.DW_CC_BORLAND_pascal:
    return $("DW_CC_BORLAND_pascal");
   case CallingConvention.DW_CC_BORLAND_msfastcall:
    return $("DW_CC_BORLAND_msfastcall");
   case CallingConvention.DW_CC_BORLAND_msreturn:
    return $("DW_CC_BORLAND_msreturn");
   case CallingConvention.DW_CC_BORLAND_thiscall:
    return $("DW_CC_BORLAND_thiscall");
   case CallingConvention.DW_CC_BORLAND_fastcall:
    return $("DW_CC_BORLAND_fastcall");
   case CallingConvention.DW_CC_LLVM_vectorcall:
    return $("DW_CC_LLVM_vectorcall");
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::InlineCodeString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 405,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 406,
 FQN="llvm::dwarf::InlineCodeString", NM="_ZN4llvm5dwarf16InlineCodeStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf16InlineCodeStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ InlineCodeString(/*uint*/int Code) {
  switch (Code) {
   case InlineAttribute.DW_INL_not_inlined:
    return $("DW_INL_not_inlined");
   case InlineAttribute.DW_INL_inlined:
    return $("DW_INL_inlined");
   case InlineAttribute.DW_INL_declared_not_inlined:
    return $("DW_INL_declared_not_inlined");
   case InlineAttribute.DW_INL_declared_inlined:
    return $("DW_INL_declared_inlined");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::ArrayOrderString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 415,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 416,
 FQN="llvm::dwarf::ArrayOrderString", NM="_ZN4llvm5dwarf16ArrayOrderStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf16ArrayOrderStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ArrayOrderString(/*uint*/int Order) {
  switch (Order) {
   case ArrayDimensionOrdering.DW_ORD_row_major:
    return $("DW_ORD_row_major");
   case ArrayDimensionOrdering.DW_ORD_col_major:
    return $("DW_ORD_col_major");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::DiscriminantString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 423,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 424,
 FQN="llvm::dwarf::DiscriminantString", NM="_ZN4llvm5dwarf18DiscriminantStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf18DiscriminantStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ DiscriminantString(/*uint*/int Discriminant) {
  switch (Discriminant) {
   case DiscriminantList.DW_DSC_label:
    return $("DW_DSC_label");
   case DiscriminantList.DW_DSC_range:
    return $("DW_DSC_range");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::LNStandardString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 431,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 432,
 FQN="llvm::dwarf::LNStandardString", NM="_ZN4llvm5dwarf16LNStandardStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf16LNStandardStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LNStandardString(/*uint*/int Standard) {
  switch (Standard) {
   case LineNumberOps.DW_LNS_copy:
    return $("DW_LNS_copy");
   case LineNumberOps.DW_LNS_advance_pc:
    return $("DW_LNS_advance_pc");
   case LineNumberOps.DW_LNS_advance_line:
    return $("DW_LNS_advance_line");
   case LineNumberOps.DW_LNS_set_file:
    return $("DW_LNS_set_file");
   case LineNumberOps.DW_LNS_set_column:
    return $("DW_LNS_set_column");
   case LineNumberOps.DW_LNS_negate_stmt:
    return $("DW_LNS_negate_stmt");
   case LineNumberOps.DW_LNS_set_basic_block:
    return $("DW_LNS_set_basic_block");
   case LineNumberOps.DW_LNS_const_add_pc:
    return $("DW_LNS_const_add_pc");
   case LineNumberOps.DW_LNS_fixed_advance_pc:
    return $("DW_LNS_fixed_advance_pc");
   case LineNumberOps.DW_LNS_set_prologue_end:
    return $("DW_LNS_set_prologue_end");
   case LineNumberOps.DW_LNS_set_epilogue_begin:
    return $("DW_LNS_set_epilogue_begin");
   case LineNumberOps.DW_LNS_set_isa:
    return $("DW_LNS_set_isa");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::LNExtendedString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 449,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 450,
 FQN="llvm::dwarf::LNExtendedString", NM="_ZN4llvm5dwarf16LNExtendedStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf16LNExtendedStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ LNExtendedString(/*uint*/int Encoding) {
  switch (Encoding) {
   case LineNumberExtendedOps.DW_LNE_end_sequence:
    // Line Number Extended Opcode Encodings
    return $("DW_LNE_end_sequence");
   case LineNumberExtendedOps.DW_LNE_set_address:
    return $("DW_LNE_set_address");
   case LineNumberExtendedOps.DW_LNE_define_file:
    return $("DW_LNE_define_file");
   case LineNumberExtendedOps.DW_LNE_set_discriminator:
    return $("DW_LNE_set_discriminator");
   case LineNumberExtendedOps.DW_LNE_lo_user:
    return $("DW_LNE_lo_user");
   case LineNumberExtendedOps.DW_LNE_hi_user:
    return $("DW_LNE_hi_user");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::MacinfoString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 462,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 463,
 FQN="llvm::dwarf::MacinfoString", NM="_ZN4llvm5dwarf13MacinfoStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf13MacinfoStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ MacinfoString(/*uint*/int Encoding) {
  switch (LLVMConstants.valueOf(Encoding).getValue()) {
   case MacinfoRecordType.DW_MACINFO_define:
    // Macinfo Type Encodings
    return $("DW_MACINFO_define");
   case MacinfoRecordType.DW_MACINFO_undef:
    return $("DW_MACINFO_undef");
   case MacinfoRecordType.DW_MACINFO_start_file:
    return $("DW_MACINFO_start_file");
   case MacinfoRecordType.DW_MACINFO_end_file:
    return $("DW_MACINFO_end_file");
   case MacinfoRecordType.DW_MACINFO_vendor_ext:
    return $("DW_MACINFO_vendor_ext");
   case ~0://LLVMConstants.DW_MACINFO_invalid.getValue():
    return $("DW_MACINFO_invalid");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::CallFrameString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 485,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 486,
 FQN="llvm::dwarf::CallFrameString", NM="_ZN4llvm5dwarf15CallFrameStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf15CallFrameStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CallFrameString(/*uint*/int Encoding) {
  switch (Encoding) {
   case CallFrameInfo.DW_CFA_nop:
    return $("DW_CFA_nop");
   case CallFrameInfo.DW_CFA_advance_loc:
    return $("DW_CFA_advance_loc");
   case CallFrameInfo.DW_CFA_offset:
    return $("DW_CFA_offset");
   case CallFrameInfo.DW_CFA_restore:
    return $("DW_CFA_restore");
   case CallFrameInfo.DW_CFA_set_loc:
    return $("DW_CFA_set_loc");
   case CallFrameInfo.DW_CFA_advance_loc1:
    return $("DW_CFA_advance_loc1");
   case CallFrameInfo.DW_CFA_advance_loc2:
    return $("DW_CFA_advance_loc2");
   case CallFrameInfo.DW_CFA_advance_loc4:
    return $("DW_CFA_advance_loc4");
   case CallFrameInfo.DW_CFA_offset_extended:
    return $("DW_CFA_offset_extended");
   case CallFrameInfo.DW_CFA_restore_extended:
    return $("DW_CFA_restore_extended");
   case CallFrameInfo.DW_CFA_undefined:
    return $("DW_CFA_undefined");
   case CallFrameInfo.DW_CFA_same_value:
    return $("DW_CFA_same_value");
   case CallFrameInfo.DW_CFA_register:
    return $("DW_CFA_register");
   case CallFrameInfo.DW_CFA_remember_state:
    return $("DW_CFA_remember_state");
   case CallFrameInfo.DW_CFA_restore_state:
    return $("DW_CFA_restore_state");
   case CallFrameInfo.DW_CFA_def_cfa:
    return $("DW_CFA_def_cfa");
   case CallFrameInfo.DW_CFA_def_cfa_register:
    return $("DW_CFA_def_cfa_register");
   case CallFrameInfo.DW_CFA_def_cfa_offset:
    return $("DW_CFA_def_cfa_offset");
   case CallFrameInfo.DW_CFA_def_cfa_expression:
    return $("DW_CFA_def_cfa_expression");
   case CallFrameInfo.DW_CFA_expression:
    return $("DW_CFA_expression");
   case CallFrameInfo.DW_CFA_offset_extended_sf:
    return $("DW_CFA_offset_extended_sf");
   case CallFrameInfo.DW_CFA_def_cfa_sf:
    return $("DW_CFA_def_cfa_sf");
   case CallFrameInfo.DW_CFA_def_cfa_offset_sf:
    return $("DW_CFA_def_cfa_offset_sf");
   case CallFrameInfo.DW_CFA_val_offset:
    return $("DW_CFA_val_offset");
   case CallFrameInfo.DW_CFA_val_offset_sf:
    return $("DW_CFA_val_offset_sf");
   case CallFrameInfo.DW_CFA_val_expression:
    return $("DW_CFA_val_expression");
   case CallFrameInfo.DW_CFA_MIPS_advance_loc8:
    return $("DW_CFA_MIPS_advance_loc8");
   case CallFrameInfo.DW_CFA_GNU_window_save:
    return $("DW_CFA_GNU_window_save");
   case CallFrameInfo.DW_CFA_GNU_args_size:
    return $("DW_CFA_GNU_args_size");
   case CallFrameInfo.DW_CFA_lo_user:
    return $("DW_CFA_lo_user");
   case CallFrameInfo.DW_CFA_hi_user:
    return $("DW_CFA_hi_user");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::ApplePropertyString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 522,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 523,
 FQN="llvm::dwarf::ApplePropertyString", NM="_ZN4llvm5dwarf19ApplePropertyStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf19ApplePropertyStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ApplePropertyString(/*uint*/int Prop) {
  switch (Prop) {
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_readonly:
    return $("DW_APPLE_PROPERTY_readonly");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_getter:
    return $("DW_APPLE_PROPERTY_getter");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_assign:
    return $("DW_APPLE_PROPERTY_assign");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_readwrite:
    return $("DW_APPLE_PROPERTY_readwrite");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_retain:
    return $("DW_APPLE_PROPERTY_retain");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_copy:
    return $("DW_APPLE_PROPERTY_copy");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_nonatomic:
    return $("DW_APPLE_PROPERTY_nonatomic");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_setter:
    return $("DW_APPLE_PROPERTY_setter");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_atomic:
    return $("DW_APPLE_PROPERTY_atomic");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_weak:
    return $("DW_APPLE_PROPERTY_weak");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_strong:
    return $("DW_APPLE_PROPERTY_strong");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_unsafe_unretained:
    return $("DW_APPLE_PROPERTY_unsafe_unretained");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_nullability:
    return $("DW_APPLE_PROPERTY_nullability");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_null_resettable:
    return $("DW_APPLE_PROPERTY_null_resettable");
   case ApplePropertyAttributes.DW_APPLE_PROPERTY_class:
    return $("DW_APPLE_PROPERTY_class");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::AtomTypeString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 558,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 553,
 FQN="llvm::dwarf::AtomTypeString", NM="_ZN4llvm5dwarf14AtomTypeStringEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf14AtomTypeStringEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ AtomTypeString(/*uint*/int AT) {
  switch (AcceleratorTable.valueOf(AT)) {
   case DW_ATOM_null:
    return $("DW_ATOM_null");
   case DW_ATOM_die_offset:
    return $("DW_ATOM_die_offset");
   case DW_ATOM_cu_offset:
    return $("DW_ATOM_cu_offset");
   case DW_ATOM_die_tag:
    return $("DW_ATOM_die_tag");
   case DW_ATOM_type_flags:
    return $("DW_ATOM_type_flags");
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::GDBIndexEntryKindString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 574,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 569,
 FQN="llvm::dwarf::GDBIndexEntryKindString", NM="_ZN4llvm5dwarf23GDBIndexEntryKindStringENS0_17GDBIndexEntryKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf23GDBIndexEntryKindStringENS0_17GDBIndexEntryKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ GDBIndexEntryKindString(GDBIndexEntryKind Kind) {
  switch (Kind) {
   case GIEK_NONE:
    return $("NONE");
   case GIEK_TYPE:
    return $("TYPE");
   case GIEK_VARIABLE:
    return $("VARIABLE");
   case GIEK_FUNCTION:
    return $("FUNCTION");
   case GIEK_OTHER:
    return $("OTHER");
   case GIEK_UNUSED5:
    return $("UNUSED5");
   case GIEK_UNUSED6:
    return $("UNUSED6");
   case GIEK_UNUSED7:
    return $("UNUSED7");
  }
  throw new llvm_unreachable("Unknown GDBIndexEntryKind value");
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::GDBIndexEntryLinkageString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 596,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 591,
 FQN="llvm::dwarf::GDBIndexEntryLinkageString", NM="_ZN4llvm5dwarf26GDBIndexEntryLinkageStringENS0_20GDBIndexEntryLinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf26GDBIndexEntryLinkageStringENS0_20GDBIndexEntryLinkageE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ GDBIndexEntryLinkageString(GDBIndexEntryLinkage Linkage) {
  switch (Linkage) {
   case GIEL_EXTERNAL:
    return $("EXTERNAL");
   case GIEL_STATIC:
    return $("STATIC");
  }
  throw new llvm_unreachable("Unknown GDBIndexEntryLinkage value");
}

/// @}

/// \defgroup DwarfConstantsParsing Dwarf constants parsing functions
///
/// These functions map their strings back to the corresponding enumeration
/// value or return 0 if there is none, except for these exceptions:
///
/// \li \a getTag() returns \a DW_TAG_invalid on invalid input.
/// \li \a getVirtuality() returns \a DW_VIRTUALITY_invalid on invalid input.
/// \li \a getMacinfo() returns \a DW_MACINFO_invalid on invalid input.
///
/// @{
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::getTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 31,
 FQN="llvm::dwarf::getTag", NM="_ZN4llvm5dwarf6getTagENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf6getTagENS_9StringRefE")
//</editor-fold>
public static /*uint*/int getTag(StringRef TagString) {
  return new StringSwitchUInt(/*NO_COPY*/TagString).
      Case(/*KEEP_STR*/"DW_TAG_array_type", $ushort2uint(Tag.DW_TAG_array_type)).
      Case(/*KEEP_STR*/"DW_TAG_class_type", $ushort2uint(Tag.DW_TAG_class_type)).
      Case(/*KEEP_STR*/"DW_TAG_entry_point", $ushort2uint(Tag.DW_TAG_entry_point)).
      Case(/*KEEP_STR*/"DW_TAG_enumeration_type", $ushort2uint(Tag.DW_TAG_enumeration_type)).
      Case(/*KEEP_STR*/"DW_TAG_formal_parameter", $ushort2uint(Tag.DW_TAG_formal_parameter)).
      Case(/*KEEP_STR*/"DW_TAG_imported_declaration", $ushort2uint(Tag.DW_TAG_imported_declaration)).
      Case(/*KEEP_STR*/"DW_TAG_label", $ushort2uint(Tag.DW_TAG_label)).
      Case(/*KEEP_STR*/"DW_TAG_lexical_block", $ushort2uint(Tag.DW_TAG_lexical_block)).
      Case(/*KEEP_STR*/"DW_TAG_member", $ushort2uint(Tag.DW_TAG_member)).
      Case(/*KEEP_STR*/"DW_TAG_pointer_type", $ushort2uint(Tag.DW_TAG_pointer_type)).
      Case(/*KEEP_STR*/"DW_TAG_reference_type", $ushort2uint(Tag.DW_TAG_reference_type)).
      Case(/*KEEP_STR*/"DW_TAG_compile_unit", $ushort2uint(Tag.DW_TAG_compile_unit)).
      Case(/*KEEP_STR*/"DW_TAG_string_type", $ushort2uint(Tag.DW_TAG_string_type)).
      Case(/*KEEP_STR*/"DW_TAG_structure_type", $ushort2uint(Tag.DW_TAG_structure_type)).
      Case(/*KEEP_STR*/"DW_TAG_subroutine_type", $ushort2uint(Tag.DW_TAG_subroutine_type)).
      Case(/*KEEP_STR*/"DW_TAG_typedef", $ushort2uint(Tag.DW_TAG_typedef)).
      Case(/*KEEP_STR*/"DW_TAG_union_type", $ushort2uint(Tag.DW_TAG_union_type)).
      Case(/*KEEP_STR*/"DW_TAG_unspecified_parameters", $ushort2uint(Tag.DW_TAG_unspecified_parameters)).
      Case(/*KEEP_STR*/"DW_TAG_variant", $ushort2uint(Tag.DW_TAG_variant)).
      Case(/*KEEP_STR*/"DW_TAG_common_block", $ushort2uint(Tag.DW_TAG_common_block)).
      Case(/*KEEP_STR*/"DW_TAG_common_inclusion", $ushort2uint(Tag.DW_TAG_common_inclusion)).
      Case(/*KEEP_STR*/"DW_TAG_inheritance", $ushort2uint(Tag.DW_TAG_inheritance)).
      Case(/*KEEP_STR*/"DW_TAG_inlined_subroutine", $ushort2uint(Tag.DW_TAG_inlined_subroutine)).
      Case(/*KEEP_STR*/"DW_TAG_module", $ushort2uint(Tag.DW_TAG_module)).
      Case(/*KEEP_STR*/"DW_TAG_ptr_to_member_type", $ushort2uint(Tag.DW_TAG_ptr_to_member_type)).
      Case(/*KEEP_STR*/"DW_TAG_set_type", $ushort2uint(Tag.DW_TAG_set_type)).
      Case(/*KEEP_STR*/"DW_TAG_subrange_type", $ushort2uint(Tag.DW_TAG_subrange_type)).
      Case(/*KEEP_STR*/"DW_TAG_with_stmt", $ushort2uint(Tag.DW_TAG_with_stmt)).
      Case(/*KEEP_STR*/"DW_TAG_access_declaration", $ushort2uint(Tag.DW_TAG_access_declaration)).
      Case(/*KEEP_STR*/"DW_TAG_base_type", $ushort2uint(Tag.DW_TAG_base_type)).
      Case(/*KEEP_STR*/"DW_TAG_catch_block", $ushort2uint(Tag.DW_TAG_catch_block)).
      Case(/*KEEP_STR*/"DW_TAG_const_type", $ushort2uint(Tag.DW_TAG_const_type)).
      Case(/*KEEP_STR*/"DW_TAG_constant", $ushort2uint(Tag.DW_TAG_constant)).
      Case(/*KEEP_STR*/"DW_TAG_enumerator", $ushort2uint(Tag.DW_TAG_enumerator)).
      Case(/*KEEP_STR*/"DW_TAG_file_type", $ushort2uint(Tag.DW_TAG_file_type)).
      Case(/*KEEP_STR*/"DW_TAG_friend", $ushort2uint(Tag.DW_TAG_friend)).
      Case(/*KEEP_STR*/"DW_TAG_namelist", $ushort2uint(Tag.DW_TAG_namelist)).
      Case(/*KEEP_STR*/"DW_TAG_namelist_item", $ushort2uint(Tag.DW_TAG_namelist_item)).
      Case(/*KEEP_STR*/"DW_TAG_packed_type", $ushort2uint(Tag.DW_TAG_packed_type)).
      Case(/*KEEP_STR*/"DW_TAG_subprogram", $ushort2uint(Tag.DW_TAG_subprogram)).
      Case(/*KEEP_STR*/"DW_TAG_template_type_parameter", $ushort2uint(Tag.DW_TAG_template_type_parameter)).
      Case(/*KEEP_STR*/"DW_TAG_template_value_parameter", $ushort2uint(Tag.DW_TAG_template_value_parameter)).
      Case(/*KEEP_STR*/"DW_TAG_thrown_type", $ushort2uint(Tag.DW_TAG_thrown_type)).
      Case(/*KEEP_STR*/"DW_TAG_try_block", $ushort2uint(Tag.DW_TAG_try_block)).
      Case(/*KEEP_STR*/"DW_TAG_variant_part", $ushort2uint(Tag.DW_TAG_variant_part)).
      Case(/*KEEP_STR*/"DW_TAG_variable", $ushort2uint(Tag.DW_TAG_variable)).
      Case(/*KEEP_STR*/"DW_TAG_volatile_type", $ushort2uint(Tag.DW_TAG_volatile_type)).
      Case(/*KEEP_STR*/"DW_TAG_dwarf_procedure", $ushort2uint(Tag.DW_TAG_dwarf_procedure)).
      Case(/*KEEP_STR*/"DW_TAG_restrict_type", $ushort2uint(Tag.DW_TAG_restrict_type)).
      Case(/*KEEP_STR*/"DW_TAG_interface_type", $ushort2uint(Tag.DW_TAG_interface_type)).
      Case(/*KEEP_STR*/"DW_TAG_namespace", $ushort2uint(Tag.DW_TAG_namespace)).
      Case(/*KEEP_STR*/"DW_TAG_imported_module", $ushort2uint(Tag.DW_TAG_imported_module)).
      Case(/*KEEP_STR*/"DW_TAG_unspecified_type", $ushort2uint(Tag.DW_TAG_unspecified_type)).
      Case(/*KEEP_STR*/"DW_TAG_partial_unit", $ushort2uint(Tag.DW_TAG_partial_unit)).
      Case(/*KEEP_STR*/"DW_TAG_imported_unit", $ushort2uint(Tag.DW_TAG_imported_unit)).
      Case(/*KEEP_STR*/"DW_TAG_condition", $ushort2uint(Tag.DW_TAG_condition)).
      Case(/*KEEP_STR*/"DW_TAG_shared_type", $ushort2uint(Tag.DW_TAG_shared_type)).
      Case(/*KEEP_STR*/"DW_TAG_type_unit", $ushort2uint(Tag.DW_TAG_type_unit)).
      Case(/*KEEP_STR*/"DW_TAG_rvalue_reference_type", $ushort2uint(Tag.DW_TAG_rvalue_reference_type)).
      Case(/*KEEP_STR*/"DW_TAG_template_alias", $ushort2uint(Tag.DW_TAG_template_alias)).
      
      // New in DWARF v5.
      Case(/*KEEP_STR*/"DW_TAG_coarray_type", $ushort2uint(Tag.DW_TAG_coarray_type)).
      Case(/*KEEP_STR*/"DW_TAG_generic_subrange", $ushort2uint(Tag.DW_TAG_generic_subrange)).
      Case(/*KEEP_STR*/"DW_TAG_dynamic_type", $ushort2uint(Tag.DW_TAG_dynamic_type)).
      
      // User-defined tags.
      Case(/*KEEP_STR*/"DW_TAG_MIPS_loop", $ushort2uint(Tag.DW_TAG_MIPS_loop)).
      Case(/*KEEP_STR*/"DW_TAG_format_label", $ushort2uint(Tag.DW_TAG_format_label)).
      Case(/*KEEP_STR*/"DW_TAG_function_template", $ushort2uint(Tag.DW_TAG_function_template)).
      Case(/*KEEP_STR*/"DW_TAG_class_template", $ushort2uint(Tag.DW_TAG_class_template)).
      Case(/*KEEP_STR*/"DW_TAG_GNU_template_template_param", $ushort2uint(Tag.DW_TAG_GNU_template_template_param)).
      Case(/*KEEP_STR*/"DW_TAG_GNU_template_parameter_pack", $ushort2uint(Tag.DW_TAG_GNU_template_parameter_pack)).
      Case(/*KEEP_STR*/"DW_TAG_GNU_formal_parameter_pack", $ushort2uint(Tag.DW_TAG_GNU_formal_parameter_pack)).
      Case(/*KEEP_STR*/"DW_TAG_APPLE_property", $ushort2uint(Tag.DW_TAG_APPLE_property)).
      Case(/*KEEP_STR*/"DW_TAG_BORLAND_property", $ushort2uint(Tag.DW_TAG_BORLAND_property)).
      Case(/*KEEP_STR*/"DW_TAG_BORLAND_Delphi_string", $ushort2uint(Tag.DW_TAG_BORLAND_Delphi_string)).
      Case(/*KEEP_STR*/"DW_TAG_BORLAND_Delphi_dynamic_array", $ushort2uint(Tag.DW_TAG_BORLAND_Delphi_dynamic_array)).
      Case(/*KEEP_STR*/"DW_TAG_BORLAND_Delphi_set", $ushort2uint(Tag.DW_TAG_BORLAND_Delphi_set)).
      Case(/*KEEP_STR*/"DW_TAG_BORLAND_Delphi_variant", $ushort2uint(Tag.DW_TAG_BORLAND_Delphi_variant)).Default(LLVMConstants.DW_TAG_invalid.getValue());
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::getOperationEncoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 275,
 FQN="llvm::dwarf::getOperationEncoding", NM="_ZN4llvm5dwarf20getOperationEncodingENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf20getOperationEncodingENS_9StringRefE")
//</editor-fold>
public static /*uint*/int getOperationEncoding(StringRef OperationEncodingString) {
  return new StringSwitchUInt(/*NO_COPY*/OperationEncodingString).Case(/*KEEP_STR*/"DW_OP_addr", LocationAtom.DW_OP_addr).
      Case(/*KEEP_STR*/"DW_OP_deref", LocationAtom.DW_OP_deref).
      Case(/*KEEP_STR*/"DW_OP_const1u", LocationAtom.DW_OP_const1u).
      Case(/*KEEP_STR*/"DW_OP_const1s", LocationAtom.DW_OP_const1s).
      Case(/*KEEP_STR*/"DW_OP_const2u", LocationAtom.DW_OP_const2u).
      Case(/*KEEP_STR*/"DW_OP_const2s", LocationAtom.DW_OP_const2s).
      Case(/*KEEP_STR*/"DW_OP_const4u", LocationAtom.DW_OP_const4u).
      Case(/*KEEP_STR*/"DW_OP_const4s", LocationAtom.DW_OP_const4s).
      Case(/*KEEP_STR*/"DW_OP_const8u", LocationAtom.DW_OP_const8u).
      Case(/*KEEP_STR*/"DW_OP_const8s", LocationAtom.DW_OP_const8s).
      Case(/*KEEP_STR*/"DW_OP_constu", LocationAtom.DW_OP_constu).
      Case(/*KEEP_STR*/"DW_OP_consts", LocationAtom.DW_OP_consts).
      Case(/*KEEP_STR*/"DW_OP_dup", LocationAtom.DW_OP_dup).
      Case(/*KEEP_STR*/"DW_OP_drop", LocationAtom.DW_OP_drop).
      Case(/*KEEP_STR*/"DW_OP_over", LocationAtom.DW_OP_over).
      Case(/*KEEP_STR*/"DW_OP_pick", LocationAtom.DW_OP_pick).
      Case(/*KEEP_STR*/"DW_OP_swap", LocationAtom.DW_OP_swap).
      Case(/*KEEP_STR*/"DW_OP_rot", LocationAtom.DW_OP_rot).
      Case(/*KEEP_STR*/"DW_OP_xderef", LocationAtom.DW_OP_xderef).
      Case(/*KEEP_STR*/"DW_OP_abs", LocationAtom.DW_OP_abs).
      Case(/*KEEP_STR*/"DW_OP_and", LocationAtom.DW_OP_and).
      Case(/*KEEP_STR*/"DW_OP_div", LocationAtom.DW_OP_div).
      Case(/*KEEP_STR*/"DW_OP_minus", LocationAtom.DW_OP_minus).
      Case(/*KEEP_STR*/"DW_OP_mod", LocationAtom.DW_OP_mod).
      Case(/*KEEP_STR*/"DW_OP_mul", LocationAtom.DW_OP_mul).
      Case(/*KEEP_STR*/"DW_OP_neg", LocationAtom.DW_OP_neg).
      Case(/*KEEP_STR*/"DW_OP_not", LocationAtom.DW_OP_not).
      Case(/*KEEP_STR*/"DW_OP_or", LocationAtom.DW_OP_or).
      Case(/*KEEP_STR*/"DW_OP_plus", LocationAtom.DW_OP_plus).
      Case(/*KEEP_STR*/"DW_OP_plus_uconst", LocationAtom.DW_OP_plus_uconst).
      Case(/*KEEP_STR*/"DW_OP_shl", LocationAtom.DW_OP_shl).
      Case(/*KEEP_STR*/"DW_OP_shr", LocationAtom.DW_OP_shr).
      Case(/*KEEP_STR*/"DW_OP_shra", LocationAtom.DW_OP_shra).
      Case(/*KEEP_STR*/"DW_OP_xor", LocationAtom.DW_OP_xor).
      Case(/*KEEP_STR*/"DW_OP_skip", LocationAtom.DW_OP_skip).
      Case(/*KEEP_STR*/"DW_OP_bra", LocationAtom.DW_OP_bra).
      Case(/*KEEP_STR*/"DW_OP_eq", LocationAtom.DW_OP_eq).
      Case(/*KEEP_STR*/"DW_OP_ge", LocationAtom.DW_OP_ge).
      Case(/*KEEP_STR*/"DW_OP_gt", LocationAtom.DW_OP_gt).
      Case(/*KEEP_STR*/"DW_OP_le", LocationAtom.DW_OP_le).
      Case(/*KEEP_STR*/"DW_OP_lt", LocationAtom.DW_OP_lt).
      Case(/*KEEP_STR*/"DW_OP_ne", LocationAtom.DW_OP_ne).
      Case(/*KEEP_STR*/"DW_OP_lit0", LocationAtom.DW_OP_lit0).
      Case(/*KEEP_STR*/"DW_OP_lit1", LocationAtom.DW_OP_lit1).
      Case(/*KEEP_STR*/"DW_OP_lit2", LocationAtom.DW_OP_lit2).
      Case(/*KEEP_STR*/"DW_OP_lit3", LocationAtom.DW_OP_lit3).
      Case(/*KEEP_STR*/"DW_OP_lit4", LocationAtom.DW_OP_lit4).
      Case(/*KEEP_STR*/"DW_OP_lit5", LocationAtom.DW_OP_lit5).
      Case(/*KEEP_STR*/"DW_OP_lit6", LocationAtom.DW_OP_lit6).
      Case(/*KEEP_STR*/"DW_OP_lit7", LocationAtom.DW_OP_lit7).
      Case(/*KEEP_STR*/"DW_OP_lit8", LocationAtom.DW_OP_lit8).
      Case(/*KEEP_STR*/"DW_OP_lit9", LocationAtom.DW_OP_lit9).
      Case(/*KEEP_STR*/"DW_OP_lit10", LocationAtom.DW_OP_lit10).
      Case(/*KEEP_STR*/"DW_OP_lit11", LocationAtom.DW_OP_lit11).
      Case(/*KEEP_STR*/"DW_OP_lit12", LocationAtom.DW_OP_lit12).
      Case(/*KEEP_STR*/"DW_OP_lit13", LocationAtom.DW_OP_lit13).
      Case(/*KEEP_STR*/"DW_OP_lit14", LocationAtom.DW_OP_lit14).
      Case(/*KEEP_STR*/"DW_OP_lit15", LocationAtom.DW_OP_lit15).
      Case(/*KEEP_STR*/"DW_OP_lit16", LocationAtom.DW_OP_lit16).
      Case(/*KEEP_STR*/"DW_OP_lit17", LocationAtom.DW_OP_lit17).
      Case(/*KEEP_STR*/"DW_OP_lit18", LocationAtom.DW_OP_lit18).
      Case(/*KEEP_STR*/"DW_OP_lit19", LocationAtom.DW_OP_lit19).
      Case(/*KEEP_STR*/"DW_OP_lit20", LocationAtom.DW_OP_lit20).
      Case(/*KEEP_STR*/"DW_OP_lit21", LocationAtom.DW_OP_lit21).
      Case(/*KEEP_STR*/"DW_OP_lit22", LocationAtom.DW_OP_lit22).
      Case(/*KEEP_STR*/"DW_OP_lit23", LocationAtom.DW_OP_lit23).
      Case(/*KEEP_STR*/"DW_OP_lit24", LocationAtom.DW_OP_lit24).
      Case(/*KEEP_STR*/"DW_OP_lit25", LocationAtom.DW_OP_lit25).
      Case(/*KEEP_STR*/"DW_OP_lit26", LocationAtom.DW_OP_lit26).
      Case(/*KEEP_STR*/"DW_OP_lit27", LocationAtom.DW_OP_lit27).
      Case(/*KEEP_STR*/"DW_OP_lit28", LocationAtom.DW_OP_lit28).
      Case(/*KEEP_STR*/"DW_OP_lit29", LocationAtom.DW_OP_lit29).
      Case(/*KEEP_STR*/"DW_OP_lit30", LocationAtom.DW_OP_lit30).
      Case(/*KEEP_STR*/"DW_OP_lit31", LocationAtom.DW_OP_lit31).
      Case(/*KEEP_STR*/"DW_OP_reg0", LocationAtom.DW_OP_reg0).
      Case(/*KEEP_STR*/"DW_OP_reg1", LocationAtom.DW_OP_reg1).
      Case(/*KEEP_STR*/"DW_OP_reg2", LocationAtom.DW_OP_reg2).
      Case(/*KEEP_STR*/"DW_OP_reg3", LocationAtom.DW_OP_reg3).
      Case(/*KEEP_STR*/"DW_OP_reg4", LocationAtom.DW_OP_reg4).
      Case(/*KEEP_STR*/"DW_OP_reg5", LocationAtom.DW_OP_reg5).
      Case(/*KEEP_STR*/"DW_OP_reg6", LocationAtom.DW_OP_reg6).
      Case(/*KEEP_STR*/"DW_OP_reg7", LocationAtom.DW_OP_reg7).
      Case(/*KEEP_STR*/"DW_OP_reg8", LocationAtom.DW_OP_reg8).
      Case(/*KEEP_STR*/"DW_OP_reg9", LocationAtom.DW_OP_reg9).
      Case(/*KEEP_STR*/"DW_OP_reg10", LocationAtom.DW_OP_reg10).
      Case(/*KEEP_STR*/"DW_OP_reg11", LocationAtom.DW_OP_reg11).
      Case(/*KEEP_STR*/"DW_OP_reg12", LocationAtom.DW_OP_reg12).
      Case(/*KEEP_STR*/"DW_OP_reg13", LocationAtom.DW_OP_reg13).
      Case(/*KEEP_STR*/"DW_OP_reg14", LocationAtom.DW_OP_reg14).
      Case(/*KEEP_STR*/"DW_OP_reg15", LocationAtom.DW_OP_reg15).
      Case(/*KEEP_STR*/"DW_OP_reg16", LocationAtom.DW_OP_reg16).
      Case(/*KEEP_STR*/"DW_OP_reg17", LocationAtom.DW_OP_reg17).
      Case(/*KEEP_STR*/"DW_OP_reg18", LocationAtom.DW_OP_reg18).
      Case(/*KEEP_STR*/"DW_OP_reg19", LocationAtom.DW_OP_reg19).
      Case(/*KEEP_STR*/"DW_OP_reg20", LocationAtom.DW_OP_reg20).
      Case(/*KEEP_STR*/"DW_OP_reg21", LocationAtom.DW_OP_reg21).
      Case(/*KEEP_STR*/"DW_OP_reg22", LocationAtom.DW_OP_reg22).
      Case(/*KEEP_STR*/"DW_OP_reg23", LocationAtom.DW_OP_reg23).
      Case(/*KEEP_STR*/"DW_OP_reg24", LocationAtom.DW_OP_reg24).
      Case(/*KEEP_STR*/"DW_OP_reg25", LocationAtom.DW_OP_reg25).
      Case(/*KEEP_STR*/"DW_OP_reg26", LocationAtom.DW_OP_reg26).
      Case(/*KEEP_STR*/"DW_OP_reg27", LocationAtom.DW_OP_reg27).
      Case(/*KEEP_STR*/"DW_OP_reg28", LocationAtom.DW_OP_reg28).
      Case(/*KEEP_STR*/"DW_OP_reg29", LocationAtom.DW_OP_reg29).
      Case(/*KEEP_STR*/"DW_OP_reg30", LocationAtom.DW_OP_reg30).
      Case(/*KEEP_STR*/"DW_OP_reg31", LocationAtom.DW_OP_reg31).
      Case(/*KEEP_STR*/"DW_OP_breg0", LocationAtom.DW_OP_breg0).
      Case(/*KEEP_STR*/"DW_OP_breg1", LocationAtom.DW_OP_breg1).
      Case(/*KEEP_STR*/"DW_OP_breg2", LocationAtom.DW_OP_breg2).
      Case(/*KEEP_STR*/"DW_OP_breg3", LocationAtom.DW_OP_breg3).
      Case(/*KEEP_STR*/"DW_OP_breg4", LocationAtom.DW_OP_breg4).
      Case(/*KEEP_STR*/"DW_OP_breg5", LocationAtom.DW_OP_breg5).
      Case(/*KEEP_STR*/"DW_OP_breg6", LocationAtom.DW_OP_breg6).
      Case(/*KEEP_STR*/"DW_OP_breg7", LocationAtom.DW_OP_breg7).
      Case(/*KEEP_STR*/"DW_OP_breg8", LocationAtom.DW_OP_breg8).
      Case(/*KEEP_STR*/"DW_OP_breg9", LocationAtom.DW_OP_breg9).
      Case(/*KEEP_STR*/"DW_OP_breg10", LocationAtom.DW_OP_breg10).
      Case(/*KEEP_STR*/"DW_OP_breg11", LocationAtom.DW_OP_breg11).
      Case(/*KEEP_STR*/"DW_OP_breg12", LocationAtom.DW_OP_breg12).
      Case(/*KEEP_STR*/"DW_OP_breg13", LocationAtom.DW_OP_breg13).
      Case(/*KEEP_STR*/"DW_OP_breg14", LocationAtom.DW_OP_breg14).
      Case(/*KEEP_STR*/"DW_OP_breg15", LocationAtom.DW_OP_breg15).
      Case(/*KEEP_STR*/"DW_OP_breg16", LocationAtom.DW_OP_breg16).
      Case(/*KEEP_STR*/"DW_OP_breg17", LocationAtom.DW_OP_breg17).
      Case(/*KEEP_STR*/"DW_OP_breg18", LocationAtom.DW_OP_breg18).
      Case(/*KEEP_STR*/"DW_OP_breg19", LocationAtom.DW_OP_breg19).
      Case(/*KEEP_STR*/"DW_OP_breg20", LocationAtom.DW_OP_breg20).
      Case(/*KEEP_STR*/"DW_OP_breg21", LocationAtom.DW_OP_breg21).
      Case(/*KEEP_STR*/"DW_OP_breg22", LocationAtom.DW_OP_breg22).
      Case(/*KEEP_STR*/"DW_OP_breg23", LocationAtom.DW_OP_breg23).
      Case(/*KEEP_STR*/"DW_OP_breg24", LocationAtom.DW_OP_breg24).
      Case(/*KEEP_STR*/"DW_OP_breg25", LocationAtom.DW_OP_breg25).
      Case(/*KEEP_STR*/"DW_OP_breg26", LocationAtom.DW_OP_breg26).
      Case(/*KEEP_STR*/"DW_OP_breg27", LocationAtom.DW_OP_breg27).
      Case(/*KEEP_STR*/"DW_OP_breg28", LocationAtom.DW_OP_breg28).
      Case(/*KEEP_STR*/"DW_OP_breg29", LocationAtom.DW_OP_breg29).
      Case(/*KEEP_STR*/"DW_OP_breg30", LocationAtom.DW_OP_breg30).
      Case(/*KEEP_STR*/"DW_OP_breg31", LocationAtom.DW_OP_breg31).
      Case(/*KEEP_STR*/"DW_OP_regx", LocationAtom.DW_OP_regx).
      Case(/*KEEP_STR*/"DW_OP_fbreg", LocationAtom.DW_OP_fbreg).
      Case(/*KEEP_STR*/"DW_OP_bregx", LocationAtom.DW_OP_bregx).
      Case(/*KEEP_STR*/"DW_OP_piece", LocationAtom.DW_OP_piece).
      Case(/*KEEP_STR*/"DW_OP_deref_size", LocationAtom.DW_OP_deref_size).
      Case(/*KEEP_STR*/"DW_OP_xderef_size", LocationAtom.DW_OP_xderef_size).
      Case(/*KEEP_STR*/"DW_OP_nop", LocationAtom.DW_OP_nop).
      Case(/*KEEP_STR*/"DW_OP_push_object_address", LocationAtom.DW_OP_push_object_address).
      Case(/*KEEP_STR*/"DW_OP_call2", LocationAtom.DW_OP_call2).
      Case(/*KEEP_STR*/"DW_OP_call4", LocationAtom.DW_OP_call4).
      Case(/*KEEP_STR*/"DW_OP_call_ref", LocationAtom.DW_OP_call_ref).
      Case(/*KEEP_STR*/"DW_OP_form_tls_address", LocationAtom.DW_OP_form_tls_address).
      Case(/*KEEP_STR*/"DW_OP_call_frame_cfa", LocationAtom.DW_OP_call_frame_cfa).
      Case(/*KEEP_STR*/"DW_OP_bit_piece", LocationAtom.DW_OP_bit_piece).
      Case(/*KEEP_STR*/"DW_OP_implicit_value", LocationAtom.DW_OP_implicit_value).
      Case(/*KEEP_STR*/"DW_OP_stack_value", LocationAtom.DW_OP_stack_value).
      
      // Extensions for GNU-style thread-local storage.
      Case(/*KEEP_STR*/"DW_OP_GNU_push_tls_address", LocationAtom.DW_OP_GNU_push_tls_address).
      
      // Extensions for Fission proposal.
      Case(/*KEEP_STR*/"DW_OP_GNU_addr_index", LocationAtom.DW_OP_GNU_addr_index).
      Case(/*KEEP_STR*/"DW_OP_GNU_const_index", LocationAtom.DW_OP_GNU_const_index).Default(0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::getVirtuality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 351,
 FQN="llvm::dwarf::getVirtuality", NM="_ZN4llvm5dwarf13getVirtualityENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf13getVirtualityENS_9StringRefE")
//</editor-fold>
public static /*uint*/int getVirtuality(StringRef VirtualityString) {
  return new StringSwitchUInt(/*NO_COPY*/VirtualityString).
      // DWARF virtuality codes.
      Case(/*KEEP_STR*/"DW_VIRTUALITY_none", VirtualityAttribute.DW_VIRTUALITY_none).
      Case(/*KEEP_STR*/"DW_VIRTUALITY_virtual", VirtualityAttribute.DW_VIRTUALITY_virtual).
      Case(/*KEEP_STR*/"DW_VIRTUALITY_pure_virtual", VirtualityAttribute.DW_VIRTUALITY_pure_virtual).
      Default(LLVMConstants.DW_VIRTUALITY_invalid.getValue());
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::getLanguage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 370,
 FQN="llvm::dwarf::getLanguage", NM="_ZN4llvm5dwarf11getLanguageENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf11getLanguageENS_9StringRefE")
//</editor-fold>
public static /*uint*/int getLanguage(StringRef LanguageString) {
  return new StringSwitchUInt(/*NO_COPY*/LanguageString).
      // DWARF languages.
      Case(/*KEEP_STR*/"DW_LANG_C89", SourceLanguage.DW_LANG_C89).
      Case(/*KEEP_STR*/"DW_LANG_C", SourceLanguage.DW_LANG_C).
      Case(/*KEEP_STR*/"DW_LANG_Ada83", SourceLanguage.DW_LANG_Ada83).
      Case(/*KEEP_STR*/"DW_LANG_C_plus_plus", SourceLanguage.DW_LANG_C_plus_plus).
      Case(/*KEEP_STR*/"DW_LANG_Cobol74", SourceLanguage.DW_LANG_Cobol74).
      Case(/*KEEP_STR*/"DW_LANG_Cobol85", SourceLanguage.DW_LANG_Cobol85).
      Case(/*KEEP_STR*/"DW_LANG_Fortran77", SourceLanguage.DW_LANG_Fortran77).
      Case(/*KEEP_STR*/"DW_LANG_Fortran90", SourceLanguage.DW_LANG_Fortran90).
      Case(/*KEEP_STR*/"DW_LANG_Pascal83", SourceLanguage.DW_LANG_Pascal83).
      Case(/*KEEP_STR*/"DW_LANG_Modula2", SourceLanguage.DW_LANG_Modula2).
      Case(/*KEEP_STR*/"DW_LANG_Java", SourceLanguage.DW_LANG_Java).
      Case(/*KEEP_STR*/"DW_LANG_C99", SourceLanguage.DW_LANG_C99).
      Case(/*KEEP_STR*/"DW_LANG_Ada95", SourceLanguage.DW_LANG_Ada95).
      Case(/*KEEP_STR*/"DW_LANG_Fortran95", SourceLanguage.DW_LANG_Fortran95).
      Case(/*KEEP_STR*/"DW_LANG_PLI", SourceLanguage.DW_LANG_PLI).
      Case(/*KEEP_STR*/"DW_LANG_ObjC", SourceLanguage.DW_LANG_ObjC).
      Case(/*KEEP_STR*/"DW_LANG_ObjC_plus_plus", SourceLanguage.DW_LANG_ObjC_plus_plus).
      Case(/*KEEP_STR*/"DW_LANG_UPC", SourceLanguage.DW_LANG_UPC).
      Case(/*KEEP_STR*/"DW_LANG_D", SourceLanguage.DW_LANG_D).
      
      // New in DWARF 5:
      Case(/*KEEP_STR*/"DW_LANG_Python", SourceLanguage.DW_LANG_Python).
      Case(/*KEEP_STR*/"DW_LANG_OpenCL", SourceLanguage.DW_LANG_OpenCL).
      Case(/*KEEP_STR*/"DW_LANG_Go", SourceLanguage.DW_LANG_Go).
      Case(/*KEEP_STR*/"DW_LANG_Modula3", SourceLanguage.DW_LANG_Modula3).
      Case(/*KEEP_STR*/"DW_LANG_Haskell", SourceLanguage.DW_LANG_Haskell).
      Case(/*KEEP_STR*/"DW_LANG_C_plus_plus_03", SourceLanguage.DW_LANG_C_plus_plus_03).
      Case(/*KEEP_STR*/"DW_LANG_C_plus_plus_11", SourceLanguage.DW_LANG_C_plus_plus_11).
      Case(/*KEEP_STR*/"DW_LANG_OCaml", SourceLanguage.DW_LANG_OCaml).
      Case(/*KEEP_STR*/"DW_LANG_Rust", SourceLanguage.DW_LANG_Rust).
      Case(/*KEEP_STR*/"DW_LANG_C11", SourceLanguage.DW_LANG_C11).
      Case(/*KEEP_STR*/"DW_LANG_Swift", SourceLanguage.DW_LANG_Swift).
      Case(/*KEEP_STR*/"DW_LANG_Julia", SourceLanguage.DW_LANG_Julia).
      Case(/*KEEP_STR*/"DW_LANG_Dylan", SourceLanguage.DW_LANG_Dylan).
      Case(/*KEEP_STR*/"DW_LANG_C_plus_plus_14", SourceLanguage.DW_LANG_C_plus_plus_14).
      Case(/*KEEP_STR*/"DW_LANG_Fortran03", SourceLanguage.DW_LANG_Fortran03).
      Case(/*KEEP_STR*/"DW_LANG_Fortran08", SourceLanguage.DW_LANG_Fortran08).
      Case(/*KEEP_STR*/"DW_LANG_Mips_Assembler", SourceLanguage.DW_LANG_Mips_Assembler).
      Case(/*KEEP_STR*/"DW_LANG_GOOGLE_RenderScript", SourceLanguage.DW_LANG_GOOGLE_RenderScript).
      Case(/*KEEP_STR*/"DW_LANG_BORLAND_Delphi", SourceLanguage.DW_LANG_BORLAND_Delphi).
      Default(0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::getCallingConvention">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 398,
 FQN="llvm::dwarf::getCallingConvention", NM="_ZN4llvm5dwarf20getCallingConventionENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf20getCallingConventionENS_9StringRefE")
//</editor-fold>
public static /*uint*/int getCallingConvention(StringRef CCString) {
  return new StringSwitchUInt(/*NO_COPY*/CCString).
      // DWARF calling convention codes.
      Case(/*KEEP_STR*/"DW_CC_normal", CallingConvention.DW_CC_normal).
      Case(/*KEEP_STR*/"DW_CC_program", CallingConvention.DW_CC_program).
      Case(/*KEEP_STR*/"DW_CC_nocall", CallingConvention.DW_CC_nocall).
      Case(/*KEEP_STR*/"DW_CC_GNU_borland_fastcall_i386", CallingConvention.DW_CC_GNU_borland_fastcall_i386).
      Case(/*KEEP_STR*/"DW_CC_BORLAND_safecall", CallingConvention.DW_CC_BORLAND_safecall).
      Case(/*KEEP_STR*/"DW_CC_BORLAND_stdcall", CallingConvention.DW_CC_BORLAND_stdcall).
      Case(/*KEEP_STR*/"DW_CC_BORLAND_pascal", CallingConvention.DW_CC_BORLAND_pascal).
      Case(/*KEEP_STR*/"DW_CC_BORLAND_msfastcall", CallingConvention.DW_CC_BORLAND_msfastcall).
      Case(/*KEEP_STR*/"DW_CC_BORLAND_msreturn", CallingConvention.DW_CC_BORLAND_msreturn).
      Case(/*KEEP_STR*/"DW_CC_BORLAND_thiscall", CallingConvention.DW_CC_BORLAND_thiscall).
      Case(/*KEEP_STR*/"DW_CC_BORLAND_fastcall", CallingConvention.DW_CC_BORLAND_fastcall).
      Case(/*KEEP_STR*/"DW_CC_LLVM_vectorcall", CallingConvention.DW_CC_LLVM_vectorcall).
      Default(0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::getAttributeEncoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 292,
 FQN="llvm::dwarf::getAttributeEncoding", NM="_ZN4llvm5dwarf20getAttributeEncodingENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf20getAttributeEncodingENS_9StringRefE")
//</editor-fold>
public static /*uint*/int getAttributeEncoding(StringRef EncodingString) {
  return new StringSwitchUInt(/*NO_COPY*/EncodingString).
      
      // DWARF attribute type encodings.
      Case(/*KEEP_STR*/"DW_ATE_address", TypeKind.DW_ATE_address).
      Case(/*KEEP_STR*/"DW_ATE_boolean", TypeKind.DW_ATE_boolean).
      Case(/*KEEP_STR*/"DW_ATE_complex_float", TypeKind.DW_ATE_complex_float).
      Case(/*KEEP_STR*/"DW_ATE_float", TypeKind.DW_ATE_float).
      Case(/*KEEP_STR*/"DW_ATE_signed", TypeKind.DW_ATE_signed).
      Case(/*KEEP_STR*/"DW_ATE_signed_char", TypeKind.DW_ATE_signed_char).
      Case(/*KEEP_STR*/"DW_ATE_unsigned", TypeKind.DW_ATE_unsigned).
      Case(/*KEEP_STR*/"DW_ATE_unsigned_char", TypeKind.DW_ATE_unsigned_char).
      Case(/*KEEP_STR*/"DW_ATE_imaginary_float", TypeKind.DW_ATE_imaginary_float).
      Case(/*KEEP_STR*/"DW_ATE_packed_decimal", TypeKind.DW_ATE_packed_decimal).
      Case(/*KEEP_STR*/"DW_ATE_numeric_string", TypeKind.DW_ATE_numeric_string).
      Case(/*KEEP_STR*/"DW_ATE_edited", TypeKind.DW_ATE_edited).
      Case(/*KEEP_STR*/"DW_ATE_signed_fixed", TypeKind.DW_ATE_signed_fixed).
      Case(/*KEEP_STR*/"DW_ATE_unsigned_fixed", TypeKind.DW_ATE_unsigned_fixed).
      Case(/*KEEP_STR*/"DW_ATE_decimal_float", TypeKind.DW_ATE_decimal_float).
      Case(/*KEEP_STR*/"DW_ATE_UTF", TypeKind.DW_ATE_UTF).Default(0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::getMacinfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 475,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 476,
 FQN="llvm::dwarf::getMacinfo", NM="_ZN4llvm5dwarf10getMacinfoENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf10getMacinfoENS_9StringRefE")
//</editor-fold>
public static /*uint*/int getMacinfo(StringRef MacinfoString) {
  return new StringSwitchUInt(/*NO_COPY*/MacinfoString).
      Case(/*KEEP_STR*/"DW_MACINFO_define", MacinfoRecordType.DW_MACINFO_define).
      Case(/*KEEP_STR*/"DW_MACINFO_undef", MacinfoRecordType.DW_MACINFO_undef).
      Case(/*KEEP_STR*/"DW_MACINFO_start_file", MacinfoRecordType.DW_MACINFO_start_file).
      Case(/*KEEP_STR*/"DW_MACINFO_end_file", MacinfoRecordType.DW_MACINFO_end_file).
      Case(/*KEEP_STR*/"DW_MACINFO_vendor_ext", MacinfoRecordType.DW_MACINFO_vendor_ext).
      Default(LLVMConstants.DW_MACINFO_invalid.getValue());
}

/// @}

/// \brief Returns the symbolic string representing Val when used as a value
/// for attribute Attr.
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::AttributeValueString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", line = 606,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp", old_line = 601,
 FQN="llvm::dwarf::AttributeValueString", NM="_ZN4llvm5dwarf20AttributeValueStringEtj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf20AttributeValueStringEtj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ AttributeValueString(/*uint16_t*/char Attr, /*uint*/int Val) {
  switch ($ushort2int(Attr)) {
   case Attribute.DW_AT_accessibility:
    return AccessibilityString(Val);
   case Attribute.DW_AT_virtuality:
    return VirtualityString(Val);
   case Attribute.DW_AT_language:
    return LanguageString(Val);
   case Attribute.DW_AT_encoding:
    return AttributeEncodingString(Val);
   case Attribute.DW_AT_decimal_sign:
    return DecimalSignString(Val);
   case Attribute.DW_AT_endianity:
    return EndianityString(Val);
   case Attribute.DW_AT_visibility:
    return VisibilityString(Val);
   case Attribute.DW_AT_identifier_case:
    return CaseString(Val);
   case Attribute.DW_AT_calling_convention:
    return ConventionString(Val);
   case Attribute.DW_AT_inline:
    return InlineCodeString(Val);
   case Attribute.DW_AT_ordering:
    return ArrayOrderString(Val);
   case Attribute.DW_AT_discr_value:
    return DiscriminantString(Val);
  }
  
  return null;
}

} // END OF class DwarfGlobals
