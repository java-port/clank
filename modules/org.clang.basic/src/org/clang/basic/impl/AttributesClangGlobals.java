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
package org.clang.basic.impl;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;


//<editor-fold defaultstate="collapsed" desc="static type AttributesClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang12hasAttributeENS_10AttrSyntaxEPKNS_14IdentifierInfoES3_RKNS_10TargetInfoERKNS_11LangOptionsE; -static-type=AttributesClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class AttributesClangGlobals {


/// \brief Return the version number associated with the attribute if we
/// recognize and implement the attribute specified by the given information.
//<editor-fold defaultstate="collapsed" desc="clang::hasAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp", line = 6,
 FQN="clang::hasAttribute", NM="_ZN5clang12hasAttributeENS_10AttrSyntaxEPKNS_14IdentifierInfoES3_RKNS_10TargetInfoERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang12hasAttributeENS_10AttrSyntaxEPKNS_14IdentifierInfoES3_RKNS_10TargetInfoERKNS_11LangOptionsE")
//</editor-fold>
public static int hasAttribute(AttrSyntax Syntax, /*const*/ IdentifierInfo /*P*/ Scope, 
            /*const*/ IdentifierInfo /*P*/ Attr, /*const*/ TargetInfo /*&*/ Target, 
            /*const*/ LangOptions /*&*/ LangOpts) {
  StringRef Name = Attr.getName();
  // Normalize the attribute name, __foo__ becomes foo.
  if ($greatereq_uint(Name.size(), 4) && Name.startswith(/*STRINGREF_STR*/"__") && Name.endswith(/*STRINGREF_STR*/"__")) {
    Name.$assignMove(Name.substr(2, Name.size() - 4));
  }
  /*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
  |*                                                                            *|
  |* Code to implement the __has_attribute logic                                *|
  |*                                                                            *|
  |* Automatically generated file, do not edit!                                 *|
  |*                                                                            *|
  \*===----------------------------------------------------------------------===*/
  /*const*/ Triple /*&*/ T = Target.getTriple();
  switch (Syntax) {
   case GNU:
    return new StringSwitchInt(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"amdgpu_num_sgpr", 1).
        Case(/*KEEP_STR*/"amdgpu_num_vgpr", 1).
        Case(/*KEEP_STR*/"interrupt", (T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) ? 1 : 0).
        Case(/*KEEP_STR*/"abi_tag", 1).
        Case(/*KEEP_STR*/"acquire_capability", 1).
        Case(/*KEEP_STR*/"acquire_shared_capability", 1).
        Case(/*KEEP_STR*/"exclusive_lock_function", 1).
        Case(/*KEEP_STR*/"shared_lock_function", 1).
        Case(/*KEEP_STR*/"acquire_capability", 1).
        Case(/*KEEP_STR*/"acquire_shared_capability", 1).
        Case(/*KEEP_STR*/"exclusive_lock_function", 1).
        Case(/*KEEP_STR*/"shared_lock_function", 1).
        Case(/*KEEP_STR*/"acquire_capability", 1).
        Case(/*KEEP_STR*/"acquire_shared_capability", 1).
        Case(/*KEEP_STR*/"exclusive_lock_function", 1).
        Case(/*KEEP_STR*/"shared_lock_function", 1).
        Case(/*KEEP_STR*/"acquire_capability", 1).
        Case(/*KEEP_STR*/"acquire_shared_capability", 1).
        Case(/*KEEP_STR*/"exclusive_lock_function", 1).
        Case(/*KEEP_STR*/"shared_lock_function", 1).
        Case(/*KEEP_STR*/"acquired_after", 1).
        Case(/*KEEP_STR*/"acquired_before", 1).
        Case(/*KEEP_STR*/"address_space", 1).
        Case(/*KEEP_STR*/"alias", 1).
        Case(/*KEEP_STR*/"align_value", 1).
        Case(/*KEEP_STR*/"aligned", 1).
        Case(/*KEEP_STR*/"always_inline", 1).
        Case(/*KEEP_STR*/"analyzer_noreturn", 1).
        Case(/*KEEP_STR*/"annotate", 1).
        Case(/*KEEP_STR*/"interrupt", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64) ? 1 : 0).
        Case(/*KEEP_STR*/"objc_arc_weak_reference_unavailable", 1).
        Case(/*KEEP_STR*/"argument_with_type_tag", 1).
        Case(/*KEEP_STR*/"pointer_with_type_tag", 1).
        Case(/*KEEP_STR*/"argument_with_type_tag", 1).
        Case(/*KEEP_STR*/"pointer_with_type_tag", 1).
        Case(/*KEEP_STR*/"assert_capability", 1).
        Case(/*KEEP_STR*/"assert_shared_capability", 1).
        Case(/*KEEP_STR*/"assert_capability", 1).
        Case(/*KEEP_STR*/"assert_shared_capability", 1).
        Case(/*KEEP_STR*/"assert_exclusive_lock", 1).
        Case(/*KEEP_STR*/"assert_shared_lock", 1).
        Case(/*KEEP_STR*/"assume_aligned", 1).
        Case(/*KEEP_STR*/"availability", 1).
        Case(/*KEEP_STR*/"blocks", 1).
        Case(/*KEEP_STR*/"bounded", 1).
        Case(/*KEEP_STR*/"cdecl", 1).
        Case(/*KEEP_STR*/"cf_audited_transfer", 1).
        Case(/*KEEP_STR*/"cf_consumed", 1).
        Case(/*KEEP_STR*/"cf_returns_not_retained", 1).
        Case(/*KEEP_STR*/"cf_returns_retained", 1).
        Case(/*KEEP_STR*/"cf_unknown_transfer", 1).
        Case(/*KEEP_STR*/"constant", 1).
        Case(/*KEEP_STR*/"cudart_builtin", 1).
        Case(/*KEEP_STR*/"device", 1).
        Case(/*KEEP_STR*/"device_builtin", 1).
        Case(/*KEEP_STR*/"device_builtin_surface_type", 1).
        Case(/*KEEP_STR*/"device_builtin_texture_type", 1).
        Case(/*KEEP_STR*/"global", 1).
        Case(/*KEEP_STR*/"host", 1).
        Case(/*KEEP_STR*/"launch_bounds", 1).
        Case(/*KEEP_STR*/"shared", 1).
        Case(/*KEEP_STR*/"callable_when", 1).
        Case(/*KEEP_STR*/"capability", 1).
        Case(/*KEEP_STR*/"shared_capability", 1).
        Case(/*KEEP_STR*/"capability", 1).
        Case(/*KEEP_STR*/"shared_capability", 1).
        Case(/*KEEP_STR*/"carries_dependency", 1).
        Case(/*KEEP_STR*/"cleanup", 1).
        Case(/*KEEP_STR*/"cold", 1).
        Case(/*KEEP_STR*/"common", 1).
        Case(/*KEEP_STR*/"const", 1).
        Case(/*KEEP_STR*/"__const", 1).
        Case(/*KEEP_STR*/"const", 1).
        Case(/*KEEP_STR*/"__const", 1).
        Case(/*KEEP_STR*/"constructor", 1).
        Case(/*KEEP_STR*/"consumable", 1).
        Case(/*KEEP_STR*/"consumable_auto_cast_state", 1).
        Case(/*KEEP_STR*/"consumable_set_state_on_read", 1).
        Case(/*KEEP_STR*/"dllexport", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (T.getOS() == Triple.OSType.Win32) ? 1 : 0).
        Case(/*KEEP_STR*/"dllimport", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (T.getOS() == Triple.OSType.Win32) ? 1 : 0).
        Case(/*KEEP_STR*/"deprecated", 1).
        Case(/*KEEP_STR*/"destructor", 1).
        Case(/*KEEP_STR*/"disable_tail_calls", 1).
        Case(/*KEEP_STR*/"enable_if", 1).
        Case(/*KEEP_STR*/"exclusive_trylock_function", 1).
        Case(/*KEEP_STR*/"ext_vector_type", 1).
        Case(/*KEEP_STR*/"fastcall", 1).
        Case(/*KEEP_STR*/"flag_enum", 1).
        Case(/*KEEP_STR*/"flatten", 1).
        Case(/*KEEP_STR*/"format", 1).
        Case(/*KEEP_STR*/"format_arg", 1).
        Case(/*KEEP_STR*/"gnu_inline", 1).
        Case(/*KEEP_STR*/"guarded_by", 1).
        Case(/*KEEP_STR*/"guarded_var", 1).
        Case(/*KEEP_STR*/"hot", 1).
        Case(/*KEEP_STR*/"ibaction", 1).
        Case(/*KEEP_STR*/"iboutlet", 1).
        Case(/*KEEP_STR*/"iboutletcollection", 1).
        Case(/*KEEP_STR*/"ifunc", 1).
        Case(/*KEEP_STR*/"init_priority", 1).
        Case(/*KEEP_STR*/"intel_ocl_bicc", 1).
        Case(/*KEEP_STR*/"internal_linkage", 1).
        Case(/*KEEP_STR*/"lock_returned", 1).
        Case(/*KEEP_STR*/"lockable", 1).
        Case(/*KEEP_STR*/"locks_excluded", 1).
        Case(/*KEEP_STR*/"ms_abi", 1).
        Case(/*KEEP_STR*/"interrupt", (T.getArch() == Triple.ArchType.msp430) ? 1 : 0).
        Case(/*KEEP_STR*/"ms_struct", 1).
        Case(/*KEEP_STR*/"may_alias", 1).
        Case(/*KEEP_STR*/"minsize", 1).
        Case(/*KEEP_STR*/"mips16", (T.getArch() == Triple.ArchType.mips || T.getArch() == Triple.ArchType.mipsel) ? 1 : 0).
        Case(/*KEEP_STR*/"interrupt", (T.getArch() == Triple.ArchType.mips || T.getArch() == Triple.ArchType.mipsel) ? 1 : 0).
        Case(/*KEEP_STR*/"mode", 1).
        Case(/*KEEP_STR*/"ns_consumed", 1).
        Case(/*KEEP_STR*/"ns_consumes_self", 1).
        Case(/*KEEP_STR*/"ns_returns_autoreleased", 1).
        Case(/*KEEP_STR*/"ns_returns_not_retained", 1).
        Case(/*KEEP_STR*/"ns_returns_retained", 1).
        Case(/*KEEP_STR*/"naked", 1).
        Case(/*KEEP_STR*/"neon_polyvector_type", 1).
        Case(/*KEEP_STR*/"neon_vector_type", 1).
        Case(/*KEEP_STR*/"nocommon", 1).
        Case(/*KEEP_STR*/"nodebug", 1).
        Case(/*KEEP_STR*/"noduplicate", 1).
        Case(/*KEEP_STR*/"noinline", 1).
        Case(/*KEEP_STR*/"no_instrument_function", 1).
        Case(/*KEEP_STR*/"nomips16", (T.getArch() == Triple.ArchType.mips || T.getArch() == Triple.ArchType.mipsel) ? 1 : 0).
        Case(/*KEEP_STR*/"noreturn", 1).
        Case(/*KEEP_STR*/"no_sanitize", 1).
        Case(/*KEEP_STR*/"no_address_safety_analysis", 1).
        Case(/*KEEP_STR*/"no_sanitize_address", 1).
        Case(/*KEEP_STR*/"no_sanitize_thread", 1).
        Case(/*KEEP_STR*/"no_sanitize_memory", 1).
        Case(/*KEEP_STR*/"no_address_safety_analysis", 1).
        Case(/*KEEP_STR*/"no_sanitize_address", 1).
        Case(/*KEEP_STR*/"no_sanitize_thread", 1).
        Case(/*KEEP_STR*/"no_sanitize_memory", 1).
        Case(/*KEEP_STR*/"no_address_safety_analysis", 1).
        Case(/*KEEP_STR*/"no_sanitize_address", 1).
        Case(/*KEEP_STR*/"no_sanitize_thread", 1).
        Case(/*KEEP_STR*/"no_sanitize_memory", 1).
        Case(/*KEEP_STR*/"no_address_safety_analysis", 1).
        Case(/*KEEP_STR*/"no_sanitize_address", 1).
        Case(/*KEEP_STR*/"no_sanitize_thread", 1).
        Case(/*KEEP_STR*/"no_sanitize_memory", 1).
        Case(/*KEEP_STR*/"no_split_stack", 1).
        Case(/*KEEP_STR*/"no_thread_safety_analysis", 1).
        Case(/*KEEP_STR*/"nothrow", 1).
        Case(/*KEEP_STR*/"nonnull", 1).
        Case(/*KEEP_STR*/"not_tail_called", 1).
        Case(/*KEEP_STR*/"nv_weak", 1).
        Case(/*KEEP_STR*/"objc_boxable", 1).
        Case(/*KEEP_STR*/"objc_bridge", 1).
        Case(/*KEEP_STR*/"objc_bridge_mutable", 1).
        Case(/*KEEP_STR*/"objc_bridge_related", 1).
        Case(/*KEEP_STR*/"objc_designated_initializer", 1).
        Case(/*KEEP_STR*/"objc_exception", 1).
        Case(/*KEEP_STR*/"objc_protocol_requires_explicit_implementation", 1).
        Case(/*KEEP_STR*/"objc_gc", 1).
        Case(/*KEEP_STR*/"objc_independent_class", 1).
        Case(/*KEEP_STR*/"objc_method_family", 1).
        Case(/*KEEP_STR*/"NSObject", 1).
        Case(/*KEEP_STR*/"objc_ownership", 1).
        Case(/*KEEP_STR*/"objc_precise_lifetime", 1).
        Case(/*KEEP_STR*/"objc_requires_property_definitions", 1).
        Case(/*KEEP_STR*/"objc_requires_super", 1).
        Case(/*KEEP_STR*/"objc_returns_inner_pointer", 1).
        Case(/*KEEP_STR*/"objc_root_class", 1).
        Case(/*KEEP_STR*/"objc_runtime_name", 1).
        Case(/*KEEP_STR*/"objc_runtime_visible", 1).
        Case(/*KEEP_STR*/"nosvm", 1).
        Case(/*KEEP_STR*/"opencl_unroll_hint", 1).
        Case(/*KEEP_STR*/"optnone", 1).
        Case(/*KEEP_STR*/"overloadable", 1).
        Case(/*KEEP_STR*/"ownership_holds", 1).
        Case(/*KEEP_STR*/"ownership_returns", 1).
        Case(/*KEEP_STR*/"ownership_takes", 1).
        Case(/*KEEP_STR*/"ownership_holds", 1).
        Case(/*KEEP_STR*/"ownership_returns", 1).
        Case(/*KEEP_STR*/"ownership_takes", 1).
        Case(/*KEEP_STR*/"ownership_holds", 1).
        Case(/*KEEP_STR*/"ownership_returns", 1).
        Case(/*KEEP_STR*/"ownership_takes", 1).
        Case(/*KEEP_STR*/"packed", 1).
        Case(/*KEEP_STR*/"param_typestate", 1).
        Case(/*KEEP_STR*/"pascal", 1).
        Case(/*KEEP_STR*/"pass_object_size", 1).
        Case(/*KEEP_STR*/"pcs", 1).
        Case(/*KEEP_STR*/"preserve_all", 1).
        Case(/*KEEP_STR*/"preserve_most", 1).
        Case(/*KEEP_STR*/"pt_guarded_by", 1).
        Case(/*KEEP_STR*/"pt_guarded_var", 1).
        Case(/*KEEP_STR*/"pure", 1).
        Case(/*KEEP_STR*/"regparm", 1).
        Case(/*KEEP_STR*/"release_capability", 1).
        Case(/*KEEP_STR*/"release_shared_capability", 1).
        Case(/*KEEP_STR*/"release_generic_capability", 1).
        Case(/*KEEP_STR*/"unlock_function", 1).
        Case(/*KEEP_STR*/"release_capability", 1).
        Case(/*KEEP_STR*/"release_shared_capability", 1).
        Case(/*KEEP_STR*/"release_generic_capability", 1).
        Case(/*KEEP_STR*/"unlock_function", 1).
        Case(/*KEEP_STR*/"release_capability", 1).
        Case(/*KEEP_STR*/"release_shared_capability", 1).
        Case(/*KEEP_STR*/"release_generic_capability", 1).
        Case(/*KEEP_STR*/"unlock_function", 1).
        Case(/*KEEP_STR*/"release_capability", 1).
        Case(/*KEEP_STR*/"release_shared_capability", 1).
        Case(/*KEEP_STR*/"release_generic_capability", 1).
        Case(/*KEEP_STR*/"unlock_function", 1).
        Case(/*KEEP_STR*/"kernel", 1).
        Case(/*KEEP_STR*/"reqd_work_group_size", 1).
        Case(/*KEEP_STR*/"requires_capability", 1).
        Case(/*KEEP_STR*/"exclusive_locks_required", 1).
        Case(/*KEEP_STR*/"requires_shared_capability", 1).
        Case(/*KEEP_STR*/"shared_locks_required", 1).
        Case(/*KEEP_STR*/"requires_capability", 1).
        Case(/*KEEP_STR*/"exclusive_locks_required", 1).
        Case(/*KEEP_STR*/"requires_shared_capability", 1).
        Case(/*KEEP_STR*/"shared_locks_required", 1).
        Case(/*KEEP_STR*/"requires_capability", 1).
        Case(/*KEEP_STR*/"exclusive_locks_required", 1).
        Case(/*KEEP_STR*/"requires_shared_capability", 1).
        Case(/*KEEP_STR*/"shared_locks_required", 1).
        Case(/*KEEP_STR*/"requires_capability", 1).
        Case(/*KEEP_STR*/"exclusive_locks_required", 1).
        Case(/*KEEP_STR*/"requires_shared_capability", 1).
        Case(/*KEEP_STR*/"shared_locks_required", 1).
        Case(/*KEEP_STR*/"malloc", 1).
        Case(/*KEEP_STR*/"return_typestate", 1).
        Case(/*KEEP_STR*/"returns_nonnull", 1).
        Case(/*KEEP_STR*/"returns_twice", 1).
        Case(/*KEEP_STR*/"scoped_lockable", 1).
        Case(/*KEEP_STR*/"section", 1).
        Case(/*KEEP_STR*/"sentinel", 1).
        Case(/*KEEP_STR*/"set_typestate", 1).
        Case(/*KEEP_STR*/"shared_trylock_function", 1).
        Case(/*KEEP_STR*/"stdcall", 1).
        Case(/*KEEP_STR*/"swiftcall", 1).
        Case(/*KEEP_STR*/"swift_context", 1).
        Case(/*KEEP_STR*/"swift_error_result", 1).
        Case(/*KEEP_STR*/"swift_indirect_result", 1).
        Case(/*KEEP_STR*/"sysv_abi", 1).
        Case(/*KEEP_STR*/"tls_model", 1).
        Case(/*KEEP_STR*/"target", 1).
        Case(/*KEEP_STR*/"test_typestate", 1).
        Case(/*KEEP_STR*/"thiscall", 1).
        Case(/*KEEP_STR*/"transparent_union", 1).
        Case(/*KEEP_STR*/"try_acquire_capability", 1).
        Case(/*KEEP_STR*/"try_acquire_shared_capability", 1).
        Case(/*KEEP_STR*/"try_acquire_capability", 1).
        Case(/*KEEP_STR*/"try_acquire_shared_capability", 1).
        Case(/*KEEP_STR*/"type_tag_for_datatype", 1).
        Case(/*KEEP_STR*/"type_visibility", 1).
        Case(/*KEEP_STR*/"unavailable", 1).
        Case(/*KEEP_STR*/"unused", 1).
        Case(/*KEEP_STR*/"used", 1).
        Case(/*KEEP_STR*/"vecreturn", 1).
        Case(/*KEEP_STR*/"vec_type_hint", 1).
        Case(/*KEEP_STR*/"vectorcall", 1).
        Case(/*KEEP_STR*/"vector_size", 1).
        Case(/*KEEP_STR*/"visibility", 1).
        Case(/*KEEP_STR*/"warn_unused", 1).
        Case(/*KEEP_STR*/"warn_unused_result", 1).
        Case(/*KEEP_STR*/"weak", 1).
        Case(/*KEEP_STR*/"weak_import", 1).
        Case(/*KEEP_STR*/"weakref", 1).
        Case(/*KEEP_STR*/"work_group_size_hint", 1).
        Case(/*KEEP_STR*/"force_align_arg_pointer", (T.getArch() == Triple.ArchType.x86) ? 1 : 0).
        Case(/*KEEP_STR*/"xray_always_instrument", 1).
        Case(/*KEEP_STR*/"xray_never_instrument", 1).
        Case(/*KEEP_STR*/"xray_always_instrument", 1).
        Case(/*KEEP_STR*/"xray_never_instrument", 1).
        Default(0);
   case Declspec:
    return new StringSwitchInt(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"align", 1).
        Case(/*KEEP_STR*/"dllexport", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (T.getOS() == Triple.OSType.Win32) ? 1 : 0).
        Case(/*KEEP_STR*/"dllimport", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (T.getOS() == Triple.OSType.Win32) ? 1 : 0).
        Case(/*KEEP_STR*/"deprecated", 1).
        Case(/*KEEP_STR*/"empty_bases", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (Target.getCXXABI().getKind() == TargetCXXABI.Kind.Microsoft) ? 1 : 0).
        Case(/*KEEP_STR*/"layout_version", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (Target.getCXXABI().getKind() == TargetCXXABI.Kind.Microsoft) ? 1 : 0).
        Case(/*KEEP_STR*/"novtable", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (Target.getCXXABI().getKind() == TargetCXXABI.Kind.Microsoft) ? 1 : 0).
        Case(/*KEEP_STR*/"naked", 1).
        Case(/*KEEP_STR*/"noalias", 1).
        Case(/*KEEP_STR*/"noinline", 1).
        Case(/*KEEP_STR*/"noreturn", 1).
        Case(/*KEEP_STR*/"nothrow", 1).
        Case(/*KEEP_STR*/"restrict", 1).
        Case(/*KEEP_STR*/"allocate", 1).
        Case(/*KEEP_STR*/"selectany", 1).
        Case(/*KEEP_STR*/"thread", 1).
        Case(/*KEEP_STR*/"uuid", 1).
        Case(/*KEEP_STR*/"property", 1).
        Default(0);
   case Pragma:
    return new StringSwitchInt(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"init_seg", 1).
        Case(/*KEEP_STR*/"loop", 1).
        Case(/*KEEP_STR*/"unroll", 1).
        Case(/*KEEP_STR*/"nounroll", 1).
        Case(/*KEEP_STR*/"loop", 1).
        Case(/*KEEP_STR*/"unroll", 1).
        Case(/*KEEP_STR*/"nounroll", 1).
        Case(/*KEEP_STR*/"loop", 1).
        Case(/*KEEP_STR*/"unroll", 1).
        Case(/*KEEP_STR*/"nounroll", 1).
        Case(/*KEEP_STR*/"declare simd", 1).
        Case(/*KEEP_STR*/"declare target", 1).
        Default(0);
   case CXX:
    {
      if (!(Scope != null) || $eq_StringRef(Scope.getName(), /*STRINGREF_STR*/"")) {
        return new StringSwitchInt(/*NO_COPY*/Name).
            Case(/*KEEP_STR*/"noreturn", LangOpts.CPlusPlus11 ? 200809 : 0).
            Case(/*KEEP_STR*/"carries_dependency", LangOpts.CPlusPlus11 ? 200809 : 0).
            Case(/*KEEP_STR*/"deprecated", LangOpts.CPlusPlus11 ? 201309 : 0).
            Case(/*KEEP_STR*/"deprecated", LangOpts.CPlusPlus11 ? 201309 : 0).
            Case(/*KEEP_STR*/"fallthrough", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"fallthrough", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"maybe_unused", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"unused", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"nodiscard", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"warn_unused_result", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"warn_unused_result", LangOpts.CPlusPlus11 ? 201603 : 0).
            Default(0);
      } else if ($eq_StringRef(Scope.getName(), /*STRINGREF_STR*/"clang")) {
        return new StringSwitchInt(/*NO_COPY*/Name).
            Case(/*KEEP_STR*/"acquire_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"acquire_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"acquire_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"acquire_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"assert_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"assert_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"assert_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"assert_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"disable_tail_calls", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"fallthrough", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"internal_linkage", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"lto_visibility_public", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"noduplicate", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_sanitize", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"not_tail_called", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"optnone", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_generic_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_generic_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"release_generic_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"requires_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"requires_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"requires_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"requires_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"try_acquire_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"try_acquire_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"try_acquire_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"try_acquire_shared_capability", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"type_visibility", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"warn_unused_result", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"xray_always_instrument", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"xray_never_instrument", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"xray_always_instrument", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"xray_never_instrument", LangOpts.CPlusPlus11 ? 1 : 0).
            Default(0);
      } else if ($eq_StringRef(Scope.getName(), /*STRINGREF_STR*/"gnu")) {
        return new StringSwitchInt(/*NO_COPY*/Name).
            Case(/*KEEP_STR*/"abi_tag", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"alias", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"aligned", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"always_inline", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"assume_aligned", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"cdecl", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"cleanup", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"cold", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"common", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"const", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"__const", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"const", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"__const", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"constructor", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"dllexport", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (T.getOS() == Triple.OSType.Win32) && LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"dllimport", (T.getArch() == Triple.ArchType.x86 || T.getArch() == Triple.ArchType.x86_64 || T.getArch() == Triple.ArchType.arm || T.getArch() == Triple.ArchType.thumb) && (T.getOS() == Triple.OSType.Win32) && LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"deprecated", LangOpts.CPlusPlus11 ? 201309 : 0).
            Case(/*KEEP_STR*/"destructor", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"fastcall", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"flatten", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"format", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"format_arg", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"gnu_inline", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"hot", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"ifunc", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"ms_abi", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"ms_struct", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"may_alias", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"mips16", (T.getArch() == Triple.ArchType.mips || T.getArch() == Triple.ArchType.mipsel) && LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"mode", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"naked", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"nocommon", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"nodebug", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"noinline", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_instrument_function", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"nomips16", (T.getArch() == Triple.ArchType.mips || T.getArch() == Triple.ArchType.mipsel) && LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"noreturn", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_address_safety_analysis", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_sanitize_address", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_sanitize_thread", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_address_safety_analysis", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_sanitize_address", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_sanitize_thread", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_address_safety_analysis", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_sanitize_address", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_sanitize_thread", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"no_split_stack", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"nothrow", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"nonnull", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"packed", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"pcs", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"pure", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"regparm", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"malloc", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"returns_nonnull", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"returns_twice", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"section", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"sentinel", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"stdcall", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"swiftcall", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"swift_context", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"swift_error_result", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"swift_indirect_result", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"sysv_abi", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"tls_model", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"target", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"thiscall", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"transparent_union", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"unused", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"used", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"vector_size", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"visibility", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"warn_unused_result", LangOpts.CPlusPlus11 ? 201603 : 0).
            Case(/*KEEP_STR*/"weak", LangOpts.CPlusPlus11 ? 1 : 0).
            Case(/*KEEP_STR*/"weakref", LangOpts.CPlusPlus11 ? 1 : 0).
            Default(0);
      }
    }
  }
  
  return 0;
}

} // END OF class AttributesClangGlobals
