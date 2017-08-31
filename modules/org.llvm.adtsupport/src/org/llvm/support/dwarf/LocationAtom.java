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

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::LocationAtom">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 323,
 FQN="llvm::dwarf::LocationAtom", NM="_ZN4llvm5dwarf12LocationAtomE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf12LocationAtomE")
//</editor-fold>
public final class/*enum*/ LocationAtom {
  public static final /*uint*/int DW_OP_addr = 0x3;
  public static final /*uint*/int DW_OP_deref = 0x6;
  public static final /*uint*/int DW_OP_const1u = 0x8;
  public static final /*uint*/int DW_OP_const1s = 0x9;
  public static final /*uint*/int DW_OP_const2u = 0xA;
  public static final /*uint*/int DW_OP_const2s = 0xB;
  public static final /*uint*/int DW_OP_const4u = 0xC;
  public static final /*uint*/int DW_OP_const4s = 0xD;
  public static final /*uint*/int DW_OP_const8u = 0xE;
  public static final /*uint*/int DW_OP_const8s = 0xF;
  public static final /*uint*/int DW_OP_constu = 0x10;
  public static final /*uint*/int DW_OP_consts = 0x11;
  public static final /*uint*/int DW_OP_dup = 0x12;
  public static final /*uint*/int DW_OP_drop = 0x13;
  public static final /*uint*/int DW_OP_over = 0x14;
  public static final /*uint*/int DW_OP_pick = 0x15;
  public static final /*uint*/int DW_OP_swap = 0x16;
  public static final /*uint*/int DW_OP_rot = 0x17;
  public static final /*uint*/int DW_OP_xderef = 0x18;
  public static final /*uint*/int DW_OP_abs = 0x19;
  public static final /*uint*/int DW_OP_and = 0x1A;
  public static final /*uint*/int DW_OP_div = 0x1B;
  public static final /*uint*/int DW_OP_minus = 0x1C;
  public static final /*uint*/int DW_OP_mod = 0x1D;
  public static final /*uint*/int DW_OP_mul = 0x1E;
  public static final /*uint*/int DW_OP_neg = 0x1F;
  public static final /*uint*/int DW_OP_not = 0x20;
  public static final /*uint*/int DW_OP_or = 0x21;
  public static final /*uint*/int DW_OP_plus = 0x22;
  public static final /*uint*/int DW_OP_plus_uconst = 0x23;
  public static final /*uint*/int DW_OP_shl = 0x24;
  public static final /*uint*/int DW_OP_shr = 0x25;
  public static final /*uint*/int DW_OP_shra = 0x26;
  public static final /*uint*/int DW_OP_xor = 0x27;
  public static final /*uint*/int DW_OP_skip = 0x2F;
  public static final /*uint*/int DW_OP_bra = 0x28;
  public static final /*uint*/int DW_OP_eq = 0x29;
  public static final /*uint*/int DW_OP_ge = 0x2A;
  public static final /*uint*/int DW_OP_gt = 0x2B;
  public static final /*uint*/int DW_OP_le = 0x2C;
  public static final /*uint*/int DW_OP_lt = 0x2D;
  public static final /*uint*/int DW_OP_ne = 0x2E;
  public static final /*uint*/int DW_OP_lit0 = 0x30;
  public static final /*uint*/int DW_OP_lit1 = 0x31;
  public static final /*uint*/int DW_OP_lit2 = 0x32;
  public static final /*uint*/int DW_OP_lit3 = 0x33;
  public static final /*uint*/int DW_OP_lit4 = 0x34;
  public static final /*uint*/int DW_OP_lit5 = 0x35;
  public static final /*uint*/int DW_OP_lit6 = 0x36;
  public static final /*uint*/int DW_OP_lit7 = 0x37;
  public static final /*uint*/int DW_OP_lit8 = 0x38;
  public static final /*uint*/int DW_OP_lit9 = 0x39;
  public static final /*uint*/int DW_OP_lit10 = 0x3A;
  public static final /*uint*/int DW_OP_lit11 = 0x3B;
  public static final /*uint*/int DW_OP_lit12 = 0x3C;
  public static final /*uint*/int DW_OP_lit13 = 0x3D;
  public static final /*uint*/int DW_OP_lit14 = 0x3E;
  public static final /*uint*/int DW_OP_lit15 = 0x3F;
  public static final /*uint*/int DW_OP_lit16 = 0x40;
  public static final /*uint*/int DW_OP_lit17 = 0x41;
  public static final /*uint*/int DW_OP_lit18 = 0x42;
  public static final /*uint*/int DW_OP_lit19 = 0x43;
  public static final /*uint*/int DW_OP_lit20 = 0x44;
  public static final /*uint*/int DW_OP_lit21 = 0x45;
  public static final /*uint*/int DW_OP_lit22 = 0x46;
  public static final /*uint*/int DW_OP_lit23 = 0x47;
  public static final /*uint*/int DW_OP_lit24 = 0x48;
  public static final /*uint*/int DW_OP_lit25 = 0x49;
  public static final /*uint*/int DW_OP_lit26 = 0x4A;
  public static final /*uint*/int DW_OP_lit27 = 0x4B;
  public static final /*uint*/int DW_OP_lit28 = 0x4C;
  public static final /*uint*/int DW_OP_lit29 = 0x4D;
  public static final /*uint*/int DW_OP_lit30 = 0x4E;
  public static final /*uint*/int DW_OP_lit31 = 0x4F;
  public static final /*uint*/int DW_OP_reg0 = 0x50;
  public static final /*uint*/int DW_OP_reg1 = 0x51;
  public static final /*uint*/int DW_OP_reg2 = 0x52;
  public static final /*uint*/int DW_OP_reg3 = 0x53;
  public static final /*uint*/int DW_OP_reg4 = 0x54;
  public static final /*uint*/int DW_OP_reg5 = 0x55;
  public static final /*uint*/int DW_OP_reg6 = 0x56;
  public static final /*uint*/int DW_OP_reg7 = 0x57;
  public static final /*uint*/int DW_OP_reg8 = 0x58;
  public static final /*uint*/int DW_OP_reg9 = 0x59;
  public static final /*uint*/int DW_OP_reg10 = 0x5A;
  public static final /*uint*/int DW_OP_reg11 = 0x5B;
  public static final /*uint*/int DW_OP_reg12 = 0x5C;
  public static final /*uint*/int DW_OP_reg13 = 0x5D;
  public static final /*uint*/int DW_OP_reg14 = 0x5E;
  public static final /*uint*/int DW_OP_reg15 = 0x5F;
  public static final /*uint*/int DW_OP_reg16 = 0x60;
  public static final /*uint*/int DW_OP_reg17 = 0x61;
  public static final /*uint*/int DW_OP_reg18 = 0x62;
  public static final /*uint*/int DW_OP_reg19 = 0x63;
  public static final /*uint*/int DW_OP_reg20 = 0x64;
  public static final /*uint*/int DW_OP_reg21 = 0x65;
  public static final /*uint*/int DW_OP_reg22 = 0x66;
  public static final /*uint*/int DW_OP_reg23 = 0x67;
  public static final /*uint*/int DW_OP_reg24 = 0x68;
  public static final /*uint*/int DW_OP_reg25 = 0x69;
  public static final /*uint*/int DW_OP_reg26 = 0x6A;
  public static final /*uint*/int DW_OP_reg27 = 0x6B;
  public static final /*uint*/int DW_OP_reg28 = 0x6C;
  public static final /*uint*/int DW_OP_reg29 = 0x6D;
  public static final /*uint*/int DW_OP_reg30 = 0x6E;
  public static final /*uint*/int DW_OP_reg31 = 0x6F;
  public static final /*uint*/int DW_OP_breg0 = 0x70;
  public static final /*uint*/int DW_OP_breg1 = 0x71;
  public static final /*uint*/int DW_OP_breg2 = 0x72;
  public static final /*uint*/int DW_OP_breg3 = 0x73;
  public static final /*uint*/int DW_OP_breg4 = 0x74;
  public static final /*uint*/int DW_OP_breg5 = 0x75;
  public static final /*uint*/int DW_OP_breg6 = 0x76;
  public static final /*uint*/int DW_OP_breg7 = 0x77;
  public static final /*uint*/int DW_OP_breg8 = 0x78;
  public static final /*uint*/int DW_OP_breg9 = 0x79;
  public static final /*uint*/int DW_OP_breg10 = 0x7A;
  public static final /*uint*/int DW_OP_breg11 = 0x7B;
  public static final /*uint*/int DW_OP_breg12 = 0x7C;
  public static final /*uint*/int DW_OP_breg13 = 0x7D;
  public static final /*uint*/int DW_OP_breg14 = 0x7E;
  public static final /*uint*/int DW_OP_breg15 = 0x7F;
  public static final /*uint*/int DW_OP_breg16 = 0x80;
  public static final /*uint*/int DW_OP_breg17 = 0x81;
  public static final /*uint*/int DW_OP_breg18 = 0x82;
  public static final /*uint*/int DW_OP_breg19 = 0x83;
  public static final /*uint*/int DW_OP_breg20 = 0x84;
  public static final /*uint*/int DW_OP_breg21 = 0x85;
  public static final /*uint*/int DW_OP_breg22 = 0x86;
  public static final /*uint*/int DW_OP_breg23 = 0x87;
  public static final /*uint*/int DW_OP_breg24 = 0x88;
  public static final /*uint*/int DW_OP_breg25 = 0x89;
  public static final /*uint*/int DW_OP_breg26 = 0x8A;
  public static final /*uint*/int DW_OP_breg27 = 0x8B;
  public static final /*uint*/int DW_OP_breg28 = 0x8C;
  public static final /*uint*/int DW_OP_breg29 = 0x8D;
  public static final /*uint*/int DW_OP_breg30 = 0x8E;
  public static final /*uint*/int DW_OP_breg31 = 0x8F;
  public static final /*uint*/int DW_OP_regx = 0x90;
  public static final /*uint*/int DW_OP_fbreg = 0x91;
  public static final /*uint*/int DW_OP_bregx = 0x92;
  public static final /*uint*/int DW_OP_piece = 0x93;
  public static final /*uint*/int DW_OP_deref_size = 0x94;
  public static final /*uint*/int DW_OP_xderef_size = 0x95;
  public static final /*uint*/int DW_OP_nop = 0x96;
  public static final /*uint*/int DW_OP_push_object_address = 0x97;
  public static final /*uint*/int DW_OP_call2 = 0x98;
  public static final /*uint*/int DW_OP_call4 = 0x99;
  public static final /*uint*/int DW_OP_call_ref = 0x9A;
  public static final /*uint*/int DW_OP_form_tls_address = 0x9B;
  public static final /*uint*/int DW_OP_call_frame_cfa = 0x9C;
  public static final /*uint*/int DW_OP_bit_piece = 0x9D;
  public static final /*uint*/int DW_OP_implicit_value = 0x9E;
  public static final /*uint*/int DW_OP_stack_value = 0x9F;
  
  // Extensions for GNU-style thread-local storage.
  public static final /*uint*/int DW_OP_GNU_push_tls_address = 0xE0;
  
  // Extensions for Fission proposal.
  public static final /*uint*/int DW_OP_GNU_addr_index = 0xFB;
  public static final /*uint*/int DW_OP_GNU_const_index = 0xFC;
  public static final /*uint*/int DW_OP_lo_user = 0xe0;
  public static final /*uint*/int DW_OP_hi_user = 0xff;
}
