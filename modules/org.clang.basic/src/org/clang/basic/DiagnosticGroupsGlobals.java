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
package org.clang.basic;

import java.io.UnsupportedEncodingException;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type DiagnosticGroupsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL10DiagArrays;_ZL13DiagSubGroups;_ZL14DiagGroupNames; -static-type=DiagnosticGroupsGlobals -package=org.clang.basic")
//</editor-fold>
public final class DiagnosticGroupsGlobals {

//<editor-fold defaultstate="collapsed" desc="DiagArrays">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/DiagnosticGroups.inc", line = 3,
 FQN="DiagArrays", NM="_ZL10DiagArrays",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL10DiagArrays")
//</editor-fold>
public static /*const*/short/*int16_t*/ DiagArrays[/*1770*/] = new /*const*/short/*int16_t*/ [/*1770*/] {
  /* Empty */ -1, 
  /* DiagArray1 */ $uint2short(diag.warn_pragma_message), -1, 
  /* DiagArray2 */ $uint2short(diag.pp_hash_warning), -1, 
  /* DiagArray3 */ $uint2short(diag.warn_cfstring_truncated), -1, 
  /* DiagArray5 */ $uint2short(diag.warn_independentclass_attribute), $uint2short(diag.warn_ptr_independentclass_attribute), -1, 
  /* DiagArray6 */ $uint2short(diag.warn_nsobject_attribute), -1, 
  /* DiagArray8 */ $uint2short(diag.warn_abs_too_small), $uint2short(diag.warn_pointer_abs), $uint2short(diag.warn_unsigned_abs), $uint2short(diag.warn_wrong_absolute_value_type), -1, 
  /* DiagArray9 */ $uint2short(diag.warn_abstract_final_class), -1, 
  /* DiagArray10 */ $uint2short(diag.warn_abstract_vbase_init_ignored), -1, 
  /* DiagArray12 */ $uint2short(diag.warn_temporary_array_to_pointer_decay), -1, 
  /* DiagArray13 */ $uint2short(diag.ext_typecheck_addrof_temporary), -1, 
  /* DiagArray16 */ $uint2short(diag.warn_misplaced_ellipsis_vararg), -1, 
  /* DiagArray17 */ $uint2short(diag.warn_pp_ambiguous_macro), -1, 
  /* DiagArray18 */ $uint2short(diag.ext_nested_name_member_ref_lookup_ambiguous), -1, 
  /* DiagArray19 */ $uint2short(diag.warn_incompatible_analyzer_plugin_api), -1, 
  /* DiagArray20 */ $uint2short(diag.ext_abstract_pack_declarator_parens), -1, 
  /* DiagArray22 */ $uint2short(diag.warn_arc_bridge_cast_nonarc), -1, 
  /* DiagArray23 */ $uint2short(diag.warn_arc_possible_repeated_use_of_weak), -1, 
  /* DiagArray24 */ $uint2short(diag.warn_arc_object_memaccess), -1, 
  /* DiagArray25 */ $uint2short(diag.warn_arc_perform_selector_leaks), -1, 
  /* DiagArray26 */ $uint2short(diag.warn_arc_repeated_use_of_weak), -1, 
  /* DiagArray27 */ $uint2short(diag.warn_arc_retain_cycle), -1, 
  /* DiagArray28 */ $uint2short(diag.warn_arc_literal_assign), $uint2short(diag.warn_arc_retained_assign), $uint2short(diag.warn_arc_retained_property_assign), -1, 
  /* DiagArray29 */ $uint2short(diag.warn_array_index_exceeds_bounds), $uint2short(diag.warn_array_index_precedes_bounds), $uint2short(diag.warn_static_array_too_small), $uint2short(diag.warn_typecheck_zero_static_array_size), -1, 
  /* DiagArray30 */ $uint2short(diag.warn_ptr_arith_exceeds_bounds), $uint2short(diag.warn_ptr_arith_precedes_bounds), -1, 
  /* DiagArray32 */ $uint2short(diag.warn_asm_mismatched_size_modifier), -1, 
  /* DiagArray33 */ $uint2short(diag.warn_not_in_enum_assignment), -1, 
  /* DiagArray34 */ $uint2short(diag.warn_assume_side_effects), -1, 
  /* DiagArray35 */ $uint2short(diag.warn_atprotocol_protocol), -1, 
  /* DiagArray36 */ $uint2short(diag.warn_atomic_op_has_invalid_memory_order), -1, 
  /* DiagArray38 */ $uint2short(diag.warn_atomic_property_rule), -1, 
  /* DiagArray39 */ $uint2short(diag.warn_attribute_packed_for_bitfield), -1, 
  /* DiagArray41 */ $uint2short(diag.warn_drv_disabling_vptr_no_rtti_default), -1, 
  /* DiagArray42 */ $uint2short(diag.warn_auto_module_import), -1, 
  /* DiagArray43 */ $uint2short(diag.ext_auto_storage_class), -1, 
  /* DiagArray44 */ $uint2short(diag.warn_auto_var_is_id), -1, 
  /* DiagArray45 */ $uint2short(diag.warn_availability_and_unavailable), $uint2short(diag.warn_availability_unknown_platform), $uint2short(diag.warn_availability_version_ordering), $uint2short(diag.warn_expected_consistent_version_separator), $uint2short(diag.warn_mismatched_availability), $uint2short(diag.warn_mismatched_availability_override), $uint2short(diag.warn_mismatched_availability_override_unavail), -1, 
  /* DiagArray46 */ $uint2short(diag.warn_fe_backend_plugin), -1, 
  /* DiagArray47 */ $uint2short(diag.backslash_newline_space), -1, 
  /* DiagArray48 */ $uint2short(diag.warn_array_new_too_large), $uint2short(diag.warn_typecheck_negative_array_new_size), -1, 
  /* DiagArray49 */ $uint2short(diag.warn_bad_function_cast), -1, 
  /* DiagArray50 */ $uint2short(diag.ext_rvalue_to_reference_access_ctor), $uint2short(diag.ext_rvalue_to_reference_temp_copy_no_viable), -1, 
  /* DiagArray51 */ $uint2short(diag.warn_impcast_bitfield_precision_constant), -1, 
  /* DiagArray52 */ $uint2short(diag.warn_anon_bitfield_width_exceeds_type_width), $uint2short(diag.warn_bitfield_width_exceeds_type_width), -1, 
  /* DiagArray53 */ $uint2short(diag.warn_bitwise_op_in_bitwise_op), -1, 
  /* DiagArray54 */ $uint2short(diag.warn_impcast_bool_to_null_pointer), -1, 
  /* DiagArray56 */ $uint2short(diag.warn_braces_around_scalar_init), -1, 
  /* DiagArray57 */ $uint2short(diag.warn_objc_invalid_bridge), $uint2short(diag.warn_objc_invalid_bridge_to_cf), -1, 
  /* DiagArray58 */ $uint2short(diag.ext_pp_redef_builtin_macro), $uint2short(diag.ext_pp_undef_builtin_macro), -1, 
  /* DiagArray59 */ $uint2short(diag.warn_memcpy_chk_overflow), -1, 
  /* DiagArray60 */ $uint2short(diag.warn_implicit_decl_requires_sysheader), -1, 
  /* DiagArray61 */ $uint2short(diag.warn_zero_size_struct_union_compat), -1, 
  /* DiagArray65 */ $uint2short(diag.ext_old_implicitly_unsigned_long_cxx), $uint2short(diag.warn_auto_storage_class), $uint2short(diag.warn_cxx11_compat_user_defined_literal), $uint2short(diag.warn_cxx11_keyword), $uint2short(diag.warn_cxx11_right_shift_in_template_arg), $uint2short(diag.warn_explicit_instantiation_inline_0x), $uint2short(diag.warn_explicit_instantiation_must_be_global_0x), $uint2short(diag.warn_explicit_instantiation_out_of_scope_0x), $uint2short(diag.warn_explicit_instantiation_unqualified_wrong_namespace_0x), $uint2short(diag.warn_old_implicitly_unsigned_long_cxx), -1, 
  /* DiagArray66 */ $uint2short(diag.warn_deprecated_string_literal_conversion), -1, 
  /* DiagArray68 */ $uint2short(diag.warn_cxx11_compat_reserved_user_defined_literal), -1, 
  /* DiagArray69 */ $uint2short(diag.ext_alias_declaration), $uint2short(diag.ext_array_size_conversion), $uint2short(diag.ext_auto_type_specifier), $uint2short(diag.ext_cxx11_enum_fixed_underlying_type), $uint2short(diag.ext_defaulted_deleted_function), $uint2short(diag.ext_enum_friend), $uint2short(diag.ext_enumerator_list_comma_cxx), $uint2short(diag.ext_explicit_conversion_functions), $uint2short(diag.ext_explicit_instantiation_after_specialization), $uint2short(diag.ext_extern_template), $uint2short(diag.ext_for_range), $uint2short(diag.ext_generalized_initializer_lists), $uint2short(diag.ext_nested_name_spec_is_enum), $uint2short(diag.ext_nonclass_type_friend), $uint2short(diag.ext_nonstatic_member_init), $uint2short(diag.ext_override_control_keyword), $uint2short(diag.ext_ref_qualifier), $uint2short(diag.ext_rvalue_reference), $uint2short(diag.ext_scoped_enum), $uint2short(diag.ext_static_data_member_in_union), $uint2short(diag.ext_template_arg_object_internal), $uint2short(diag.ext_template_outside_of_template), $uint2short(diag.ext_template_parameter_default_in_function_template), $uint2short(diag.ext_template_spec_decl_out_of_scope), $uint2short(diag.ext_typename_outside_of_template), $uint2short(diag.ext_unelaborated_friend_type), $uint2short(diag.ext_variadic_templates), -1, 
  /* DiagArray70 */ $uint2short(diag.ext_extra_semi_cxx11), -1, 
  /* DiagArray71 */ $uint2short(diag.ext_inline_namespace), -1, 
  /* DiagArray72 */ $uint2short(diag.ext_cxx11_longlong), -1, 
  /* DiagArray73 */ $uint2short(diag.ext_cce_narrowing), $uint2short(diag.ext_init_list_constant_narrowing), $uint2short(diag.ext_init_list_type_narrowing), $uint2short(diag.ext_init_list_variable_narrowing), $uint2short(diag.warn_init_list_constant_narrowing), $uint2short(diag.warn_init_list_type_narrowing), $uint2short(diag.warn_init_list_variable_narrowing), -1, 
  /* DiagArray74 */ $uint2short(diag.ext_binary_literal_cxx14), -1, 
  /* DiagArray77 */ $uint2short(diag.ext_constexpr_body_invalid_stmt), $uint2short(diag.ext_constexpr_body_multiple_return), $uint2short(diag.ext_constexpr_local_var), $uint2short(diag.ext_constexpr_type_definition), $uint2short(diag.ext_cxx14_attr), $uint2short(diag.ext_decltype_auto_type_specifier), $uint2short(diag.ext_init_capture), $uint2short(diag.ext_variable_template), -1, 
  /* DiagArray80 */ $uint2short(diag.ext_constexpr_if), $uint2short(diag.ext_cxx1z_attr), $uint2short(diag.ext_fold_expression), $uint2short(diag.ext_for_range_begin_end_types_differ), $uint2short(diag.ext_hex_literal_invalid), $uint2short(diag.ext_inline_variable), $uint2short(diag.ext_nested_namespace_definition), $uint2short(diag.ext_star_this_lambda_capture_cxx1z), $uint2short(diag.ext_static_assert_no_message), $uint2short(diag.ext_template_template_param_typename), $uint2short(diag.ext_using_attribute_ns), -1, 
  /* DiagArray81 */ $uint2short(diag.warn_cxx14_compat_attribute), $uint2short(diag.warn_cxx14_compat_constexpr_if), $uint2short(diag.warn_cxx14_compat_fold_expression), $uint2short(diag.warn_cxx14_compat_inline_variable), $uint2short(diag.warn_cxx14_compat_nested_namespace_definition), $uint2short(diag.warn_cxx14_compat_star_this_lambda_capture), $uint2short(diag.warn_cxx14_compat_static_assert_no_message), $uint2short(diag.warn_cxx14_compat_template_template_param_typename), $uint2short(diag.warn_cxx14_compat_u8_character_literal), $uint2short(diag.warn_cxx14_compat_using_attribute_ns), $uint2short(diag.warn_for_range_begin_end_types_differ), -1, 
  /* DiagArray82 */ $uint2short(diag.warn_cxx1z_hex_literal), -1, 
  /* DiagArray83 */ $uint2short(diag.warn_cxx11_compat_constexpr_body_invalid_stmt), $uint2short(diag.warn_cxx11_compat_constexpr_body_multiple_return), $uint2short(diag.warn_cxx11_compat_constexpr_body_no_return), $uint2short(diag.warn_cxx11_compat_constexpr_local_var), $uint2short(diag.warn_cxx11_compat_constexpr_type_definition), $uint2short(diag.warn_cxx11_compat_decltype_auto_type_specifier), $uint2short(diag.warn_cxx11_compat_digit_separator), $uint2short(diag.warn_cxx11_compat_init_capture), $uint2short(diag.warn_cxx11_compat_variable_template), -1, 
  /* DiagArray84 */ $uint2short(diag.warn_cxx11_compat_binary_literal), -1, 
  /* DiagArray85 */ $uint2short(diag.warn_cxx98_compat_alias_declaration), $uint2short(diag.warn_cxx98_compat_alignas), $uint2short(diag.warn_cxx98_compat_alignof), $uint2short(diag.warn_cxx98_compat_attribute), $uint2short(diag.warn_cxx98_compat_auto_type_specifier), $uint2short(diag.warn_cxx98_compat_constexpr), $uint2short(diag.warn_cxx98_compat_ctor_list_init), $uint2short(diag.warn_cxx98_compat_decltype), $uint2short(diag.warn_cxx98_compat_defaulted_deleted_function), $uint2short(diag.warn_cxx98_compat_delegating_ctor), $uint2short(diag.warn_cxx98_compat_empty_scalar_initializer), $uint2short(diag.warn_cxx98_compat_enum_fixed_underlying_type), $uint2short(diag.warn_cxx98_compat_enum_friend), $uint2short(diag.warn_cxx98_compat_enum_nested_name_spec), $uint2short(diag.warn_cxx98_compat_explicit_conversion_functions), $uint2short(diag.warn_cxx98_compat_for_range), $uint2short(diag.warn_cxx98_compat_friend_is_member), $uint2short(diag.warn_cxx98_compat_generalized_initializer_lists), $uint2short(diag.warn_cxx98_compat_goto_into_protected_scope), $uint2short(diag.warn_cxx98_compat_indirect_goto_in_protected_scope), $uint2short(diag.warn_cxx98_compat_initializer_list_init), $uint2short(diag.warn_cxx98_compat_inline_namespace), $uint2short(diag.warn_cxx98_compat_lambda), $uint2short(diag.warn_cxx98_compat_less_colon_colon), $uint2short(diag.warn_cxx98_compat_literal_operator), $uint2short(diag.warn_cxx98_compat_literal_ucn_control_character), $uint2short(diag.warn_cxx98_compat_literal_ucn_escape_basic_scs), $uint2short(diag.warn_cxx98_compat_noexcept_decl), $uint2short(diag.warn_cxx98_compat_noexcept_expr), $uint2short(diag.warn_cxx98_compat_non_static_member_use), $uint2short(diag.warn_cxx98_compat_nonclass_type_friend), $uint2short(diag.warn_cxx98_compat_nonstatic_member_init), $uint2short(diag.warn_cxx98_compat_nontrivial_union_or_anon_struct_member), $uint2short(diag.warn_cxx98_compat_nullptr), $uint2short(diag.warn_cxx98_compat_override_control_keyword), $uint2short(diag.warn_cxx98_compat_pass_non_pod_arg_to_vararg), $uint2short(diag.warn_cxx98_compat_raw_string_literal), $uint2short(diag.warn_cxx98_compat_ref_qualifier), $uint2short(diag.warn_cxx98_compat_reference_list_init), $uint2short(diag.warn_cxx98_compat_rvalue_reference), $uint2short(diag.warn_cxx98_compat_scoped_enum), $uint2short(diag.warn_cxx98_compat_sfinae_access_control), $uint2short(diag.warn_cxx98_compat_static_assert), $uint2short(diag.warn_cxx98_compat_static_data_member_in_union), $uint2short(diag.warn_cxx98_compat_switch_into_protected_scope), $uint2short(diag.warn_cxx98_compat_template_arg_extra_parens), $uint2short(diag.warn_cxx98_compat_template_arg_null), $uint2short(diag.warn_cxx98_compat_template_arg_object_internal), $uint2short(diag.warn_cxx98_compat_template_outside_of_template), $uint2short(diag.warn_cxx98_compat_template_parameter_default_in_function_template), $uint2short(diag.warn_cxx98_compat_template_spec_decl_out_of_scope), $uint2short(diag.warn_cxx98_compat_trailing_return_type), $uint2short(diag.warn_cxx98_compat_two_right_angle_brackets), $uint2short(diag.warn_cxx98_compat_typename_outside_of_template), $uint2short(diag.warn_cxx98_compat_unelaborated_friend_type), $uint2short(diag.warn_cxx98_compat_unicode_id), $uint2short(diag.warn_cxx98_compat_unicode_literal), $uint2short(diag.warn_cxx98_compat_unicode_type), $uint2short(diag.warn_cxx98_compat_using_decl_constructor), $uint2short(diag.warn_cxx98_compat_variadic_templates), -1, 
  /* DiagArray86 */ $uint2short(diag.warn_cxx98_compat_temp_copy), -1, 
  /* DiagArray87 */ $uint2short(diag.warn_cxx98_compat_template_arg_local_type), -1, 
  /* DiagArray88 */ $uint2short(diag.warn_cxx98_compat_array_size_conversion), $uint2short(diag.warn_cxx98_compat_cast_fn_obj), $uint2short(diag.warn_cxx98_compat_empty_fnmacro_arg), $uint2short(diag.warn_cxx98_compat_enumerator_list_comma), $uint2short(diag.warn_cxx98_compat_explicit_instantiation_after_specialization), $uint2short(diag.warn_cxx98_compat_extern_template), $uint2short(diag.warn_cxx98_compat_longlong), $uint2short(diag.warn_cxx98_compat_no_newline_eof), $uint2short(diag.warn_cxx98_compat_pp_line_too_big), $uint2short(diag.warn_cxx98_compat_top_level_semi), $uint2short(diag.warn_cxx98_compat_variadic_macro), -1, 
  /* DiagArray89 */ $uint2short(diag.warn_cxx98_compat_template_arg_unnamed_type), -1, 
  /* DiagArray90 */ $uint2short(diag.ext_anonymous_union), $uint2short(diag.ext_c11_alignment), $uint2short(diag.ext_c11_anonymous_struct), $uint2short(diag.ext_c11_generic_selection), $uint2short(diag.ext_c11_noreturn), $uint2short(diag.ext_c11_static_assert), -1, 
  /* DiagArray91 */ $uint2short(diag.warn_c99_compat_unicode_id), $uint2short(diag.warn_c99_compat_unicode_literal), $uint2short(diag.warn_old_implicitly_unsigned_long), -1, 
  /* DiagArray92 */ $uint2short(diag.ext_aggregate_init_not_constant), $uint2short(diag.ext_c99_array_usage), $uint2short(diag.ext_c99_compound_literal), $uint2short(diag.ext_c99_flexible_array_member), $uint2short(diag.ext_c99_variable_decl_in_for_loop), $uint2short(diag.ext_c99_whitespace_required_after_macro_name), $uint2short(diag.ext_designated_init), $uint2short(diag.ext_empty_fnmacro_arg), $uint2short(diag.ext_enumerator_list_comma_c), $uint2short(diag.ext_hex_constant_invalid), -1, 
  /* DiagArray93 */ $uint2short(diag.warn_cast_align), -1, 
  /* DiagArray94 */ $uint2short(diag.warn_cast_calling_conv), -1, 
  /* DiagArray95 */ $uint2short(diag.warn_cast_pointer_from_sel), -1, 
  /* DiagArray96 */ $uint2short(diag.warn_cast_qual), $uint2short(diag.warn_cast_qual2), -1, 
  /* DiagArray98 */ $uint2short(diag.warn_omp_section_is_char), $uint2short(diag.warn_subscript_is_char), -1, 
  /* DiagArray99 */ $uint2short(diag.warn_drv_yc_multiple_inputs_clang_cl), $uint2short(diag.warn_drv_ycyu_different_arg_clang_cl), $uint2short(diag.warn_drv_ycyu_no_arg_clang_cl), $uint2short(diag.warn_drv_ycyu_no_fi_arg_clang_cl), -1, 
  /* DiagArray100 */ $uint2short(diag.warn_pass_class_arg_to_vararg), -1, 
  /* DiagArray101 */ $uint2short(diag.warn_comma_operator), -1, 
  /* DiagArray102 */ $uint2short(diag.escaped_newline_block_comment_end), $uint2short(diag.ext_line_comment), $uint2short(diag.ext_multi_line_line_comment), $uint2short(diag.warn_nested_block_comment), -1, 
  /* DiagArray104 */ $uint2short(diag.ext_typecheck_comparison_of_distinct_pointers), $uint2short(diag.ext_typecheck_comparison_of_distinct_pointers_nonstandard), -1, 
  /* DiagArray105 */ $uint2short(diag.ext_complex_component_init), -1, 
  /* DiagArray106 */ $uint2short(diag.ext_typecheck_cond_pointer_integer_mismatch), -1, 
  /* DiagArray107 */ $uint2short(diag.warn_maybe_uninit_var), -1, 
  /* DiagArray108 */ $uint2short(diag.warn_module_config_macro_undef), -1, 
  /* DiagArray109 */ $uint2short(diag.warn_impcast_integer_precision_constant), -1, 
  /* DiagArray110 */ $uint2short(diag.warn_logical_instead_of_bitwise), -1, 
  /* DiagArray111 */ $uint2short(diag.warn_cxx14_compat_constexpr_not_const), -1, 
  /* DiagArray112 */ $uint2short(diag.warn_attr_on_unconsumable_class), $uint2short(diag.warn_loop_state_mismatch), $uint2short(diag.warn_param_return_typestate_mismatch), $uint2short(diag.warn_param_typestate_mismatch), $uint2short(diag.warn_return_typestate_for_unconsumable_type), $uint2short(diag.warn_return_typestate_mismatch), $uint2short(diag.warn_use_in_invalid_state), $uint2short(diag.warn_use_of_temp_in_invalid_state), -1, 
  /* DiagArray113 */ $uint2short(diag.warn_impcast_complex_scalar), $uint2short(diag.warn_impcast_float_precision), $uint2short(diag.warn_impcast_integer_precision), $uint2short(diag.warn_impcast_vector_scalar), $uint2short(diag.warn_template_arg_negative), $uint2short(diag.warn_template_arg_too_large), -1, 
  /* DiagArray115 */ $uint2short(diag.ext_coroutine_without_co_await_co_yield), -1, 
  /* DiagArray116 */ $uint2short(diag.warn_unreachable_default), -1, 
  /* DiagArray117 */ $uint2short(diag.warn_objc_cdirective_format_string), -1, 
  /* DiagArray119 */ $uint2short(diag.warn_attribute_argument_n_negative), $uint2short(diag.warn_kern_is_inline), $uint2short(diag.warn_kern_is_method), $uint2short(diag.warn_pragma_unroll_cuda_value_in_parens), -1, 
  /* DiagArray120 */ $uint2short(diag.warn_default_atomic_custom_getter_setter), -1, 
  /* DiagArray121 */ $uint2short(diag.warn_dangling_else), -1, 
  /* DiagArray122 */ $uint2short(diag.warn_bind_ref_member_to_parameter), $uint2short(diag.warn_bind_ref_member_to_temporary), $uint2short(diag.warn_init_ptr_member_to_parameter_addr), -1, 
  /* DiagArray123 */ $uint2short(diag.warn_dangling_std_initializer_list), -1, 
  /* DiagArray124 */ $uint2short(diag.warn_pp_date_time), -1, 
  /* DiagArray125 */ $uint2short(diag.warn_dealloc_in_category), -1, 
  /* DiagArray126 */ $uint2short(diag.warn_debug_compression_unavailable), -1, 
  /* DiagArray127 */ $uint2short(diag.ext_mixed_decls_code), -1, 
  /* DiagArray128 */ $uint2short(diag.warn_delegating_ctor_cycle), -1, 
  /* DiagArray129 */ $uint2short(diag.ext_delete_void_ptr_operand), $uint2short(diag.warn_delete_incomplete), -1, 
  /* DiagArray130 */ $uint2short(diag.warn_delete_abstract_non_virtual_dtor), $uint2short(diag.warn_delete_non_virtual_dtor), -1, 
  /* DiagArray131 */ $uint2short(diag.warn_O4_is_O3), $uint2short(diag.warn_access_decl_deprecated), $uint2short(diag.warn_deprecated_copy_operation), $uint2short(diag.warn_deprecated_redundant_constexpr_static_def), $uint2short(diag.warn_drv_deprecated_arg), $uint2short(diag.warn_drv_treating_input_as_cxx), $uint2short(diag.warn_exception_spec_deprecated), $uint2short(diag.warn_option_invalid_ocl_version), $uint2short(diag.warn_vector_long_decl_spec_combination), -1, 
  /* DiagArray132 */ $uint2short(diag.warn_vector_mode_deprecated), -1, 
  /* DiagArray133 */ $uint2short(diag.warn_cstyle_param), $uint2short(diag.warn_deprecated), $uint2short(diag.warn_deprecated_fwdclass_message), $uint2short(diag.warn_deprecated_message), $uint2short(diag.warn_property_method_deprecated), -1, 
  /* DiagArray134 */ $uint2short(diag.warn_deprecated_def), -1, 
  /* DiagArray135 */ $uint2short(diag.warn_increment_bool), -1, 
  /* DiagArray136 */ $uint2short(diag.warn_objc_isa_assign), $uint2short(diag.warn_objc_isa_use), -1, 
  /* DiagArray137 */ $uint2short(diag.warn_objc_pointer_masking), -1, 
  /* DiagArray138 */ $uint2short(diag.warn_objc_pointer_masking_performSelector), -1, 
  /* DiagArray139 */ $uint2short(diag.warn_deprecated_register), -1, 
  /* DiagArray141 */ $uint2short(diag.warn_direct_ivar_access), -1, 
  /* DiagArray142 */ $uint2short(diag.pp_disabled_macro_expansion), -1, 
  /* DiagArray145 */ $uint2short(diag.warn_conflicting_param_modifiers), $uint2short(diag.warn_conflicting_ret_type_modifiers), -1, 
  /* DiagArray147 */ $uint2short(diag.warn_remainder_division_by_zero), -1, 
  /* DiagArray148 */ $uint2short(diag.warn_attribute_dll_redeclaration), -1, 
  /* DiagArray149 */ $uint2short(diag.warn_attribute_dllexport_explicit_instantiation_decl), -1, 
  /* DiagArray150 */ $uint2short(diag.warn_attribute_dllimport_static_field_definition), -1, 
  /* DiagArray151 */ $uint2short(diag.warn_doc_api_container_decl_mismatch), $uint2short(diag.warn_doc_block_command_duplicate), $uint2short(diag.warn_doc_block_command_empty_paragraph), $uint2short(diag.warn_doc_container_decl_mismatch), $uint2short(diag.warn_doc_function_method_decl_mismatch), $uint2short(diag.warn_doc_html_start_tag_expected_ident_or_greater), $uint2short(diag.warn_doc_html_start_tag_expected_quoted_string), $uint2short(diag.warn_doc_param_duplicate), $uint2short(diag.warn_doc_param_invalid_direction), $uint2short(diag.warn_doc_param_not_attached_to_a_function_decl), $uint2short(diag.warn_doc_param_not_found), $uint2short(diag.warn_doc_returns_attached_to_a_void_function), $uint2short(diag.warn_doc_returns_not_attached_to_a_function_decl), $uint2short(diag.warn_doc_tparam_duplicate), $uint2short(diag.warn_doc_tparam_not_attached_to_a_template_decl), $uint2short(diag.warn_doc_tparam_not_found), $uint2short(diag.warn_not_a_doxygen_trailing_member_comment), $uint2short(diag.warn_verbatim_block_end_without_start), -1, 
  /* DiagArray152 */ $uint2short(diag.warn_doc_deprecated_not_sync), -1, 
  /* DiagArray153 */ $uint2short(diag.warn_doc_html_end_forbidden), $uint2short(diag.warn_doc_html_end_unbalanced), $uint2short(diag.warn_doc_html_missing_end_tag), $uint2short(diag.warn_doc_html_start_end_mismatch), -1, 
  /* DiagArray154 */ $uint2short(diag.warn_doc_param_spaces_in_direction), -1, 
  /* DiagArray155 */ $uint2short(diag.warn_correct_comment_command_name), $uint2short(diag.warn_unknown_comment_command_name), -1, 
  /* DiagArray156 */ $uint2short(diag.ext_dollar_in_identifier), -1, 
  /* DiagArray157 */ $uint2short(diag.warn_impcast_double_promotion), -1, 
  /* DiagArray158 */ $uint2short(diag.ext_duplicate_declspec), $uint2short(diag.warn_duplicate_declspec), -1, 
  /* DiagArray159 */ $uint2short(diag.warn_duplicate_enum_values), -1, 
  /* DiagArray160 */ $uint2short(diag.warn_method_param_declaration), -1, 
  /* DiagArray161 */ $uint2short(diag.warn_duplicate_method_decl), -1, 
  /* DiagArray162 */ $uint2short(diag.warn_dyn_class_memaccess), -1, 
  /* DiagArray164 */ $uint2short(diag.ext_embedded_directive), -1, 
  /* DiagArray165 */ $uint2short(diag.warn_empty_for_body), $uint2short(diag.warn_empty_if_body), $uint2short(diag.warn_empty_range_based_for_body), $uint2short(diag.warn_empty_switch_body), $uint2short(diag.warn_empty_while_body), -1, 
  /* DiagArray166 */ $uint2short(diag.ext_empty_translation_unit), -1, 
  /* DiagArray167 */ $uint2short(diag.warn_incomplete_encoded_type), -1, 
  /* DiagArray169 */ $uint2short(diag.warn_comparison_of_mixed_enum_types), -1, 
  /* DiagArray170 */ $uint2short(diag.warn_impcast_different_enum_types), -1, 
  /* DiagArray171 */ $uint2short(diag.ext_enum_too_large), $uint2short(diag.ext_enumerator_increment_too_large), -1, 
  /* DiagArray172 */ $uint2short(diag.warn_cdtor_function_try_handler_mem_expr), $uint2short(diag.warn_exception_caught_by_earlier_handler), -1, 
  /* DiagArray173 */ $uint2short(diag.warn_exit_time_destructor), -1, 
  /* DiagArray174 */ $uint2short(diag.warn_defined_in_function_type_macro), $uint2short(diag.warn_defined_in_object_type_macro), -1, 
  /* DiagArray175 */ $uint2short(diag.warn_direct_initialize_call), $uint2short(diag.warn_direct_super_initialize_call), -1, 
  /* DiagArray176 */ $uint2short(diag.warn_arc_strong_pointer_objc_pointer), -1, 
  /* DiagArray177 */ $uint2short(diag.ext_offsetof_extended_field_designator), -1, 
  /* DiagArray178 */ $uint2short(diag.warn_zero_size_struct_union_in_extern_c), -1, 
  /* DiagArray179 */ $uint2short(diag.warn_extern_init), -1, 
  /* DiagArray181 */ $uint2short(diag.warn_namespace_member_extra_qualification), -1, 
  /* DiagArray182 */ $uint2short(diag.ext_extra_semi), $uint2short(diag.warn_extra_semi_after_mem_fn_def), -1, 
  /* DiagArray183 */ $uint2short(diag.ext_pp_extra_tokens_at_eol), $uint2short(diag.warn_omp_extra_tokens_at_eol), -1, 
  /* DiagArray184 */ $uint2short(diag.warn_drv_invoking_fallback), -1, 
  /* DiagArray185 */ $uint2short(diag.warn_flag_enum_constant_out_of_range), -1, 
  /* DiagArray186 */ $uint2short(diag.ext_flexible_array_in_array), $uint2short(diag.ext_flexible_array_in_struct), -1, 
  /* DiagArray187 */ $uint2short(diag.warn_impcast_float_integer), -1, 
  /* DiagArray188 */ $uint2short(diag.warn_floatingpoint_eq), -1, 
  /* DiagArray189 */ $uint2short(diag.warn_impcast_float_to_integer), -1, 
  /* DiagArray190 */ $uint2short(diag.warn_impcast_float_to_integer_zero), -1, 
  /* DiagArray191 */ $uint2short(diag.warn_redundant_loop_iteration), $uint2short(diag.warn_variables_not_in_loop_body), -1, 
  /* DiagArray192 */ $uint2short(diag.warn_format_argument_needs_cast), $uint2short(diag.warn_format_conversion_argument_type_mismatch), $uint2short(diag.warn_format_invalid_positional_specifier), $uint2short(diag.warn_format_mix_positional_nonpositional_args), $uint2short(diag.warn_format_nonsensical_length), $uint2short(diag.warn_format_string_is_wide_literal), $uint2short(diag.warn_format_zero_positional_specifier), $uint2short(diag.warn_missing_format_string), $uint2short(diag.warn_printf_ObjCflags_without_ObjCConversion), $uint2short(diag.warn_printf_asterisk_missing_arg), $uint2short(diag.warn_printf_asterisk_wrong_type), $uint2short(diag.warn_printf_empty_objc_flag), $uint2short(diag.warn_printf_format_string_contains_null_char), $uint2short(diag.warn_printf_format_string_not_null_terminated), $uint2short(diag.warn_printf_ignored_flag), $uint2short(diag.warn_printf_incomplete_specifier), $uint2short(diag.warn_printf_insufficient_data_args), $uint2short(diag.warn_printf_invalid_objc_flag), $uint2short(diag.warn_printf_nonsensical_flag), $uint2short(diag.warn_printf_nonsensical_optional_amount), $uint2short(diag.warn_printf_positional_arg_exceeds_data_args), $uint2short(diag.warn_scanf_nonzero_width), $uint2short(diag.warn_scanf_scanlist_incomplete), -1, 
  /* DiagArray193 */ $uint2short(diag.warn_printf_data_arg_not_used), -1, 
  /* DiagArray194 */ $uint2short(diag.warn_format_invalid_conversion), -1, 
  /* DiagArray195 */ $uint2short(diag.warn_format_non_standard), $uint2short(diag.warn_format_non_standard_conversion_spec), $uint2short(diag.warn_format_non_standard_positional_arg), -1, 
  /* DiagArray196 */ $uint2short(diag.warn_format_nonliteral), -1, 
  /* DiagArray197 */ $uint2short(diag.warn_format_conversion_argument_type_mismatch_pedantic), -1, 
  /* DiagArray198 */ $uint2short(diag.warn_format_nonliteral_noargs), -1, 
  /* DiagArray200 */ $uint2short(diag.warn_empty_format_string), -1, 
  /* DiagArray202 */ $uint2short(diag.ext_four_char_character_literal), -1, 
  /* DiagArray203 */ $uint2short(diag.warn_fe_backend_frame_larger_than), $uint2short(diag.warn_fe_frame_larger_than), -1, 
  /* DiagArray204 */ $uint2short(diag.warn_function_def_in_objc_container), -1, 
  /* DiagArray206 */ $uint2short(diag.ext_clang_enable_if), $uint2short(diag.warn_attribute_on_function_definition), $uint2short(diag.warn_break_binds_to_switch), $uint2short(diag.warn_cleanup_ext), $uint2short(diag.warn_gcc_attribute_location), $uint2short(diag.warn_loop_ctrl_binds_to_inner), -1, 
  /* DiagArray207 */ $uint2short(diag.warn_global_constructor), $uint2short(diag.warn_global_destructor), -1, 
  /* DiagArray209 */ $uint2short(diag.ext_alignof_expr), -1, 
  /* DiagArray210 */ $uint2short(diag.ext_gnu_anonymous_struct), -1, 
  /* DiagArray211 */ $uint2short(diag.ext_array_init_parens), -1, 
  /* DiagArray212 */ $uint2short(diag.ext_auto_type), -1, 
  /* DiagArray213 */ $uint2short(diag.ext_binary_literal), -1, 
  /* DiagArray214 */ $uint2short(diag.ext_gnu_case_range), -1, 
  /* DiagArray215 */ $uint2short(diag.ext_integer_complex), -1, 
  /* DiagArray216 */ $uint2short(diag.ext_array_init_copy), -1, 
  /* DiagArray217 */ $uint2short(diag.ext_gnu_conditional_expr), -1, 
  /* DiagArray218 */ $uint2short(diag.ext_gnu_array_range), $uint2short(diag.ext_gnu_missing_equal_designator), $uint2short(diag.ext_gnu_old_style_field_designator), -1, 
  /* DiagArray219 */ $uint2short(diag.ext_gnu_empty_initializer), -1, 
  /* DiagArray220 */ $uint2short(diag.ext_empty_struct_union), $uint2short(diag.ext_flexible_array_empty_aggregate_gnu), $uint2short(diag.ext_no_named_members_in_struct_union), -1, 
  /* DiagArray221 */ $uint2short(diag.ext_flexible_array_init), -1, 
  /* DiagArray222 */ $uint2short(diag.ext_flexible_array_union_gnu), -1, 
  /* DiagArray223 */ $uint2short(diag.ext_expr_not_ice), $uint2short(diag.ext_in_class_initializer_non_constant), $uint2short(diag.ext_vla_folded_to_constant), -1, 
  /* DiagArray224 */ $uint2short(diag.ext_imaginary_constant), -1, 
  /* DiagArray225 */ $uint2short(diag.ext_pp_include_next_directive), -1, 
  /* DiagArray226 */ $uint2short(diag.ext_gnu_address_of_label), $uint2short(diag.ext_gnu_indirect_goto), -1, 
  /* DiagArray227 */ $uint2short(diag.ext_forward_ref_enum_def), -1, 
  /* DiagArray228 */ $uint2short(diag.ext_gnu_statement_expr), -1, 
  /* DiagArray229 */ $uint2short(diag.ext_in_class_initializer_float_type), -1, 
  /* DiagArray230 */ $uint2short(diag.ext_string_literal_operator_template), -1, 
  /* DiagArray231 */ $uint2short(diag.ext_typecheck_cast_to_union), -1, 
  /* DiagArray232 */ $uint2short(diag.ext_variable_sized_type_in_struct), -1, 
  /* DiagArray233 */ $uint2short(diag.ext_pp_line_zero), -1, 
  /* DiagArray234 */ $uint2short(diag.ext_missing_varargs_arg), $uint2short(diag.ext_paste_comma), -1, 
  /* DiagArray235 */ $uint2short(diag.warn_header_guard), -1, 
  /* DiagArray236 */ $uint2short(diag.warn_using_directive_in_header), -1, 
  /* DiagArray237 */ $uint2short(diag.warn_condition_is_idiomatic_assignment), -1, 
  /* DiagArray238 */ $uint2short(diag.warn_alias_to_weak_alias), $uint2short(diag.warn_alias_with_section), $uint2short(diag.warn_attr_abi_tag_namespace), $uint2short(diag.warn_attribute_after_definition_ignored), $uint2short(diag.warn_attribute_iboutlet), $uint2short(diag.warn_attribute_ignored), $uint2short(diag.warn_attribute_ignored_on_inline), $uint2short(diag.warn_attribute_invalid_on_definition), $uint2short(diag.warn_attribute_no_decl), $uint2short(diag.warn_attribute_nonnull_no_pointers), $uint2short(diag.warn_attribute_nonnull_parm_no_args), $uint2short(diag.warn_attribute_not_on_decl), $uint2short(diag.warn_attribute_pointer_or_reference_only), $uint2short(diag.warn_attribute_pointers_only), $uint2short(diag.warn_attribute_precede_definition), $uint2short(diag.warn_attribute_return_pointers_only), $uint2short(diag.warn_attribute_return_pointers_refs_only), $uint2short(diag.warn_attribute_sentinel_named_arguments), $uint2short(diag.warn_attribute_sentinel_not_variadic), $uint2short(diag.warn_attribute_type_not_supported), $uint2short(diag.warn_attribute_unknown_visibility), $uint2short(diag.warn_attribute_void_function_method), $uint2short(diag.warn_attribute_weak_on_field), $uint2short(diag.warn_attribute_weak_on_local), $uint2short(diag.warn_attribute_wrong_decl_type), $uint2short(diag.warn_block_literal_attributes_on_omitted_return_type), $uint2short(diag.warn_cconv_ignored), $uint2short(diag.warn_cconv_structors), $uint2short(diag.warn_cconv_varargs), $uint2short(diag.warn_cxx11_gnu_attribute_on_type), $uint2short(diag.warn_declspec_attribute_ignored), $uint2short(diag.warn_deprecated_anonymous_namespace), $uint2short(diag.warn_dllimport_dropped_from_inline_function), $uint2short(diag.warn_duplicate_attribute), $uint2short(diag.warn_duplicate_attribute_exact), $uint2short(diag.warn_gc_attribute_weak_on_local), $uint2short(diag.warn_gnu_inline_attribute_requires_inline), $uint2short(diag.warn_ignored_ms_inheritance), $uint2short(diag.warn_internal_linkage_local_storage), $uint2short(diag.warn_microsoft_qualifiers_ignored), $uint2short(diag.warn_mips_interrupt_attribute), $uint2short(diag.warn_mmap_unknown_attribute), $uint2short(diag.warn_ns_attribute_wrong_parameter_type), $uint2short(diag.warn_ns_attribute_wrong_return_type), $uint2short(diag.warn_opencl_attr_deprecated_ignored), $uint2short(diag.warn_transparent_union_attribute_field_size_align), $uint2short(diag.warn_transparent_union_attribute_floating), $uint2short(diag.warn_transparent_union_attribute_not_definition), $uint2short(diag.warn_transparent_union_attribute_zero_fields), $uint2short(diag.warn_type_attribute_wrong_type), $uint2short(diag.warn_unhandled_ms_attribute_ignored), $uint2short(diag.warn_unsupported_target_attribute), -1, 
  /* DiagArray239 */ $uint2short(diag.warn_ignored_gcc_optimization), -1, 
  /* DiagArray240 */ $uint2short(diag.warn_pragma_align_expected_equal), $uint2short(diag.warn_pragma_align_invalid_option), $uint2short(diag.warn_pragma_comment_ignored), $uint2short(diag.warn_pragma_debug_missing_argument), $uint2short(diag.warn_pragma_debug_unexpected_command), $uint2short(diag.warn_pragma_expected_action_or_r_paren), $uint2short(diag.warn_pragma_expected_colon), $uint2short(diag.warn_pragma_expected_colon_r_paren), $uint2short(diag.warn_pragma_expected_enable_disable), $uint2short(diag.warn_pragma_expected_identifier), $uint2short(diag.warn_pragma_expected_init_seg), $uint2short(diag.warn_pragma_expected_integer), $uint2short(diag.warn_pragma_expected_lparen), $uint2short(diag.warn_pragma_expected_non_wide_string), $uint2short(diag.warn_pragma_expected_punc), $uint2short(diag.warn_pragma_expected_rparen), $uint2short(diag.warn_pragma_expected_section_label_or_name), $uint2short(diag.warn_pragma_expected_section_name), $uint2short(diag.warn_pragma_expected_section_push_pop_or_name), $uint2short(diag.warn_pragma_extra_tokens_at_eol), $uint2short(diag.warn_pragma_init_seg_unsupported_target), $uint2short(diag.warn_pragma_invalid_action), $uint2short(diag.warn_pragma_invalid_specific_action), $uint2short(diag.warn_pragma_ms_struct), $uint2short(diag.warn_pragma_options_align_reset_failed), $uint2short(diag.warn_pragma_options_expected_align), $uint2short(diag.warn_pragma_pack_invalid_alignment), $uint2short(diag.warn_pragma_pack_malformed), $uint2short(diag.warn_pragma_pop_failed), $uint2short(diag.warn_pragma_pop_macro_no_push), $uint2short(diag.warn_pragma_unknown_extension), $uint2short(diag.warn_pragma_unsupported_action), $uint2short(diag.warn_pragma_unsupported_extension), $uint2short(diag.warn_pragma_unused_expected_var), $uint2short(diag.warn_pragma_unused_expected_var_arg), $uint2short(diag.warn_pragma_unused_undeclared_var), -1, 
  /* DiagArray241 */ $uint2short(diag.warn_arc_lifetime_result_type), $uint2short(diag.warn_block_literal_qualifiers_on_omitted_return_type), $uint2short(diag.warn_qual_return_type), $uint2short(diag.warn_typecheck_function_qualifiers_ignored), $uint2short(diag.warn_typecheck_reference_qualifiers), -1, 
  /* DiagArray243 */ $uint2short(diag.warn_auto_implicit_atomic_property), $uint2short(diag.warn_implicit_atomic_property), -1, 
  /* DiagArray244 */ $uint2short(diag.warn_impcast_floating_point_to_bool), -1, 
  /* DiagArray245 */ $uint2short(diag.ext_implicit_exception_spec_mismatch), -1, 
  /* DiagArray246 */ $uint2short(diag.warn_fallthrough_attr_unreachable), $uint2short(diag.warn_unannotated_fallthrough), -1, 
  /* DiagArray247 */ $uint2short(diag.warn_unannotated_fallthrough_per_function), -1, 
  /* DiagArray248 */ $uint2short(diag.ext_implicit_function_decl), $uint2short(diag.ext_implicit_lib_function_decl), $uint2short(diag.warn_builtin_unknown), $uint2short(diag.warn_implicit_function_decl), -1, 
  /* DiagArray249 */ $uint2short(diag.ext_missing_type_specifier), -1, 
  /* DiagArray250 */ $uint2short(diag.warn_implicitly_retains_self), -1, 
  /* DiagArray251 */ $uint2short(diag.ext_integer_literal_too_large_for_signed), -1, 
  /* DiagArray253 */ $uint2short(diag.ext_pp_import_directive), -1, 
  /* DiagArray254 */ $uint2short(diag.warn_inaccessible_base_class), -1, 
  /* DiagArray255 */ $uint2short(diag.pp_include_next_absolute_path), -1, 
  /* DiagArray256 */ $uint2short(diag.pp_include_next_in_primary), -1, 
  /* DiagArray257 */ $uint2short(diag.warn_redecl_library_builtin), -1, 
  /* DiagArray258 */ $uint2short(diag.warn_cxx_ms_struct), -1, 
  /* DiagArray259 */ $uint2short(diag.ext_typecheck_convert_incompatible_pointer), -1, 
  /* DiagArray260 */ $uint2short(diag.ext_nested_pointer_qualifier_mismatch), $uint2short(diag.ext_typecheck_convert_discards_qualifiers), -1, 
  /* DiagArray261 */ $uint2short(diag.warn_property_types_are_incompatible), -1, 
  /* DiagArray262 */ $uint2short(diag.warn_incompatible_sysroot), -1, 
  /* DiagArray263 */ $uint2short(diag.warn_undef_method_impl), -1, 
  /* DiagArray265 */ $uint2short(diag.warn_missing_submodule), $uint2short(diag.warn_uncovered_module_header), -1, 
  /* DiagArray266 */ $uint2short(diag.warn_redeclaration_without_attribute_prev_attribute_ignored), $uint2short(diag.warn_redeclaration_without_import_attribute), -1, 
  /* DiagArray267 */ $uint2short(diag.warn_function_marked_not_override_overriding), -1, 
  /* DiagArray268 */ $uint2short(diag.ext_increment_bool), -1, 
  /* DiagArray269 */ $uint2short(diag.warn_infinite_recursive_function), -1, 
  /* DiagArray271 */ $uint2short(diag.warn_initializer_overrides), $uint2short(diag.warn_subobject_initializer_overrides), -1, 
  /* DiagArray273 */ $uint2short(diag.warn_fe_inline_asm), -1, 
  /* DiagArray274 */ $uint2short(diag.ext_operator_new_delete_declared_inline), -1, 
  /* DiagArray275 */ $uint2short(diag.ext_typecheck_convert_int_pointer), $uint2short(diag.ext_typecheck_convert_pointer_int), -1, 
  /* DiagArray277 */ $uint2short(diag.warn_int_to_pointer_cast), -1, 
  /* DiagArray278 */ $uint2short(diag.warn_int_to_void_pointer_cast), -1, 
  /* DiagArray279 */ $uint2short(diag.warn_integer_constant_overflow), -1, 
  /* DiagArray280 */ $uint2short(diag.warn_drv_optimization_value), -1, 
  /* DiagArray281 */ $uint2short(diag.ext_constexpr_function_never_constant_expr), -1, 
  /* DiagArray282 */ $uint2short(diag.warn_iboutlet_object_type), $uint2short(diag.warn_iboutletcollection_property_assign), -1, 
  /* DiagArray283 */ $uint2short(diag.warn_invalid_initializer_from_system_header), -1, 
  /* DiagArray284 */ $uint2short(diag.warn_falloff_noreturn_function), $uint2short(diag.warn_noreturn_function_has_return_expr), -1, 
  /* DiagArray285 */ $uint2short(diag.ext_offsetof_non_pod_type), $uint2short(diag.ext_offsetof_non_standardlayout_type), -1, 
  /* DiagArray286 */ $uint2short(diag.warn_drv_ps4_sdk_dir), $uint2short(diag.warn_drv_unable_to_find_directory_expected), -1, 
  /* DiagArray288 */ $uint2short(diag.ext_empty_character), $uint2short(diag.ext_unterminated_char_or_string), -1, 
  /* DiagArray289 */ $uint2short(diag.warn_bad_character_encoding), $uint2short(diag.warn_bad_string_encoding), -1, 
  /* DiagArray290 */ $uint2short(diag.ext_pp_bad_paste_ms), -1, 
  /* DiagArray291 */ $uint2short(diag.warn_jump_out_of_seh_finally), -1, 
  /* DiagArray292 */ $uint2short(diag.ext_keyword_as_ident), -1, 
  /* DiagArray293 */ $uint2short(diag.warn_pp_macro_hides_keyword), -1, 
  /* DiagArray294 */ $uint2short(diag.ext_param_promoted_not_compatible_with_prototype), -1, 
  /* DiagArray295 */ $uint2short(diag.ext_token_used), -1, 
  /* DiagArray296 */ $uint2short(diag.warn_parameter_size), $uint2short(diag.warn_return_value_size), -1, 
  /* DiagArray297 */ $uint2short(diag.warn_drv_lto_libpath), -1, 
  /* DiagArray298 */ $uint2short(diag.warn_impcast_literal_float_to_integer), -1, 
  /* DiagArray299 */ $uint2short(diag.warn_float_overflow), $uint2short(diag.warn_float_underflow), -1, 
  /* DiagArray300 */ $uint2short(diag.ext_template_arg_local_type), -1, 
  /* DiagArray301 */ $uint2short(diag.warn_logical_not_on_lhs_of_comparison), -1, 
  /* DiagArray302 */ $uint2short(diag.warn_logical_and_in_logical_or), -1, 
  /* DiagArray303 */ $uint2short(diag.ext_c99_longlong), -1, 
  /* DiagArray305 */ $uint2short(diag.ext_pp_macro_redef), -1, 
  /* DiagArray306 */ $uint2short(diag.ext_main_used), $uint2short(diag.ext_noreturn_main), $uint2short(diag.ext_variadic_main), $uint2short(diag.warn_main_one_arg), $uint2short(diag.warn_main_redefined), $uint2short(diag.warn_static_main), -1, 
  /* DiagArray307 */ $uint2short(diag.ext_main_returns_nonint), -1, 
  /* DiagArray308 */ $uint2short(diag.warn_has_warning_invalid_option), -1, 
  /* DiagArray309 */ $uint2short(diag.ext_many_braces_around_scalar_init), -1, 
  /* DiagArray310 */ $uint2short(diag.warn_memsize_comparison), -1, 
  /* DiagArray311 */ $uint2short(diag.warn_non_contravariant_param_types), $uint2short(diag.warn_non_covariant_ret_types), -1, 
  /* DiagArray313 */ $uint2short(diag.ext_anonymous_record_with_type), $uint2short(diag.ext_ms_anonymous_record), -1, 
  /* DiagArray314 */ $uint2short(diag.ext_ms_cast_fn_obj), $uint2short(diag.ext_ms_impcast_fn_obj), -1, 
  /* DiagArray315 */ $uint2short(diag.ext_charize_microsoft), -1, 
  /* DiagArray316 */ $uint2short(diag.ext_comment_paste_microsoft), -1, 
  /* DiagArray317 */ $uint2short(diag.ext_default_init_const), -1, 
  /* DiagArray318 */ $uint2short(diag.ext_pp_operator_used_as_macro_name), -1, 
  /* DiagArray319 */ $uint2short(diag.ext_param_default_argument_redefinition), -1, 
  /* DiagArray320 */ $uint2short(diag.ext_ctrl_z_eof_microsoft), -1, 
  /* DiagArray321 */ $uint2short(diag.ext_ms_forward_ref_enum), -1, 
  /* DiagArray322 */ $uint2short(diag.ext_enumerator_too_large), -1, 
  /* DiagArray323 */ $uint2short(diag.ext_ellipsis_exception_spec), $uint2short(diag.ext_incomplete_in_exception_spec), $uint2short(diag.ext_mismatched_exception_spec), $uint2short(diag.ext_mismatched_exception_spec_explicit_instantiation), $uint2short(diag.ext_ms_missing_exception_specification), $uint2short(diag.ext_override_exception_spec), -1, 
  /* DiagArray324 */ $uint2short(diag.warn_microsoft_dependent_exists), -1, 
  /* DiagArray325 */ $uint2short(diag.ext_ms_explicit_constructor_call), -1, 
  /* DiagArray326 */ $uint2short(diag.warn_member_extra_qualification), -1, 
  /* DiagArray327 */ $uint2short(diag.ext_c_enum_fixed_underlying_type), -1, 
  /* DiagArray328 */ $uint2short(diag.ext_flexible_array_empty_aggregate_ms), $uint2short(diag.ext_flexible_array_union_ms), -1, 
  /* DiagArray329 */ $uint2short(diag.ext_goto_into_protected_scope), -1, 
  /* DiagArray330 */ $uint2short(diag.ext_pp_include_search_ms), -1, 
  /* DiagArray331 */ $uint2short(diag.ext_mutable_reference), -1, 
  /* DiagArray332 */ $uint2short(diag.ext_pure_function_definition), -1, 
  /* DiagArray333 */ $uint2short(diag.ext_static_non_static), -1, 
  /* DiagArray334 */ $uint2short(diag.ext_ms_sealed_keyword), -1, 
  /* DiagArray335 */ $uint2short(diag.ext_explicit_instantiation_duplicate), $uint2short(diag.ext_found_via_dependent_bases_lookup), $uint2short(diag.ext_function_specialization_in_class), $uint2short(diag.ext_ms_delayed_template_argument), $uint2short(diag.ext_ms_deref_template_argument), $uint2short(diag.ext_ms_template_spec_redecl_out_of_scope), $uint2short(diag.ext_ms_template_type_arg_missing_typename), $uint2short(diag.ext_undeclared_unqual_id_with_dependent_base), -1, 
  /* DiagArray336 */ $uint2short(diag.ext_union_member_of_reference_type), -1, 
  /* DiagArray337 */ $uint2short(diag.ext_friend_tag_redecl_outside_namespace), -1, 
  /* DiagArray338 */ $uint2short(diag.ext_ms_using_declaration_inaccessible), -1, 
  /* DiagArray339 */ $uint2short(diag.ext_pseudo_dtor_on_void), -1, 
  /* DiagArray340 */ $uint2short(diag.warn_mismatched_delete_new), -1, 
  /* DiagArray341 */ $uint2short(diag.warn_conflicting_param_types), -1, 
  /* DiagArray342 */ $uint2short(diag.warn_conflicting_ret_types), -1, 
  /* DiagArray343 */ $uint2short(diag.warn_struct_class_previous_tag_mismatch), $uint2short(diag.warn_struct_class_tag_mismatch), -1, 
  /* DiagArray344 */ $uint2short(diag.warn_missing_braces), -1, 
  /* DiagArray345 */ $uint2short(diag.ext_no_declarators), $uint2short(diag.ext_standalone_specifier), $uint2short(diag.ext_typedef_without_a_name), $uint2short(diag.warn_standalone_specifier), -1, 
  /* DiagArray346 */ $uint2short(diag.ext_missing_exception_specification), -1, 
  /* DiagArray347 */ $uint2short(diag.warn_missing_field_initializers), -1, 
  /* DiagArray350 */ $uint2short(diag.warn_missing_method_return_type), -1, 
  /* DiagArray351 */ $uint2short(diag.warn_suggest_noreturn_block), $uint2short(diag.warn_suggest_noreturn_function), -1, 
  /* DiagArray352 */ $uint2short(diag.warn_cconv_knr), -1, 
  /* DiagArray353 */ $uint2short(diag.warn_missing_prototype), -1, 
  /* DiagArray354 */ $uint2short(diag.warn_missing_selector_name), -1, 
  /* DiagArray355 */ $uint2short(diag.warn_missing_sysroot), -1, 
  /* DiagArray356 */ $uint2short(diag.warn_missing_variable_declarations), -1, 
  /* DiagArray357 */ $uint2short(diag.remark_module_build), $uint2short(diag.remark_module_build_done), -1, 
  /* DiagArray358 */ $uint2short(diag.warn_module_conflict), -1, 
  /* DiagArray359 */ $uint2short(diag.warn_module_config_mismatch), -1, 
  /* DiagArray360 */ $uint2short(diag.warn_duplicate_module_file_extension), -1, 
  /* DiagArray361 */ $uint2short(diag.ext_module_import_in_extern_c), -1, 
  /* DiagArray362 */ $uint2short(diag.ext_equivalent_internal_linkage_decl_in_modules), -1, 
  /* DiagArray363 */ $uint2short(diag.ext_module_import_not_at_top_level_noop), -1, 
  /* DiagArray367 */ $uint2short(diag.ext_multichar_character_literal), -1, 
  /* DiagArray368 */ $uint2short(diag.warn_vbase_moved_multiple_times), -1, 
  /* DiagArray370 */ $uint2short(diag.ext_anonymous_record_with_anonymous_type), -1, 
  /* DiagArray372 */ $uint2short(diag.warn_operator_new_returns_null), -1, 
  /* DiagArray373 */ $uint2short(diag.ext_no_newline_eof), $uint2short(diag.warn_no_newline_eof), -1, 
  /* DiagArray375 */ $uint2short(diag.warn_non_literal_null_pointer), -1, 
  /* DiagArray376 */ $uint2short(diag.warn_non_modular_include_in_framework_module), -1, 
  /* DiagArray377 */ $uint2short(diag.warn_non_modular_include_in_module), -1, 
  /* DiagArray378 */ $uint2short(diag.warn_cannot_pass_non_pod_arg_to_vararg), $uint2short(diag.warn_non_pod_vararg_with_format_string), $uint2short(diag.warn_second_parameter_to_va_arg_not_pod), $uint2short(diag.warn_second_parameter_to_va_arg_ownership_qualified), -1, 
  /* DiagArray379 */ $uint2short(diag.warn_non_virtual_dtor), -1, 
  /* DiagArray380 */ $uint2short(diag.warn_null_arg), $uint2short(diag.warn_null_ret), -1, 
  /* DiagArray382 */ $uint2short(diag.pp_nonportable_path), -1, 
  /* DiagArray383 */ $uint2short(diag.pp_nonportable_system_path), -1, 
  /* DiagArray384 */ $uint2short(diag.warn_neon_vector_initializer_non_portable), -1, 
  /* DiagArray385 */ $uint2short(diag.warn_null_in_arithmetic_operation), $uint2short(diag.warn_null_in_comparison_operation), -1, 
  /* DiagArray386 */ $uint2short(diag.null_in_char_or_string), $uint2short(diag.null_in_file), -1, 
  /* DiagArray387 */ $uint2short(diag.warn_impcast_null_pointer_to_integer), -1, 
  /* DiagArray388 */ $uint2short(diag.warn_binding_null_to_reference), $uint2short(diag.warn_indirection_through_null), -1, 
  /* DiagArray389 */ $uint2short(diag.warn_conflicting_nullability_attr_overriding_param_types), $uint2short(diag.warn_conflicting_nullability_attr_overriding_ret_types), $uint2short(diag.warn_mismatched_nullability_attr), $uint2short(diag.warn_null_resettable_setter), $uint2short(diag.warn_nullability_duplicate), -1, 
  /* DiagArray390 */ $uint2short(diag.warn_nullability_missing), -1, 
  /* DiagArray391 */ $uint2short(diag.warn_nullability_declspec), -1, 
  /* DiagArray392 */ $uint2short(diag.ext_nullability), -1, 
  /* DiagArray393 */ $uint2short(diag.warn_nullability_lost), -1, 
  /* DiagArray394 */ $uint2short(diag.warn_autosynthesis_property_ivar_match), -1, 
  /* DiagArray395 */ $uint2short(diag.warn_objc_circular_container), -1, 
  /* DiagArray397 */ $uint2short(diag.warn_objc_designated_init_missing_super_call), $uint2short(diag.warn_objc_designated_init_non_designated_init_call), $uint2short(diag.warn_objc_designated_init_non_super_designated_init_call), $uint2short(diag.warn_objc_implementation_missing_designated_init_override), $uint2short(diag.warn_objc_secondary_init_missing_init_call), $uint2short(diag.warn_objc_secondary_init_super_init_call), -1, 
  /* DiagArray398 */ $uint2short(diag.warn_forward_class_redefinition), -1, 
  /* DiagArray399 */ $uint2short(diag.warn_ivars_in_interface), -1, 
  /* DiagArray400 */ $uint2short(diag.warn_objc_literal_comparison), -1, 
  /* DiagArray401 */ $uint2short(diag.warn_impcast_objective_c_literal_to_bool), $uint2short(diag.warn_objc_collection_literal_element), -1, 
  /* DiagArray402 */ $uint2short(diag.warn_pp_objc_macro_redef_ignored), -1, 
  /* DiagArray403 */ $uint2short(diag.warn_class_method_not_found), $uint2short(diag.warn_class_method_not_found_with_typo), $uint2short(diag.warn_inst_method_not_found), $uint2short(diag.warn_instance_method_not_found_with_typo), $uint2short(diag.warn_instance_method_on_class_found), $uint2short(diag.warn_root_inst_method_not_found), -1, 
  /* DiagArray404 */ $uint2short(diag.warn_missing_explicit_synthesis), -1, 
  /* DiagArray405 */ $uint2short(diag.warn_objc_missing_super_call), -1, 
  /* DiagArray406 */ $uint2short(diag.warn_multiple_method_decl), -1, 
  /* DiagArray407 */ $uint2short(diag.warn_objc_property_retain_of_block), -1, 
  /* DiagArray408 */ $uint2short(diag.warn_objc_pointer_cxx_catch_fragile), -1, 
  /* DiagArray409 */ $uint2short(diag.warn_impl_required_for_class_property), $uint2short(diag.warn_impl_required_in_category_for_class_property), $uint2short(diag.warn_setter_getter_impl_required), $uint2short(diag.warn_setter_getter_impl_required_in_category), -1, 
  /* DiagArray410 */ $uint2short(diag.warn_property_implicitly_mismatched), -1, 
  /* DiagArray411 */ $uint2short(diag.warn_cocoa_naming_owned_rule), -1, 
  /* DiagArray412 */ $uint2short(diag.warn_objc_property_default_assign_on_object), $uint2short(diag.warn_objc_property_no_assignment_attribute), -1, 
  /* DiagArray413 */ $uint2short(diag.warn_autosynthesis_property_in_superclass), $uint2short(diag.warn_no_autosynthesis_property), $uint2short(diag.warn_no_autosynthesis_shared_ivar_property), -1, 
  /* DiagArray414 */ $uint2short(diag.warn_category_method_impl_match), -1, 
  /* DiagArray415 */ $uint2short(diag.warn_auto_synthesizing_protocol_property), -1, 
  /* DiagArray416 */ $uint2short(diag.warn_objc_redundant_qualified_class_type), -1, 
  /* DiagArray417 */ $uint2short(diag.warn_objc_readonly_property_has_setter), -1, 
  /* DiagArray419 */ $uint2short(diag.warn_objc_redundant_literal_use), -1, 
  /* DiagArray420 */ $uint2short(diag.warn_objc_root_class_missing), -1, 
  /* DiagArray421 */ $uint2short(diag.warn_objc_string_literal_comparison), -1, 
  /* DiagArray422 */ $uint2short(diag.warn_concatenated_nsarray_literal), -1, 
  /* DiagArray423 */ $uint2short(diag.warn_odr_tag_type_inconsistent), -1, 
  /* DiagArray424 */ $uint2short(diag.warn_old_style_cast), -1, 
  /* DiagArray426 */ $uint2short(diag.warn_omp_alignment_not_power_of_two), $uint2short(diag.warn_omp_linear_step_zero), -1, 
  /* DiagArray427 */ $uint2short(diag.ext_omp_loop_not_canonical_init), $uint2short(diag.warn_omp_loop_64_bit_var), -1, 
  /* DiagArray428 */ $uint2short(diag.warn_omp_not_in_target_context), -1, 
  /* DiagArray429 */ $uint2short(diag.warn_drv_ps4_force_pic), -1, 
  /* DiagArray430 */ $uint2short(diag.ext_out_of_line_declaration), -1, 
  /* DiagArray431 */ $uint2short(diag.warn_overaligned_type), -1, 
  /* DiagArray433 */ $uint2short(diag.ext_string_too_long), -1, 
  /* DiagArray434 */ $uint2short(diag.warn_overloaded_shift_in_comparison), -1, 
  /* DiagArray435 */ $uint2short(diag.warn_overloaded_virtual), -1, 
  /* DiagArray436 */ $uint2short(diag.warn_fe_override_module), -1, 
  /* DiagArray437 */ $uint2short(diag.warn_conflicting_overriding_param_modifiers), $uint2short(diag.warn_conflicting_overriding_param_types), $uint2short(diag.warn_conflicting_overriding_ret_type_modifiers), $uint2short(diag.warn_conflicting_overriding_ret_types), $uint2short(diag.warn_conflicting_overriding_variadic), $uint2short(diag.warn_non_contravariant_overriding_param_types), $uint2short(diag.warn_non_covariant_overriding_ret_types), -1, 
  /* DiagArray438 */ $uint2short(diag.warn_drv_overriding_flag_option), -1, 
  /* DiagArray439 */ $uint2short(diag.warn_unnecessary_packed), -1, 
  /* DiagArray440 */ $uint2short(diag.warn_padded_struct_anon_field), $uint2short(diag.warn_padded_struct_field), $uint2short(diag.warn_padded_struct_size), -1, 
  /* DiagArray441 */ $uint2short(diag.warn_condition_is_assignment), $uint2short(diag.warn_precedence_bitwise_rel), $uint2short(diag.warn_precedence_conditional), -1, 
  /* DiagArray442 */ $uint2short(diag.warn_equality_with_extra_parens), -1, 
  /* DiagArray443 */ $uint2short(diag.warn_partial_availability), $uint2short(diag.warn_partial_fwdclass_message), $uint2short(diag.warn_partial_message), -1, 
  /* DiagArray444 */ $uint2short(diag.remark_fe_backend_optimization_remark), -1, 
  /* DiagArray445 */ $uint2short(diag.remark_fe_backend_optimization_remark_analysis), $uint2short(diag.remark_fe_backend_optimization_remark_analysis_aliasing), $uint2short(diag.remark_fe_backend_optimization_remark_analysis_fpcommute), -1, 
  /* DiagArray446 */ $uint2short(diag.warn_fe_backend_optimization_failure), -1, 
  /* DiagArray447 */ $uint2short(diag.remark_fe_backend_optimization_remark_missed), -1, 
  /* DiagArray448 */ $uint2short(diag.warn_module_uses_date_time), -1, 
  /* DiagArray449 */ $uint2short(diag.ext_aggregate_init_not_constant), $uint2short(diag.ext_anonymous_record_with_type), $uint2short(diag.ext_anonymous_struct_union_qualified), $uint2short(diag.ext_array_size_conversion), $uint2short(diag.ext_c99_array_usage), $uint2short(diag.ext_c99_compound_literal), $uint2short(diag.ext_c99_flexible_array_member), $uint2short(diag.ext_c99_variable_decl_in_for_loop), $uint2short(diag.ext_cast_fn_obj), $uint2short(diag.ext_clang_enable_if), $uint2short(diag.ext_cxx11_enum_fixed_underlying_type), $uint2short(diag.ext_cxx14_attr), $uint2short(diag.ext_cxx1z_attr), $uint2short(diag.ext_designated_init), $uint2short(diag.ext_ellipsis_exception_spec), $uint2short(diag.ext_empty_fnmacro_arg), $uint2short(diag.ext_enum_value_not_int), $uint2short(diag.ext_enumerator_list_comma_c), $uint2short(diag.ext_enumerator_list_comma_cxx), $uint2short(diag.ext_explicit_instantiation_after_specialization), $uint2short(diag.ext_explicit_instantiation_without_qualified_id), $uint2short(diag.ext_extern_template), $uint2short(diag.ext_extra_semi), $uint2short(diag.ext_forward_ref_enum), $uint2short(diag.ext_freestanding_complex), $uint2short(diag.ext_gnu_array_range), $uint2short(diag.ext_gnu_ptr_func_arith), $uint2short(diag.ext_gnu_subscript_void_type), $uint2short(diag.ext_gnu_void_ptr), $uint2short(diag.ext_hex_constant_invalid), $uint2short(diag.ext_hex_literal_invalid), $uint2short(diag.ext_ident_list_in_param), $uint2short(diag.ext_integer_complement_complex), $uint2short(diag.ext_integer_increment_complex), $uint2short(diag.ext_internal_in_extern_inline_quiet), $uint2short(diag.ext_invalid_sign_spec), $uint2short(diag.ext_line_comment), $uint2short(diag.ext_main_used), $uint2short(diag.ext_multi_line_line_comment), $uint2short(diag.ext_no_newline_eof), $uint2short(diag.ext_nonstandard_escape), $uint2short(diag.ext_param_not_declared), $uint2short(diag.ext_pp_bad_vaargs_use), $uint2short(diag.ext_pp_comma_expr), $uint2short(diag.ext_pp_ident_directive), $uint2short(diag.ext_pp_line_too_big), $uint2short(diag.ext_pp_warning_directive), $uint2short(diag.ext_return_has_void_expr), $uint2short(diag.ext_rvalue_to_reference_access_ctor), $uint2short(diag.ext_rvalue_to_reference_temp_copy_no_viable), $uint2short(diag.ext_sizeof_alignof_function_type), $uint2short(diag.ext_sizeof_alignof_void_type), $uint2short(diag.ext_subscript_non_lvalue), $uint2short(diag.ext_thread_before), $uint2short(diag.ext_typecheck_addrof_void), $uint2short(diag.ext_typecheck_cast_nonscalar), $uint2short(diag.ext_typecheck_comparison_of_fptr_to_void), $uint2short(diag.ext_typecheck_cond_one_void), $uint2short(diag.ext_typecheck_convert_pointer_void_func), $uint2short(diag.ext_typecheck_ordered_comparison_of_pointer_and_zero), $uint2short(diag.warn_defined_in_function_type_macro), $uint2short(diag.warn_illegal_constant_array_size), $uint2short(diag.warn_kern_is_method), -1, 
  /* DiagArray450 */ $uint2short(diag.warn_pragma_extension_is_core), -1, 
  /* DiagArray451 */ $uint2short(diag.warn_pessimizing_move_on_initialization), $uint2short(diag.warn_pessimizing_move_on_return), -1, 
  /* DiagArray452 */ $uint2short(diag.ext_gnu_ptr_func_arith), $uint2short(diag.ext_gnu_subscript_void_type), $uint2short(diag.ext_gnu_void_ptr), $uint2short(diag.ext_sizeof_alignof_function_type), $uint2short(diag.ext_sizeof_alignof_void_type), $uint2short(diag.warn_sub_ptr_zero_size_types), -1, 
  /* DiagArray453 */ $uint2short(diag.warn_cast_nonnull_to_bool), $uint2short(diag.warn_impcast_pointer_to_bool), -1, 
  /* DiagArray454 */ $uint2short(diag.ext_typecheck_convert_incompatible_pointer_sign), -1, 
  /* DiagArray456 */ $uint2short(diag.ext_typecheck_cond_incompatible_pointers), -1, 
  /* DiagArray457 */ $uint2short(diag.warn_side_effects_typeid), -1, 
  /* DiagArray458 */ $uint2short(diag.pp_pragma_once_in_main_file), -1, 
  /* DiagArray459 */ $uint2short(diag.pp_pragma_sysheader_in_main_file), -1, 
  /* DiagArray460 */ $uint2short(diag.warn_redefine_extname_not_applied), -1, 
  /* DiagArray461 */ $uint2short(diag.ext_predef_outside_function), -1, 
  /* DiagArray462 */ $uint2short(diag.warn_private_extern), -1, 
  /* DiagArray463 */ $uint2short(diag.warn_use_of_private_header_outside_module), -1, 
  /* DiagArray464 */ $uint2short(diag.warn_profile_data_out_of_date), -1, 
  /* DiagArray465 */ $uint2short(diag.warn_profile_data_unprofiled), -1, 
  /* DiagArray466 */ $uint2short(diag.warn_property_access_suggest), -1, 
  /* DiagArray467 */ $uint2short(diag.warn_property_attr_mismatch), $uint2short(diag.warn_property_attribute), $uint2short(diag.warn_property_redecl_getter_mismatch), $uint2short(diag.warn_readonly_property), -1, 
  /* DiagArray468 */ $uint2short(diag.warn_unimplemented_protocol_method), -1, 
  /* DiagArray469 */ $uint2short(diag.warn_protocol_property_mismatch), -1, 
  /* DiagArray470 */ $uint2short(diag.err_func_returning_qualified_void), -1, 
  /* DiagArray471 */ $uint2short(diag.warn_for_range_const_reference_copy), $uint2short(diag.warn_for_range_copy), $uint2short(diag.warn_for_range_variable_always_copy), -1, 
  /* DiagArray472 */ $uint2short(diag.warn_auto_readonly_iboutlet_property), -1, 
  /* DiagArray473 */ $uint2short(diag.warn_bad_receiver_type), -1, 
  /* DiagArray474 */ $uint2short(diag.warn_receiver_forward_class), $uint2short(diag.warn_receiver_forward_instance), -1, 
  /* DiagArray475 */ $uint2short(diag.ext_member_redeclared), -1, 
  /* DiagArray477 */ $uint2short(diag.warn_redundant_move_on_return), -1, 
  /* DiagArray478 */ $uint2short(diag.ext_register_storage_class), -1, 
  /* DiagArray479 */ $uint2short(diag.warn_reinterpret_different_from_static), -1, 
  /* DiagArray480 */ $uint2short(diag.remark_fe_backend_plugin), -1, 
  /* DiagArray481 */ $uint2short(diag.warn_initializer_out_of_order), -1, 
  /* DiagArray482 */ $uint2short(diag.warn_objc_requires_super_protocol), -1, 
  /* DiagArray483 */ $uint2short(diag.warn_pp_macro_is_reserved_id), -1, 
  /* DiagArray484 */ $uint2short(diag.ext_ms_reserved_user_defined_literal), $uint2short(diag.ext_reserved_user_defined_literal), -1, 
  /* DiagArray485 */ $uint2short(diag.ext_retained_language_linkage), -1, 
  /* DiagArray486 */ $uint2short(diag.warn_ret_addr_label), $uint2short(diag.warn_ret_local_temp_addr_ref), $uint2short(diag.warn_ret_stack_addr_ref), -1, 
  /* DiagArray487 */ $uint2short(diag.ext_return_has_expr), $uint2short(diag.ext_return_missing_expr), $uint2short(diag.warn_falloff_nonvoid_function), $uint2short(diag.warn_falloff_nonvoid_lambda), $uint2short(diag.warn_maybe_falloff_nonvoid_function), $uint2short(diag.warn_maybe_falloff_nonvoid_lambda), $uint2short(diag.warn_return_missing_expr), -1, 
  /* DiagArray488 */ $uint2short(diag.warn_return_value_udt), $uint2short(diag.warn_return_value_udt_incomplete), -1, 
  /* DiagArray489 */ $uint2short(diag.warn_drv_enabling_rtti_with_exceptions), -1, 
  /* DiagArray490 */ $uint2short(diag.remark_sanitize_address_insert_extra_padding_accepted), $uint2short(diag.remark_sanitize_address_insert_extra_padding_rejected), -1, 
  /* DiagArray491 */ $uint2short(diag.warn_mismatched_section), -1, 
  /* DiagArray492 */ $uint2short(diag.warn_unimplemented_selector), -1, 
  /* DiagArray493 */ $uint2short(diag.warning_multiple_selectors), -1, 
  /* DiagArray494 */ $uint2short(diag.warn_self_assignment), -1, 
  /* DiagArray495 */ $uint2short(diag.warn_identity_field_assign), -1, 
  /* DiagArray496 */ $uint2short(diag.warn_self_move), -1, 
  /* DiagArray497 */ $uint2short(diag.warn_semicolon_before_method_body), -1, 
  /* DiagArray498 */ $uint2short(diag.warn_missing_sentinel), $uint2short(diag.warn_not_enough_argument), -1, 
  /* DiagArray500 */ $uint2short(diag.warn_fe_serialized_diag_failure), $uint2short(diag.warn_fe_serialized_diag_merge_failure), -1, 
  /* DiagArray501 */ $uint2short(diag.warn_decl_shadow), -1, 
  /* DiagArray503 */ $uint2short(diag.warn_ctor_parm_shadows_field), -1, 
  /* DiagArray504 */ $uint2short(diag.warn_modifying_shadowing_decl), -1, 
  /* DiagArray505 */ $uint2short(diag.warn_ivar_use_hidden), -1, 
  /* DiagArray506 */ $uint2short(diag.warn_shift_negative), -1, 
  /* DiagArray507 */ $uint2short(diag.warn_shift_gt_typewidth), -1, 
  /* DiagArray508 */ $uint2short(diag.warn_shift_lhs_negative), -1, 
  /* DiagArray509 */ $uint2short(diag.warn_addition_in_bitshift), -1, 
  /* DiagArray510 */ $uint2short(diag.warn_shift_result_gt_typewidth), -1, 
  /* DiagArray511 */ $uint2short(diag.warn_shift_result_sets_sign_bit), -1, 
  /* DiagArray512 */ $uint2short(diag.warn_impcast_integer_64_32), -1, 
  /* DiagArray513 */ $uint2short(diag.warn_mixed_sign_comparison), -1, 
  /* DiagArray514 */ $uint2short(diag.warn_impcast_integer_sign), $uint2short(diag.warn_impcast_integer_sign_conditional), -1, 
  /* DiagArray516 */ $uint2short(diag.warn_sizeof_array_param), -1, 
  /* DiagArray517 */ $uint2short(diag.warn_sizeof_array_decay), -1, 
  /* DiagArray518 */ $uint2short(diag.warn_sizeof_pointer_expr_memaccess), $uint2short(diag.warn_sizeof_pointer_type_memaccess), -1, 
  /* DiagArray519 */ $uint2short(diag.warn_sometimes_uninit_var), -1, 
  /* DiagArray520 */ $uint2short(diag.warn_omp_nesting_simd), $uint2short(diag.warn_pragma_omp_ignored), -1, 
  /* DiagArray522 */ $uint2short(diag.ext_in_class_initializer_float_type_cxx11), -1, 
  /* DiagArray523 */ $uint2short(diag.ext_internal_in_extern_inline), $uint2short(diag.ext_internal_in_extern_inline_quiet), -1, 
  /* DiagArray524 */ $uint2short(diag.warn_static_inline_explicit_inst_ignored), -1, 
  /* DiagArray525 */ $uint2short(diag.warn_static_local_in_extern_inline), -1, 
  /* DiagArray526 */ $uint2short(diag.warn_static_self_reference_in_init), -1, 
  /* DiagArray539 */ $uint2short(diag.warn_strict_multiple_method_decl), -1, 
  /* DiagArray540 */ $uint2short(diag.warn_stringcompare), -1, 
  /* DiagArray541 */ $uint2short(diag.warn_impcast_string_literal_to_bool), -1, 
  /* DiagArray542 */ $uint2short(diag.warn_string_plus_char), -1, 
  /* DiagArray543 */ $uint2short(diag.warn_string_plus_int), -1, 
  /* DiagArray544 */ $uint2short(diag.warn_strlcpycat_wrong_size), -1, 
  /* DiagArray545 */ $uint2short(diag.warn_strncat_large_size), $uint2short(diag.warn_strncat_src_size), $uint2short(diag.warn_strncat_wrong_size), -1, 
  /* DiagArray546 */ $uint2short(diag.ext_typecheck_base_super), -1, 
  /* DiagArray547 */ $uint2short(diag.warn_case_value_overflow), $uint2short(diag.warn_missing_case), $uint2short(diag.warn_not_in_enum), -1, 
  /* DiagArray548 */ $uint2short(diag.warn_bool_switch_condition), -1, 
  /* DiagArray550 */ $uint2short(diag.warn_def_missing_case), -1, 
  /* DiagArray551 */ $uint2short(diag.warn_sync_fetch_and_nand_semantics_change), -1, 
  /* DiagArray553 */ $uint2short(diag.warn_comparison_always), $uint2short(diag.warn_comparison_bitwise_always), $uint2short(diag.warn_lunsigned_always_true_comparison), $uint2short(diag.warn_runsigned_always_true_comparison), -1, 
  /* DiagArray554 */ $uint2short(diag.warn_out_of_range_compare), -1, 
  /* DiagArray555 */ $uint2short(diag.warn_tautological_overlap_comparison), -1, 
  /* DiagArray556 */ $uint2short(diag.warn_nonnull_expr_compare), $uint2short(diag.warn_null_pointer_compare), -1, 
  /* DiagArray557 */ $uint2short(diag.warn_address_of_reference_null_compare), $uint2short(diag.warn_this_null_compare), -1, 
  /* DiagArray558 */ $uint2short(diag.ext_typecheck_decl_incomplete_type), -1, 
  /* DiagArray560 */ $uint2short(diag.warn_acquired_before), $uint2short(diag.warn_acquired_before_after_cycle), $uint2short(diag.warn_cannot_resolve_lock), $uint2short(diag.warn_double_lock), $uint2short(diag.warn_expecting_lock_held_on_loop), $uint2short(diag.warn_expecting_locked), $uint2short(diag.warn_fun_excludes_mutex), $uint2short(diag.warn_fun_requires_lock), $uint2short(diag.warn_lock_exclusive_and_shared), $uint2short(diag.warn_lock_some_predecessors), $uint2short(diag.warn_no_unlock), $uint2short(diag.warn_unlock_but_no_lock), $uint2short(diag.warn_unlock_kind_mismatch), $uint2short(diag.warn_var_deref_requires_any_lock), $uint2short(diag.warn_var_deref_requires_lock), $uint2short(diag.warn_variable_requires_any_lock), $uint2short(diag.warn_variable_requires_lock), -1, 
  /* DiagArray561 */ $uint2short(diag.warn_invalid_capability_name), $uint2short(diag.warn_thread_attribute_argument_not_lockable), $uint2short(diag.warn_thread_attribute_decl_not_lockable), $uint2short(diag.warn_thread_attribute_decl_not_pointer), $uint2short(diag.warn_thread_attribute_ignored), -1, 
  /* DiagArray562 */ $uint2short(diag.warn_thread_safety_beta), -1, 
  /* DiagArray563 */ $uint2short(diag.warn_acquire_requires_negative_cap), -1, 
  /* DiagArray564 */ $uint2short(diag.warn_fun_requires_lock_precise), $uint2short(diag.warn_var_deref_requires_lock_precise), $uint2short(diag.warn_variable_requires_lock_precise), -1, 
  /* DiagArray565 */ $uint2short(diag.warn_guarded_pass_by_reference), $uint2short(diag.warn_pt_guarded_pass_by_reference), -1, 
  /* DiagArray566 */ $uint2short(diag.warn_thread_safety_verbose), -1, 
  /* DiagArray567 */ $uint2short(diag.trigraph_converted), $uint2short(diag.trigraph_ends_block_comment), $uint2short(diag.trigraph_ignored), $uint2short(diag.trigraph_ignored_block_comment), -1, 
  /* DiagArray569 */ $uint2short(diag.warn_type_safety_null_pointer_required), $uint2short(diag.warn_type_safety_type_mismatch), $uint2short(diag.warn_type_tag_for_datatype_wrong_kind), -1, 
  /* DiagArray570 */ $uint2short(diag.ext_redefinition_of_typedef), -1, 
  /* DiagArray571 */ $uint2short(diag.ext_typename_missing), -1, 
  /* DiagArray572 */ $uint2short(diag.warn_unavailable_fwdclass_message), -1, 
  /* DiagArray573 */ $uint2short(diag.warn_undeclared_selector), $uint2short(diag.warn_undeclared_selector_with_typo), -1, 
  /* DiagArray574 */ $uint2short(diag.warn_pp_undef_identifier), -1, 
  /* DiagArray575 */ $uint2short(diag.warn_address_of_reference_bool_conversion), $uint2short(diag.warn_this_bool_conversion), -1, 
  /* DiagArray576 */ $uint2short(diag.warn_func_template_missing), -1, 
  /* DiagArray577 */ $uint2short(diag.warn_undefined_inline), -1, 
  /* DiagArray578 */ $uint2short(diag.warn_undefined_internal), -1, 
  /* DiagArray579 */ $uint2short(diag.warn_pointer_indirection_from_incompatible_type), $uint2short(diag.warn_undefined_reinterpret_cast), -1, 
  /* DiagArray580 */ $uint2short(diag.warn_var_template_missing), -1, 
  /* DiagArray581 */ $uint2short(diag.warn_side_effects_unevaluated_context), -1, 
  /* DiagArray582 */ $uint2short(diag.warn_available_using_star_case), -1, 
  /* DiagArray583 */ $uint2short(diag.warn_ucn_escape_incomplete), $uint2short(diag.warn_ucn_escape_no_digits), $uint2short(diag.warn_ucn_escape_surrogate), $uint2short(diag.warn_ucn_not_valid_in_c89), $uint2short(diag.warn_ucn_not_valid_in_c89_literal), -1, 
  /* DiagArray584 */ $uint2short(diag.ext_unicode_whitespace), -1, 
  /* DiagArray585 */ $uint2short(diag.warn_base_class_is_uninit), $uint2short(diag.warn_field_is_uninit), $uint2short(diag.warn_reference_field_is_uninit), $uint2short(diag.warn_uninit_byref_blockvar_captured_by_block), $uint2short(diag.warn_uninit_self_reference_in_init), $uint2short(diag.warn_uninit_self_reference_in_reference_init), $uint2short(diag.warn_uninit_var), -1, 
  /* DiagArray586 */ $uint2short(diag.warn_drv_unknown_argument_clang_cl), -1, 
  /* DiagArray587 */ $uint2short(diag.warn_unknown_attribute_ignored), -1, 
  /* DiagArray588 */ $uint2short(diag.ext_unknown_escape), -1, 
  /* DiagArray589 */ $uint2short(diag.ext_on_off_switch_syntax), $uint2short(diag.ext_pragma_syntax_eod), $uint2short(diag.ext_stdc_pragma_ignored), $uint2short(diag.warn_pragma_diagnostic_cannot_pop), $uint2short(diag.warn_pragma_diagnostic_invalid), $uint2short(diag.warn_pragma_diagnostic_invalid_option), $uint2short(diag.warn_pragma_diagnostic_invalid_token), $uint2short(diag.warn_pragma_diagnostic_unknown_warning), $uint2short(diag.warn_pragma_ignored), $uint2short(diag.warn_pragma_include_alias_expected), $uint2short(diag.warn_pragma_include_alias_expected_filename), $uint2short(diag.warn_pragma_include_alias_mismatch_angle), $uint2short(diag.warn_pragma_include_alias_mismatch_quote), $uint2short(diag.warn_pragma_warning_expected), $uint2short(diag.warn_pragma_warning_expected_number), $uint2short(diag.warn_pragma_warning_push_level), $uint2short(diag.warn_pragma_warning_spec_invalid), $uint2short(diag.warn_stdc_fenv_access_not_supported), -1, 
  /* DiagArray590 */ $uint2short(diag.warn_unknown_sanitizer_ignored), -1, 
  /* DiagArray591 */ $uint2short(diag.warn_unknown_diag_option), $uint2short(diag.warn_unknown_warning_specifier), -1, 
  /* DiagArray592 */ $uint2short(diag.ext_template_arg_unnamed_type), -1, 
  /* DiagArray593 */ $uint2short(diag.warn_unneeded_internal_decl), $uint2short(diag.warn_unneeded_static_internal_decl), -1, 
  /* DiagArray594 */ $uint2short(diag.warn_unneeded_member_function), -1, 
  /* DiagArray595 */ $uint2short(diag.warn_unreachable), -1, 
  /* DiagArray597 */ $uint2short(diag.warn_unreachable_break), -1, 
  /* DiagArray598 */ $uint2short(diag.warn_unreachable_loop_increment), -1, 
  /* DiagArray599 */ $uint2short(diag.warn_unreachable_return), -1, 
  /* DiagArray600 */ $uint2short(diag.warn_unsequenced_mod_mod), $uint2short(diag.warn_unsequenced_mod_use), -1, 
  /* DiagArray601 */ $uint2short(diag.warn_target_unsupported_compact_branches), -1, 
  /* DiagArray602 */ $uint2short(diag.warn_attribute_dll_instantiated_base_class), -1, 
  /* DiagArray603 */ $uint2short(diag.warn_template_qualified_friend_ignored), $uint2short(diag.warn_template_qualified_friend_unsupported), -1, 
  /* DiagArray604 */ $uint2short(diag.warn_target_unsupported_nan2008), $uint2short(diag.warn_target_unsupported_nanlegacy), -1, 
  /* DiagArray605 */ $uint2short(diag.warn_attribute_protected_visibility), -1, 
  /* DiagArray608 */ $uint2short(diag.warn_drv_empty_joined_argument), $uint2short(diag.warn_drv_input_file_unused), $uint2short(diag.warn_drv_input_file_unused_by_cpp), $uint2short(diag.warn_drv_preprocessed_input_file_unused), $uint2short(diag.warn_drv_unused_argument), -1, 
  /* DiagArray609 */ $uint2short(diag.warn_unused_comparison), -1, 
  /* DiagArray610 */ $uint2short(diag.warn_unused_const_variable), -1, 
  /* DiagArray611 */ $uint2short(diag.warn_unused_exception_param), -1, 
  /* DiagArray612 */ $uint2short(diag.warn_unused_function), -1, 
  /* DiagArray613 */ $uint2short(diag.warn_unused_property_expr), -1, 
  /* DiagArray614 */ $uint2short(diag.warn_unused_label), -1, 
  /* DiagArray615 */ $uint2short(diag.warn_unused_local_typedef), -1, 
  /* DiagArray617 */ $uint2short(diag.pp_macro_not_used), -1, 
  /* DiagArray618 */ $uint2short(diag.warn_unused_member_function), -1, 
  /* DiagArray619 */ $uint2short(diag.warn_unused_parameter), -1, 
  /* DiagArray620 */ $uint2short(diag.warn_unused_private_field), -1, 
  /* DiagArray621 */ $uint2short(diag.warn_unused_property_backing_ivar), -1, 
  /* DiagArray622 */ $uint2short(diag.warn_unused_result), -1, 
  /* DiagArray623 */ $uint2short(diag.warn_unused_call), $uint2short(diag.warn_unused_container_subscript_expr), $uint2short(diag.warn_unused_expr), $uint2short(diag.warn_unused_voidptr), -1, 
  /* DiagArray624 */ $uint2short(diag.warn_unused_variable), -1, 
  /* DiagArray625 */ $uint2short(diag.warn_unused_volatile), -1, 
  /* DiagArray626 */ $uint2short(diag.warn_used_but_marked_unused), -1, 
  /* DiagArray627 */ $uint2short(diag.warn_user_literal_reserved), -1, 
  /* DiagArray628 */ $uint2short(diag.warn_second_arg_of_va_start_not_last_named_param), $uint2short(diag.warn_second_parameter_to_va_arg_never_compatible), $uint2short(diag.warn_va_start_type_is_undefined), -1, 
  /* DiagArray629 */ $uint2short(diag.ext_named_variadic_macro), $uint2short(diag.ext_variadic_macro), -1, 
  /* DiagArray630 */ $uint2short(diag.warn_incompatible_vectors), -1, 
  /* DiagArray632 */ $uint2short(diag.warn_empty_parens_are_function_decl), $uint2short(diag.warn_parens_disambiguated_as_function_declaration), -1, 
  /* DiagArray633 */ $uint2short(diag.warn_decl_in_param_list), $uint2short(diag.warn_redefinition_in_param_list), -1, 
  /* DiagArray634 */ $uint2short(diag.warn_vla_used), -1, 
  /* DiagArray635 */ $uint2short(diag.ext_vla), -1, 
  /* DiagArray636 */ $uint2short(diag.ext_typecheck_indirection_through_void_pointer), -1, 
  /* DiagArray638 */ $uint2short(diag.warn_weak_template_vtable), -1, 
  /* DiagArray639 */ $uint2short(diag.warn_weak_vtable), -1, 
  /* DiagArray640 */ $uint2short(diag.ext_deprecated_string_literal_conversion), -1, 
  /* DiagArray642 */ $uint2short(diag.ext_typecheck_zero_array_size), -1
};
//<editor-fold defaultstate="collapsed" desc="DiagSubGroups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/DiagnosticGroups.inc", line = 565,
 old_source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/DiagnosticGroups.inc", old_line = 547,
 FQN="DiagSubGroups", NM="_ZL13DiagSubGroups",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL13DiagSubGroups")
//</editor-fold>
public static /*const*/short/*int16_t*/ DiagSubGroups[/*409*/] = new /*const*/short/*int16_t*/ [/*409*/] {
  /* Empty */ -1, 
  /* DiagSubGroup0 */ 180, -1, 
  /* DiagSubGroup4 */ 15, 180, -1, 
  /* DiagSubGroup11 */ 453, 540, 556, -1, 
  /* DiagSubGroup15 */ 364, 441, 547, 548, -1, 
  /* DiagSubGroup21 */ 28, 27, 24, -1, 
  /* DiagSubGroup26 */ 23, -1, 
  /* DiagSubGroup31 */ 32, -1, 
  /* DiagSubGroup37 */ 243, 120, -1, 
  /* DiagSubGroup40 */ 587, 238, -1, 
  /* DiagSubGroup50 */ 86, -1, 
  /* DiagSubGroup54 */ 453, 575, -1, 
  /* DiagSubGroup55 */ 54, -1, 
  /* DiagSubGroup62 */ 65, -1, 
  /* DiagSubGroup63 */ 69, -1, 
  /* DiagSubGroup64 */ 73, -1, 
  /* DiagSubGroup65 */ 73, 68, 66, 83, 81, -1, 
  /* DiagSubGroup67 */ 84, 82, -1, 
  /* DiagSubGroup69 */ 70, 71, 72, -1, 
  /* DiagSubGroup75 */ 81, -1, 
  /* DiagSubGroup76 */ 82, -1, 
  /* DiagSubGroup77 */ 74, -1, 
  /* DiagSubGroup78 */ 77, -1, 
  /* DiagSubGroup79 */ 139, 135, -1, 
  /* DiagSubGroup82 */ 81, -1, 
  /* DiagSubGroup84 */ 83, -1, 
  /* DiagSubGroup85 */ 87, 89, 83, 81, -1, 
  /* DiagSubGroup88 */ 85, 86, 84, 82, -1, 
  /* DiagSubGroup100 */ 378, -1, 
  /* DiagSubGroup103 */ 102, -1, 
  /* DiagSubGroup109 */ 51, -1, 
  /* DiagSubGroup113 */ 54, 109, 170, 187, 512, 275, 298, 375, 387, 401, 514, 541, -1, 
  /* DiagSubGroup114 */ 387, -1, 
  /* DiagSubGroup131 */ 132, 133, 135, 139, 140, -1, 
  /* DiagSubGroup137 */ 138, -1, 
  /* DiagSubGroup140 */ 66, -1, 
  /* DiagSubGroup151 */ 153, 152, -1, 
  /* DiagSubGroup154 */ 155, -1, 
  /* DiagSubGroup168 */ 183, -1, 
  /* DiagSubGroup180 */ 347, 241, 271, 497, 350, 513, 619, -1, 
  /* DiagSubGroup182 */ 70, -1, 
  /* DiagSubGroup187 */ 189, 190, -1, 
  /* DiagSubGroup192 */ 193, 200, 380, 198, 199, 194, -1, 
  /* DiagSubGroup201 */ 196, 198, 199, -1, 
  /* DiagSubGroup208 */ 209, 210, 212, 213, 214, 215, 216, 217, 218, 219, 220, 635, 221, 222, 223, 224, 225, 226, 475, 227, 228, 229, 230, 231, 232, 642, 233, 234, -1, 
  /* DiagSubGroup242 */ 248, 249, -1, 
  /* DiagSubGroup246 */ 247, -1, 
  /* DiagSubGroup259 */ 260, -1, 
  /* DiagSubGroup264 */ 265, 377, -1, 
  /* DiagSubGroup268 */ 135, -1, 
  /* DiagSubGroup276 */ 275, -1, 
  /* DiagSubGroup277 */ 278, -1, 
  /* DiagSubGroup280 */ 239, -1, 
  /* DiagSubGroup300 */ 87, -1, 
  /* DiagSubGroup303 */ 72, -1, 
  /* DiagSubGroup304 */ 191, 471, -1, 
  /* DiagSubGroup312 */ 315, 330, 318, 327, 334, 337, 323, 338, 331, 332, 336, 325, 322, 319, 335, 333, 321, 329, 328, 326, 314, 317, 339, 313, 316, 320, 266, -1, 
  /* DiagSubGroup364 */ 98, 102, 130, 191, 192, 242, 269, 343, 344, 365, 367, 481, 487, 494, 496, 516, 517, 543, 567, 585, 589, 606, 637, 405, 397, 435, 462, 95, 178, -1, 
  /* DiagSubGroup365 */ 451, 477, 496, -1, 
  /* DiagSubGroup366 */ 330, -1, 
  /* DiagSubGroup369 */ 73, -1, 
  /* DiagSubGroup374 */ 513, 113, 299, -1, 
  /* DiagSubGroup377 */ 376, -1, 
  /* DiagSubGroup396 */ 418, -1, 
  /* DiagSubGroup400 */ 421, -1, 
  /* DiagSubGroup418 */ 419, -1, 
  /* DiagSubGroup441 */ 302, 301, 53, 509, 434, 442, 121, -1, 
  /* DiagSubGroup449 */ 90, 70, 72, 74, 186, 197, 202, 210, 212, 213, 214, 215, 216, 217, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 231, 233, 234, 293, 303, 315, 316, 318, 320, 321, 327, 328, 333, 433, 635, 629, 642, 485, 105, 177, 370, 127, 156, 295, 253, 164, 166, 392, -1, 
  /* DiagSubGroup460 */ 589, 240, -1, 
  /* DiagSubGroup478 */ 139, -1, 
  /* DiagSubGroup484 */ 68, -1, 
  /* DiagSubGroup487 */ 488, -1, 
  /* DiagSubGroup492 */ 493, -1, 
  /* DiagSubGroup494 */ 495, -1, 
  /* DiagSubGroup499 */ 600, -1, 
  /* DiagSubGroup501 */ 504, -1, 
  /* DiagSubGroup502 */ 501, 503, -1, 
  /* DiagSubGroup503 */ 504, -1, 
  /* DiagSubGroup522 */ 229, -1, 
  /* DiagSubGroup553 */ 554, 556, 555, 557, -1, 
  /* DiagSubGroup559 */ 561, 560, 564, 565, -1, 
  /* DiagSubGroup581 */ 457, -1, 
  /* DiagSubGroup585 */ 519, 526, -1, 
  /* DiagSubGroup592 */ 89, -1, 
  /* DiagSubGroup595 */ 598, -1, 
  /* DiagSubGroup596 */ 595, 597, 599, -1, 
  /* DiagSubGroup606 */ 607, 612, 614, 620, 615, 623, 624, 621, -1, 
  /* DiagSubGroup612 */ 593, -1, 
  /* DiagSubGroup616 */ 615, -1, 
  /* DiagSubGroup618 */ 594, -1, 
  /* DiagSubGroup623 */ 609, 622, 581, -1, 
  /* DiagSubGroup624 */ 610, -1, 
  /* DiagSubGroup631 */ 630, -1, 
  /* DiagSubGroup640 */ 140, -1, 
  /* DiagSubGroup641 */ 640, -1
};
//<editor-fold defaultstate="collapsed" desc="DiagGroupNames">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/DiagnosticGroups.inc", line = 663,
 old_source = "${LLVM_SRC}/build/tools/clang/include/clang/Basic/DiagnosticGroups.inc", old_line = 641,
 FQN="DiagGroupNames", NM="_ZL14DiagGroupNames",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZL14DiagGroupNames")
//</editor-fold>
public static /*const*//*char*/byte DiagGroupNames[/*13069*/];
static {
  // NOTE: go to DiagnosticGroups.inc, copy paste full string section and add leading '+' using rect-selection
  // if needed \a replaced by \007 \b replaced by \010
  /*char*/byte[] value;
  try {
    value = (
      "\000\020#pragma-messages\t#warnings\020CFString-literal\003CL4\032Indep"
    + "endentClass-attribute\022NSObject-attribute\003abi\016absolute-value\024"
    + "abstract-final-class\023abstract-vbase-init\007address\032address-of-ar"
    + "ray-temporary\024address-of-temporary\020aggregate-return\003all\022amb"
    + "iguous-ellipsis\017ambiguous-macro\031ambiguous-member-template\034anal"
    + "yzer-incompatible-plugin\025anonymous-pack-parens\003arc%arc-bridge-cas"
    + "ts-disallowed-in-nonarc\036arc-maybe-repeated-use-of-weak\025arc-non-po"
    + "d-memaccess\031arc-performSelector-leaks\030arc-repeated-use-of-weak\021"
    + "arc-retain-cycles\032arc-unsafe-retained-assign\014array-bounds\037arra"
    + "y-bounds-pointer-arithmetic\003asm\022asm-operand-widths\013assign-enum"
    + "\006assume\013at-protocol\026atomic-memory-ordering\021atomic-propertie"
    + "s*atomic-property-with-user-defined-accessor\035attribute-packed-for-bi"
    + "tfield\nattributes\033auto-disable-vptr-sanitizer\013auto-import\022aut"
    + "o-storage-class\013auto-var-id\014availability\016backend-plugin\030bac"
    + "kslash-newline-escape\024bad-array-new-length\021bad-function-cast\026b"
    + "ind-to-temporary-copy\034bitfield-constant-conversion\016bitfield-width"
    + "\026bitwise-op-parentheses\017bool-conversion\020bool-conversions\022br"
    + "aced-scalar-init\013bridge-cast\027builtin-macro-redefined\027builtin-m"
    + "emcpy-chk-size\027builtin-requires-header\nc++-compat\014c++0x-compat\020"
    + "c++0x-extensions\017c++0x-narrowing\014c++11-compat(c++11-compat-deprec"
    + "ated-writable-strings\025c++11-compat-pedantic*c++11-compat-reserved-us"
    + "er-defined-literal\020c++11-extensions\020c++11-extra-semi\026c++11-inl"
    + "ine-namespace\017c++11-long-long\017c++11-narrowing\024c++14-binary-lit"
    + "eral\014c++14-compat\025c++14-compat-pedantic\020c++14-extensions\020c+"
    + "+1y-extensions\014c++1z-compat\020c++1z-extensions\030c++98-c++11-c++14"
    + "-compat!c++98-c++11-c++14-compat-pedantic\022c++98-c++11-compat\033c++9"
    + "8-c++11-compat-pedantic\014c++98-compat#c++98-compat-bind-to-temporary-"
    + "copy%c++98-compat-local-type-template-args\025c++98-compat-pedantic'c++"
    + "98-compat-unnamed-type-template-args\016c11-extensions\nc99-compat\016c"
    + "99-extensions\ncast-align\027cast-calling-convention\020cast-of-sel-typ"
    + "e\tcast-qual\nchar-align\017char-subscripts\014clang-cl-pch\015class-va"
    + "rargs\005comma\007comment\010comments\036compare-distinct-pointer-types"
    + "\026complex-component-init\031conditional-type-mismatch\031conditional-"
    + "uninitialized\015config-macros\023constant-conversion\030constant-logic"
    + "al-operand\023constexpr-not-const\010consumed\nconversion\017conversion"
    + "-null\030coreturn-without-coawait\026covered-switch-default\030cstring-"
    + "format-directive\021ctor-dtor-privacy\013cuda-compat\030custom-atomic-p"
    + "roperties\015dangling-else\016dangling-field\031dangling-initializer-li"
    + "st\tdate-time\023dealloc-in-category\035debug-compression-unavailable\033"
    + "declaration-after-statement\026delegating-ctor-cycles\021delete-incompl"
    + "ete\027delete-non-virtual-dtor\ndeprecated\025deprecated-attributes\027"
    + "deprecated-declarations\032deprecated-implementations\031deprecated-inc"
    + "rement-bool\031deprecated-objc-isa-usage%deprecated-objc-pointer-intros"
    + "pection5deprecated-objc-pointer-introspection-performSelector\023deprec"
    + "ated-register\033deprecated-writable-strings\022direct-ivar-access\030d"
    + "isabled-macro-expansion\025disabled-optimization\014discard-qual\034dis"
    + "tributed-object-modifiers\013div-by-zero\020division-by-zero\036dll-att"
    + "ribute-on-redeclaration%dllexport-explicit-instantiation-decl\032dllimp"
    + "ort-static-field-def\015documentation\035documentation-deprecated-sync\022"
    + "documentation-html\026documentation-pedantic\035documentation-unknown-c"
    + "ommand\036dollar-in-identifier-extension\020double-promotion\030duplica"
    + "te-decl-specifier\016duplicate-enum\024duplicate-method-arg\026duplicat"
    + "e-method-match\027dynamic-class-memaccess\006effc++\022embedded-directi"
    + "ve\nempty-body\026empty-translation-unit\013encode-type\014endif-labels"
    + "\014enum-compare\017enum-conversion\016enum-too-large\nexceptions\025ex"
    + "it-time-destructors\024expansion-to-defined\030explicit-initialize-call"
    + "\027explicit-ownership-type\021extended-offsetof\017extern-c-compat\022"
    + "extern-initializer\005extra\023extra-qualification\nextra-semi\014extra"
    + "-tokens\010fallback\tflag-enum\031flexible-array-extensions\020float-co"
    + "nversion\013float-equal\031float-overflow-conversion\025float-zero-conv"
    + "ersion\021for-loop-analysis\006format\021format-extra-args\030format-in"
    + "valid-specifier\016format-non-iso\021format-nonliteral\017format-pedant"
    + "ic\017format-security\nformat-y2k\022format-zero-length\010format=2\023"
    + "four-char-constants\022frame-larger-than=\036function-def-in-objc-conta"
    + "iner\015future-compat\ngcc-compat\023global-constructors\003gnu\026gnu-"
    + "alignof-expression\024gnu-anonymous-struct\033gnu-array-member-paren-in"
    + "it\015gnu-auto-type\022gnu-binary-literal\016gnu-case-range\023gnu-comp"
    + "lex-integer gnu-compound-literal-initializer\037gnu-conditional-omitted"
    + "-operand\016gnu-designator\025gnu-empty-initializer\020gnu-empty-struct"
    + "\036gnu-flexible-array-initializer\037gnu-flexible-array-union-member\024"
    + "gnu-folding-constant\026gnu-imaginary-constant\020gnu-include-next\022g"
    + "nu-label-as-value\023gnu-redeclared-enum\030gnu-statement-expression\025"
    + "gnu-static-float-init$gnu-string-literal-operator-template\016gnu-union"
    + "-cast\"gnu-variable-sized-type-not-at-end\027gnu-zero-line-directive!gn"
    + "u-zero-variadic-macro-arguments\014header-guard\016header-hygiene\025id"
    + "iomatic-parentheses\022ignored-attributes\035ignored-optimization-argum"
    + "ent\017ignored-pragmas\022ignored-qualifiers\010implicit\032implicit-at"
    + "omic-properties*implicit-conversion-floating-point-to-bool implicit-exc"
    + "eption-spec-mismatch\024implicit-fallthrough!implicit-fallthrough-per-f"
    + "unction\035implicit-function-declaration\014implicit-int\024implicit-re"
    + "tain-self\033implicitly-unsigned-literal\006import&import-preprocessor-"
    + "directive-pedantic\021inaccessible-base\032include-next-absolute-path\033"
    + "include-next-outside-header\"incompatible-library-redeclaration\026inco"
    + "mpatible-ms-struct\032incompatible-pointer-types.incompatible-pointer-t"
    + "ypes-discards-qualifiers\032incompatible-property-type\024incompatible-"
    + "sysroot\031incomplete-implementation\021incomplete-module\023incomplete"
    + "-umbrella\026inconsistent-dllimport\035inconsistent-missing-override\016"
    + "increment-bool\022infinite-recursion\tinit-self\025initializer-override"
    + "s\006inline\ninline-asm\021inline-new-delete\016int-conversion\017int-c"
    + "onversions\023int-to-pointer-cast\030int-to-void-pointer-cast\020intege"
    + "r-overflow\035invalid-command-line-argument\021invalid-constexpr\020inv"
    + "alid-iboutlet&invalid-initializer-from-system-header\020invalid-noretur"
    + "n\020invalid-offsetof invalid-or-nonexistent-directory\013invalid-pch\020"
    + "invalid-pp-token\027invalid-source-encoding\023invalid-token-paste\020j"
    + "ump-seh-finally\016keyword-compat\015keyword-macro\026knr-promoted-para"
    + "meter\030language-extension-token\023large-by-value-copy\006liblto\022l"
    + "iteral-conversion\015literal-range\030local-type-template-args\027logic"
    + "al-not-parentheses\026logical-op-parentheses\tlong-long\015loop-analysi"
    + "s\017macro-redefined\004main\020main-return-type\027malformed-warning-c"
    + "heck\036many-braces-around-scalar-init\022memsize-comparison\021method-"
    + "signatures\tmicrosoft\022microsoft-anon-tag\016microsoft-cast\021micros"
    + "oft-charize\027microsoft-comment-paste\024microsoft-const-init\023micro"
    + "soft-cpp-macro\"microsoft-default-arg-redefinition\025microsoft-end-of-"
    + "file microsoft-enum-forward-reference\024microsoft-enum-value\030micros"
    + "oft-exception-spec\020microsoft-exists#microsoft-explicit-constructor-c"
    + "all\035microsoft-extra-qualification\024microsoft-fixed-enum\030microso"
    + "ft-flexible-array\016microsoft-goto\021microsoft-include\033microsoft-m"
    + "utable-reference\031microsoft-pure-definition\032microsoft-redeclare-st"
    + "atic\020microsoft-sealed\022microsoft-template microsoft-union-member-r"
    + "eference\034microsoft-unqualified-friend\024microsoft-using-decl\032mic"
    + "rosoft-void-pseudo-dtor\025mismatched-new-delete\032mismatched-paramete"
    + "r-types\027mismatched-return-types\017mismatched-tags\016missing-braces"
    + "\024missing-declarations\026missing-exception-spec\032missing-field-ini"
    + "tializers\030missing-format-attribute\024missing-include-dirs\032missin"
    + "g-method-return-type\020missing-noreturn\030missing-prototype-for-cc\022"
    + "missing-prototypes\025missing-selector-name\017missing-sysroot\035missi"
    + "ng-variable-declarations\014module-build\017module-conflict\033module-f"
    + "ile-config-mismatch\025module-file-extension\031module-import-in-extern"
    + "-c\"modules-ambiguous-internal-linkage\037modules-import-nested-redunda"
    + "nt\004most\004move\014msvc-include\tmultichar\023multiple-move-vbase\tn"
    + "arrowing\021nested-anon-types\016nested-externs\020new-returns-null\013"
    + "newline-eof\007non-gcc\033non-literal-null-conversion'non-modular-inclu"
    + "de-in-framework-module\035non-modular-include-in-module\017non-pod-vara"
    + "rgs\020non-virtual-dtor\007nonnull\025nonportable-cfstrings\030nonporta"
    + "ble-include-path\037nonportable-system-include-path!nonportable-vector-"
    + "initialization\017null-arithmetic\016null-character\017null-conversion\020"
    + "null-dereference\013nullability\030nullability-completeness\024nullabil"
    + "ity-declspec\025nullability-extension\036nullable-to-nonnull-conversion"
    + "+objc-autosynthesis-property-ivar-name-match\027objc-circular-container"
    + "\016objc-cocoa-api\034objc-designated-initializers\037objc-forward-clas"
    + "s-redefinition\024objc-interface-ivars\024objc-literal-compare\027objc-"
    + "literal-conversion\027objc-macro-redefinition\022objc-method-access\037"
    + "objc-missing-property-synthesis\030objc-missing-super-calls\032objc-mul"
    + "tiple-method-names\"objc-noncopy-retain-block-property\032objc-nonunifi"
    + "ed-exceptions\034objc-property-implementation\037objc-property-implicit"
    + "-mismatch*objc-property-matches-cocoa-ownership-rule\032objc-property-n"
    + "o-attribute\027objc-property-synthesis#objc-protocol-method-implementat"
    + "ion objc-protocol-property-synthesis\030objc-protocol-qualifiers\"objc-"
    + "readonly-with-setter-property\026objc-redundant-api-use\032objc-redunda"
    + "nt-literal-use\017objc-root-class\023objc-string-compare\031objc-string"
    + "-concatenation\003odr\016old-style-cast\024old-style-definition\016open"
    + "mp-clauses\020openmp-loop-form\015openmp-target\016option-ignored\027ou"
    + "t-of-line-declaration\014over-aligned\010overflow\022overlength-strings"
    + "\037overloaded-shift-op-parentheses\022overloaded-virtual\017override-m"
    + "odule\032overriding-method-mismatch\023overriding-t-option\006packed\006"
    + "padded\013parentheses\024parentheses-equality\024partial-availability\004"
    + "pass\015pass-analysis\013pass-failed\013pass-missed\015pch-date-time\010"
    + "pedantic\026pedantic-core-features\020pessimizing-move\015pointer-arith"
    + "\027pointer-bool-conversion\014pointer-sign\023pointer-to-int-cast\025p"
    + "ointer-type-mismatch potentially-evaluated-expression\032pragma-once-ou"
    + "tside-header#pragma-system-header-outside-header\007pragmas&predefined-"
    + "identifier-outside-function\016private-extern\016private-header\031prof"
    + "ile-instr-out-of-date\030profile-instr-unprofiled\032property-access-do"
    + "t-syntax\033property-attribute-mismatch\010protocol%protocol-property-s"
    + "ynthesis-ambiguity\032qualified-void-return-type\023range-loop-analysis"
    + "\032readonly-iboutlet-property\015receiver-expr\026receiver-forward-cla"
    + "ss\027redeclared-class-member\017redundant-decls\016redundant-move\010r"
    + "egister\026reinterpret-base-class\025remark-backend-plugin\007reorder\030"
    + "requires-super-attribute\021reserved-id-macro\035reserved-user-defined-"
    + "literal\031retained-language-linkage\024return-stack-address\013return-"
    + "type\025return-type-c-linkage\023rtti-for-exceptions\020sanitize-addres"
    + "s\007section\010selector\026selector-type-mismatch\013self-assign\021se"
    + "lf-assign-field\tself-move\034semicolon-before-method-body\010sentinel\016"
    + "sequence-point\026serialized-diagnostics\006shadow\nshadow-all\033shado"
    + "w-field-in-constructor$shadow-field-in-constructor-modified\013shadow-i"
    + "var\024shift-count-negative\024shift-count-overflow\024shift-negative-v"
    + "alue\024shift-op-parentheses\016shift-overflow\023shift-sign-overflow\020"
    + "shorten-64-to-32\014sign-compare\017sign-conversion\nsign-promo\025size"
    + "of-array-argument\022sizeof-array-decay\030sizeof-pointer-memaccess\027"
    + "sometimes-uninitialized\022source-uses-openmp\017stack-protector\021sta"
    + "tic-float-init\020static-in-inline$static-inline-explicit-instantiation"
    + "\026static-local-in-inline\020static-self-init\017strict-aliasing\021st"
    + "rict-aliasing=0\021strict-aliasing=1\021strict-aliasing=2\017strict-ove"
    + "rflow\021strict-overflow=0\021strict-overflow=1\021strict-overflow=2\021"
    + "strict-overflow=3\021strict-overflow=4\021strict-overflow=5\021strict-p"
    + "rototypes\025strict-selector-match\016string-compare\021string-conversi"
    + "on\020string-plus-char\017string-plus-int\024strlcpy-strlcat-size\014st"
    + "rncat-size\033super-class-method-mismatch\006switch\013switch-bool\016s"
    + "witch-default\013switch-enum%sync-fetch-and-nand-semantics-changed\005s"
    + "ynth\024tautological-compare*tautological-constant-out-of-range-compare"
    + "\034tautological-overlap-compare\034tautological-pointer-compare\036tau"
    + "tological-undefined-compare$tentative-definition-incomplete-type\015thr"
    + "ead-safety\026thread-safety-analysis\030thread-safety-attributes\022thr"
    + "ead-safety-beta\026thread-safety-negative\025thread-safety-precise\027t"
    + "hread-safety-reference\025thread-safety-verbose\ttrigraphs\013type-limi"
    + "ts\013type-safety\024typedef-redefinition\020typename-missing\030unavai"
    + "lable-declarations\023undeclared-selector\005undef\031undefined-bool-co"
    + "nversion\027undefined-func-template\020undefined-inline\022undefined-in"
    + "ternal\032undefined-reinterpret-cast\026undefined-var-template\026uneva"
    + "luated-expression\026unguarded-availability\007unicode\022unicode-white"
    + "space\015uninitialized\020unknown-argument\022unknown-attributes\027unk"
    + "nown-escape-sequence\017unknown-pragmas\022unknown-sanitizers\026unknow"
    + "n-warning-option\032unnamed-type-template-args\035unneeded-internal-dec"
    + "laration\030unneeded-member-function\020unreachable-code\033unreachable"
    + "-code-aggressive\026unreachable-code-break\037unreachable-code-loop-inc"
    + "rement\027unreachable-code-return\013unsequenced\016unsupported-cb#unsu"
    + "pported-dll-base-class-template\022unsupported-friend\017unsupported-na"
    + "n\026unsupported-visibility\006unused\017unused-argument\034unused-comm"
    + "and-line-argument\021unused-comparison\025unused-const-variable\032unus"
    + "ed-exception-parameter\017unused-function\032unused-getter-return-value"
    + "\014unused-label\024unused-local-typedef\025unused-local-typedefs\015un"
    + "used-macros\026unused-member-function\020unused-parameter\024unused-pri"
    + "vate-field\024unused-property-ivar\015unused-result\014unused-value\017"
    + "unused-variable\026unused-volatile-lvalue\026used-but-marked-unused\025"
    + "user-defined-literals\007varargs\017variadic-macros\021vector-conversio"
    + "n\022vector-conversions\014vexing-parse\nvisibility\003vla\015vla-exten"
    + "sion\024void-ptr-dereference\025volatile-register-var\025weak-template-"
    + "vtables\014weak-vtables\020writable-strings\015write-strings\021zero-le"
    + "ngth-array"            
    ).getBytes("utf-8");
  } catch (UnsupportedEncodingException ex) {
    value = new$char(0);
  }
  DiagGroupNames = value;
  assert NativeTrace.registerArrayWithImmutableContent(DiagGroupNames, "DiagGroupNames");
}
} // END OF class DiagnosticGroupsGlobals
