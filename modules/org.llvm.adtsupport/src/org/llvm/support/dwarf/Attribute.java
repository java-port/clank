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

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::Attribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 93,
 FQN="llvm::dwarf::Attribute", NM="_ZN4llvm5dwarf9AttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf9AttributeE")
//</editor-fold>
public final class/*enum*/ Attribute/* : uint16_t*/ {
  // Attributes
  public static final /*uint16_t*/char DW_AT_sibling = 0x01;
  public static final /*uint16_t*/char DW_AT_location = 0x02;
  public static final /*uint16_t*/char DW_AT_name = 0x03;
  public static final /*uint16_t*/char DW_AT_ordering = 0x09;
  public static final /*uint16_t*/char DW_AT_byte_size = 0x0b;
  public static final /*uint16_t*/char DW_AT_bit_offset = 0x0c;
  public static final /*uint16_t*/char DW_AT_bit_size = 0x0d;
  public static final /*uint16_t*/char DW_AT_stmt_list = 0x10;
  public static final /*uint16_t*/char DW_AT_low_pc = 0x11;
  public static final /*uint16_t*/char DW_AT_high_pc = 0x12;
  public static final /*uint16_t*/char DW_AT_language = 0x13;
  public static final /*uint16_t*/char DW_AT_discr = 0x15;
  public static final /*uint16_t*/char DW_AT_discr_value = 0x16;
  public static final /*uint16_t*/char DW_AT_visibility = 0x17;
  public static final /*uint16_t*/char DW_AT_import = 0x18;
  public static final /*uint16_t*/char DW_AT_string_length = 0x19;
  public static final /*uint16_t*/char DW_AT_common_reference = 0x1a;
  public static final /*uint16_t*/char DW_AT_comp_dir = 0x1b;
  public static final /*uint16_t*/char DW_AT_const_value = 0x1c;
  public static final /*uint16_t*/char DW_AT_containing_type = 0x1d;
  public static final /*uint16_t*/char DW_AT_default_value = 0x1e;
  public static final /*uint16_t*/char DW_AT_inline = 0x20;
  public static final /*uint16_t*/char DW_AT_is_optional = 0x21;
  public static final /*uint16_t*/char DW_AT_lower_bound = 0x22;
  public static final /*uint16_t*/char DW_AT_producer = 0x25;
  public static final /*uint16_t*/char DW_AT_prototyped = 0x27;
  public static final /*uint16_t*/char DW_AT_return_addr = 0x2a;
  public static final /*uint16_t*/char DW_AT_start_scope = 0x2c;
  public static final /*uint16_t*/char DW_AT_bit_stride = 0x2e;
  public static final /*uint16_t*/char DW_AT_upper_bound = 0x2f;
  public static final /*uint16_t*/char DW_AT_abstract_origin = 0x31;
  public static final /*uint16_t*/char DW_AT_accessibility = 0x32;
  public static final /*uint16_t*/char DW_AT_address_class = 0x33;
  public static final /*uint16_t*/char DW_AT_artificial = 0x34;
  public static final /*uint16_t*/char DW_AT_base_types = 0x35;
  public static final /*uint16_t*/char DW_AT_calling_convention = 0x36;
  public static final /*uint16_t*/char DW_AT_count = 0x37;
  public static final /*uint16_t*/char DW_AT_data_member_location = 0x38;
  public static final /*uint16_t*/char DW_AT_decl_column = 0x39;
  public static final /*uint16_t*/char DW_AT_decl_file = 0x3a;
  public static final /*uint16_t*/char DW_AT_decl_line = 0x3b;
  public static final /*uint16_t*/char DW_AT_declaration = 0x3c;
  public static final /*uint16_t*/char DW_AT_discr_list = 0x3d;
  public static final /*uint16_t*/char DW_AT_encoding = 0x3e;
  public static final /*uint16_t*/char DW_AT_external = 0x3f;
  public static final /*uint16_t*/char DW_AT_frame_base = 0x40;
  public static final /*uint16_t*/char DW_AT_friend = 0x41;
  public static final /*uint16_t*/char DW_AT_identifier_case = 0x42;
  public static final /*uint16_t*/char DW_AT_macro_info = 0x43;
  public static final /*uint16_t*/char DW_AT_namelist_item = 0x44;
  public static final /*uint16_t*/char DW_AT_priority = 0x45;
  public static final /*uint16_t*/char DW_AT_segment = 0x46;
  public static final /*uint16_t*/char DW_AT_specification = 0x47;
  public static final /*uint16_t*/char DW_AT_static_link = 0x48;
  public static final /*uint16_t*/char DW_AT_type = 0x49;
  public static final /*uint16_t*/char DW_AT_use_location = 0x4a;
  public static final /*uint16_t*/char DW_AT_variable_parameter = 0x4b;
  public static final /*uint16_t*/char DW_AT_virtuality = 0x4c;
  public static final /*uint16_t*/char DW_AT_vtable_elem_location = 0x4d;
  public static final /*uint16_t*/char DW_AT_allocated = 0x4e;
  public static final /*uint16_t*/char DW_AT_associated = 0x4f;
  public static final /*uint16_t*/char DW_AT_data_location = 0x50;
  public static final /*uint16_t*/char DW_AT_byte_stride = 0x51;
  public static final /*uint16_t*/char DW_AT_entry_pc = 0x52;
  public static final /*uint16_t*/char DW_AT_use_UTF8 = 0x53;
  public static final /*uint16_t*/char DW_AT_extension = 0x54;
  public static final /*uint16_t*/char DW_AT_ranges = 0x55;
  public static final /*uint16_t*/char DW_AT_trampoline = 0x56;
  public static final /*uint16_t*/char DW_AT_call_column = 0x57;
  public static final /*uint16_t*/char DW_AT_call_file = 0x58;
  public static final /*uint16_t*/char DW_AT_call_line = 0x59;
  public static final /*uint16_t*/char DW_AT_description = 0x5a;
  public static final /*uint16_t*/char DW_AT_binary_scale = 0x5b;
  public static final /*uint16_t*/char DW_AT_decimal_scale = 0x5c;
  public static final /*uint16_t*/char DW_AT_small = 0x5d;
  public static final /*uint16_t*/char DW_AT_decimal_sign = 0x5e;
  public static final /*uint16_t*/char DW_AT_digit_count = 0x5f;
  public static final /*uint16_t*/char DW_AT_picture_string = 0x60;
  public static final /*uint16_t*/char DW_AT_mutable = 0x61;
  public static final /*uint16_t*/char DW_AT_threads_scaled = 0x62;
  public static final /*uint16_t*/char DW_AT_explicit = 0x63;
  public static final /*uint16_t*/char DW_AT_object_pointer = 0x64;
  public static final /*uint16_t*/char DW_AT_endianity = 0x65;
  public static final /*uint16_t*/char DW_AT_elemental = 0x66;
  public static final /*uint16_t*/char DW_AT_pure = 0x67;
  public static final /*uint16_t*/char DW_AT_recursive = 0x68;
  public static final /*uint16_t*/char DW_AT_signature = 0x69;
  public static final /*uint16_t*/char DW_AT_main_subprogram = 0x6a;
  public static final /*uint16_t*/char DW_AT_data_bit_offset = 0x6b;
  public static final /*uint16_t*/char DW_AT_const_expr = 0x6c;
  public static final /*uint16_t*/char DW_AT_enum_class = 0x6d;
  public static final /*uint16_t*/char DW_AT_linkage_name = 0x6e;
  
  // New in DWARF 5:
  public static final /*uint16_t*/char DW_AT_string_length_bit_size = 0x6f;
  public static final /*uint16_t*/char DW_AT_string_length_byte_size = 0x70;
  public static final /*uint16_t*/char DW_AT_rank = 0x71;
  public static final /*uint16_t*/char DW_AT_str_offsets_base = 0x72;
  public static final /*uint16_t*/char DW_AT_addr_base = 0x73;
  public static final /*uint16_t*/char DW_AT_ranges_base = 0x74;
  public static final /*uint16_t*/char DW_AT_dwo_id = 0x75;
  public static final /*uint16_t*/char DW_AT_dwo_name = 0x76;
  public static final /*uint16_t*/char DW_AT_reference = 0x77;
  public static final /*uint16_t*/char DW_AT_rvalue_reference = 0x78;
  public static final /*uint16_t*/char DW_AT_macros = 0x79;
  
  public static final /*uint16_t*/char DW_AT_lo_user = 0x2000;
  public static final /*uint16_t*/char DW_AT_hi_user = 0x3fff;
  
  public static final /*uint16_t*/char DW_AT_MIPS_loop_begin = 0x2002;
  public static final /*uint16_t*/char DW_AT_MIPS_tail_loop_begin = 0x2003;
  public static final /*uint16_t*/char DW_AT_MIPS_epilog_begin = 0x2004;
  public static final /*uint16_t*/char DW_AT_MIPS_loop_unroll_factor = 0x2005;
  public static final /*uint16_t*/char DW_AT_MIPS_software_pipeline_depth = 0x2006;
  public static final /*uint16_t*/char DW_AT_MIPS_linkage_name = 0x2007;
  public static final /*uint16_t*/char DW_AT_MIPS_stride = 0x2008;
  public static final /*uint16_t*/char DW_AT_MIPS_abstract_name = 0x2009;
  public static final /*uint16_t*/char DW_AT_MIPS_clone_origin = 0x200a;
  public static final /*uint16_t*/char DW_AT_MIPS_has_inlines = 0x200b;
  public static final /*uint16_t*/char DW_AT_MIPS_stride_byte = 0x200c;
  public static final /*uint16_t*/char DW_AT_MIPS_stride_elem = 0x200d;
  public static final /*uint16_t*/char DW_AT_MIPS_ptr_dopetype = 0x200e;
  public static final /*uint16_t*/char DW_AT_MIPS_allocatable_dopetype = 0x200f;
  public static final /*uint16_t*/char DW_AT_MIPS_assumed_shape_dopetype = 0x2010;
  
  // This one appears to have only been implemented by Open64 for
  // fortran and may conflict with other extensions.
  public static final /*uint16_t*/char DW_AT_MIPS_assumed_size = 0x2011;
  
  // GNU extensions
  public static final /*uint16_t*/char DW_AT_sf_names = 0x2101;
  public static final /*uint16_t*/char DW_AT_src_info = 0x2102;
  public static final /*uint16_t*/char DW_AT_mac_info = 0x2103;
  public static final /*uint16_t*/char DW_AT_src_coords = 0x2104;
  public static final /*uint16_t*/char DW_AT_body_begin = 0x2105;
  public static final /*uint16_t*/char DW_AT_body_end = 0x2106;
  public static final /*uint16_t*/char DW_AT_GNU_vector = 0x2107;
  public static final /*uint16_t*/char DW_AT_GNU_template_name = 0x2110;
  
  public static final /*uint16_t*/char DW_AT_GNU_odr_signature = 0x210f;
  public static final /*uint16_t*/char DW_AT_GNU_macros = 0x2119;
  
  // Extensions for Fission proposal.
  public static final /*uint16_t*/char DW_AT_GNU_dwo_name = 0x2130;
  public static final /*uint16_t*/char DW_AT_GNU_dwo_id = 0x2131;
  public static final /*uint16_t*/char DW_AT_GNU_ranges_base = 0x2132;
  public static final /*uint16_t*/char DW_AT_GNU_addr_base = 0x2133;
  public static final /*uint16_t*/char DW_AT_GNU_pubnames = 0x2134;
  public static final /*uint16_t*/char DW_AT_GNU_pubtypes = 0x2135;
  public static final /*uint16_t*/char DW_AT_GNU_discriminator = 0x2136;
  
  // Borland extensions.
  public static final /*uint16_t*/char DW_AT_BORLAND_property_read = 0x3b11;
  public static final /*uint16_t*/char DW_AT_BORLAND_property_write = 0x3b12;
  public static final /*uint16_t*/char DW_AT_BORLAND_property_implements = 0x3b13;
  public static final /*uint16_t*/char DW_AT_BORLAND_property_index = 0x3b14;
  public static final /*uint16_t*/char DW_AT_BORLAND_property_default = 0x3b15;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_unit = 0x3b20;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_class = 0x3b21;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_record = 0x3b22;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_metaclass = 0x3b23;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_constructor = 0x3b24;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_destructor = 0x3b25;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_anonymous_method = 0x3b26;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_interface = 0x3b27;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_ABI = 0x3b28;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_return = 0x3b29;
  public static final /*uint16_t*/char DW_AT_BORLAND_Delphi_frameptr = 0x3b30;
  public static final /*uint16_t*/char DW_AT_BORLAND_closure = 0x3b31;
  
  // LLVM project extensions.
  public static final /*uint16_t*/char DW_AT_LLVM_include_path = 0x3e00;
  public static final /*uint16_t*/char DW_AT_LLVM_config_macros = 0x3e01;
  public static final /*uint16_t*/char DW_AT_LLVM_isysroot = 0x3e02;
  
  // Apple extensions.
  public static final /*uint16_t*/char DW_AT_APPLE_optimized = 0x3fe1;
  public static final /*uint16_t*/char DW_AT_APPLE_flags = 0x3fe2;
  public static final /*uint16_t*/char DW_AT_APPLE_isa = 0x3fe3;
  public static final /*uint16_t*/char DW_AT_APPLE_block = 0x3fe4;
  public static final /*uint16_t*/char DW_AT_APPLE_major_runtime_vers = 0x3fe5;
  public static final /*uint16_t*/char DW_AT_APPLE_runtime_class = 0x3fe6;
  public static final /*uint16_t*/char DW_AT_APPLE_omit_frame_ptr = 0x3fe7;
  public static final /*uint16_t*/char DW_AT_APPLE_property_name = 0x3fe8;
  public static final /*uint16_t*/char DW_AT_APPLE_property_getter = 0x3fe9;
  public static final /*uint16_t*/char DW_AT_APPLE_property_setter = 0x3fea;
  public static final /*uint16_t*/char DW_AT_APPLE_property_attribute = 0x3feb;
  public static final /*uint16_t*/char DW_AT_APPLE_objc_complete_type = 0x3fec;
  public static final /*uint16_t*/char DW_AT_APPLE_property = 0x3fed;
}
