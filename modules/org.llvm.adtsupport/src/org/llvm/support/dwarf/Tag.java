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

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::Tag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 57,
 FQN="llvm::dwarf::Tag", NM="_ZN4llvm5dwarf3TagE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf3TagE")
//</editor-fold>
public final class/*enum*/ Tag/* : uint16_t*/ {
  public static final /*uint16_t*/char DW_TAG_array_type = 0x1;
  public static final /*uint16_t*/char DW_TAG_class_type = 0x2;
  public static final /*uint16_t*/char DW_TAG_entry_point = 0x3;
  public static final /*uint16_t*/char DW_TAG_enumeration_type = 0x4;
  public static final /*uint16_t*/char DW_TAG_formal_parameter = 0x5;
  public static final /*uint16_t*/char DW_TAG_imported_declaration = 0x8;
  public static final /*uint16_t*/char DW_TAG_label = 0xA;
  public static final /*uint16_t*/char DW_TAG_lexical_block = 0xB;
  public static final /*uint16_t*/char DW_TAG_member = 0xD;
  public static final /*uint16_t*/char DW_TAG_pointer_type = 0xF;
  public static final /*uint16_t*/char DW_TAG_reference_type = 0x10;
  public static final /*uint16_t*/char DW_TAG_compile_unit = 0x11;
  public static final /*uint16_t*/char DW_TAG_string_type = 0x12;
  public static final /*uint16_t*/char DW_TAG_structure_type = 0x13;
  public static final /*uint16_t*/char DW_TAG_subroutine_type = 0x15;
  public static final /*uint16_t*/char DW_TAG_typedef = 0x16;
  public static final /*uint16_t*/char DW_TAG_union_type = 0x17;
  public static final /*uint16_t*/char DW_TAG_unspecified_parameters = 0x18;
  public static final /*uint16_t*/char DW_TAG_variant = 0x19;
  public static final /*uint16_t*/char DW_TAG_common_block = 0x1A;
  public static final /*uint16_t*/char DW_TAG_common_inclusion = 0x1B;
  public static final /*uint16_t*/char DW_TAG_inheritance = 0x1C;
  public static final /*uint16_t*/char DW_TAG_inlined_subroutine = 0x1D;
  public static final /*uint16_t*/char DW_TAG_module = 0x1E;
  public static final /*uint16_t*/char DW_TAG_ptr_to_member_type = 0x1F;
  public static final /*uint16_t*/char DW_TAG_set_type = 0x20;
  public static final /*uint16_t*/char DW_TAG_subrange_type = 0x21;
  public static final /*uint16_t*/char DW_TAG_with_stmt = 0x22;
  public static final /*uint16_t*/char DW_TAG_access_declaration = 0x23;
  public static final /*uint16_t*/char DW_TAG_base_type = 0x24;
  public static final /*uint16_t*/char DW_TAG_catch_block = 0x25;
  public static final /*uint16_t*/char DW_TAG_const_type = 0x26;
  public static final /*uint16_t*/char DW_TAG_constant = 0x27;
  public static final /*uint16_t*/char DW_TAG_enumerator = 0x28;
  public static final /*uint16_t*/char DW_TAG_file_type = 0x29;
  public static final /*uint16_t*/char DW_TAG_friend = 0x2A;
  public static final /*uint16_t*/char DW_TAG_namelist = 0x2B;
  public static final /*uint16_t*/char DW_TAG_namelist_item = 0x2C;
  public static final /*uint16_t*/char DW_TAG_packed_type = 0x2D;
  public static final /*uint16_t*/char DW_TAG_subprogram = 0x2E;
  public static final /*uint16_t*/char DW_TAG_template_type_parameter = 0x2F;
  public static final /*uint16_t*/char DW_TAG_template_value_parameter = 0x30;
  public static final /*uint16_t*/char DW_TAG_thrown_type = 0x31;
  public static final /*uint16_t*/char DW_TAG_try_block = 0x32;
  public static final /*uint16_t*/char DW_TAG_variant_part = 0x33;
  public static final /*uint16_t*/char DW_TAG_variable = 0x34;
  public static final /*uint16_t*/char DW_TAG_volatile_type = 0x35;
  public static final /*uint16_t*/char DW_TAG_dwarf_procedure = 0x36;
  public static final /*uint16_t*/char DW_TAG_restrict_type = 0x37;
  public static final /*uint16_t*/char DW_TAG_interface_type = 0x38;
  public static final /*uint16_t*/char DW_TAG_namespace = 0x39;
  public static final /*uint16_t*/char DW_TAG_imported_module = 0x3A;
  public static final /*uint16_t*/char DW_TAG_unspecified_type = 0x3B;
  public static final /*uint16_t*/char DW_TAG_partial_unit = 0x3C;
  public static final /*uint16_t*/char DW_TAG_imported_unit = 0x3D;
  public static final /*uint16_t*/char DW_TAG_condition = 0x3F;
  public static final /*uint16_t*/char DW_TAG_shared_type = 0x40;
  public static final /*uint16_t*/char DW_TAG_type_unit = 0x41;
  public static final /*uint16_t*/char DW_TAG_rvalue_reference_type = 0x42;
  public static final /*uint16_t*/char DW_TAG_template_alias = 0x43;
  
  // New in DWARF v5.
  public static final /*uint16_t*/char DW_TAG_coarray_type = 0x44;
  public static final /*uint16_t*/char DW_TAG_generic_subrange = 0x45;
  public static final /*uint16_t*/char DW_TAG_dynamic_type = 0x46;
  
  // User-defined tags.
  public static final /*uint16_t*/char DW_TAG_MIPS_loop = 0x4081;
  public static final /*uint16_t*/char DW_TAG_format_label = 0x4101;
  public static final /*uint16_t*/char DW_TAG_function_template = 0x4102;
  public static final /*uint16_t*/char DW_TAG_class_template = 0x4103;
  public static final /*uint16_t*/char DW_TAG_GNU_template_template_param = 0x4106;
  public static final /*uint16_t*/char DW_TAG_GNU_template_parameter_pack = 0x4107;
  public static final /*uint16_t*/char DW_TAG_GNU_formal_parameter_pack = 0x4108;
  public static final /*uint16_t*/char DW_TAG_APPLE_property = 0x4200;
  public static final /*uint16_t*/char DW_TAG_BORLAND_property = 0xB000;
  public static final /*uint16_t*/char DW_TAG_BORLAND_Delphi_string = 0xB001;
  public static final /*uint16_t*/char DW_TAG_BORLAND_Delphi_dynamic_array = 0xB002;
  public static final /*uint16_t*/char DW_TAG_BORLAND_Delphi_set = 0xB003;
  public static final /*uint16_t*/char DW_TAG_BORLAND_Delphi_variant = 0xB004;
  public static final /*uint16_t*/char DW_TAG_lo_user = 0x4080;
  public static final /*uint16_t*/char DW_TAG_hi_user = 0xffff;
  public static final /*uint16_t*/char DW_TAG_user_base = 0x1000; // Recommended base for user tags.
}
