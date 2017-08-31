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

//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::Constants">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 508,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", old_line = 517,
 FQN="llvm::dwarf::Constants", NM="_ZN4llvm5dwarf9ConstantsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf9ConstantsE")
//</editor-fold>
public final class/*enum*/ Constants {
  // Children flag
  public static final /*uint*/int DW_CHILDREN_no = 0x00;
  public static final /*uint*/int DW_CHILDREN_yes = 0x01;
  
  public static final /*uint*/int DW_EH_PE_absptr = 0x00;
  public static final /*uint*/int DW_EH_PE_omit = 0xff;
  public static final /*uint*/int DW_EH_PE_uleb128 = 0x01;
  public static final /*uint*/int DW_EH_PE_udata2 = 0x02;
  public static final /*uint*/int DW_EH_PE_udata4 = 0x03;
  public static final /*uint*/int DW_EH_PE_udata8 = 0x04;
  public static final /*uint*/int DW_EH_PE_sleb128 = 0x09;
  public static final /*uint*/int DW_EH_PE_sdata2 = 0x0A;
  public static final /*uint*/int DW_EH_PE_sdata4 = 0x0B;
  public static final /*uint*/int DW_EH_PE_sdata8 = 0x0C;
  public static final /*uint*/int DW_EH_PE_signed = 0x08;
  public static final /*uint*/int DW_EH_PE_pcrel = 0x10;
  public static final /*uint*/int DW_EH_PE_textrel = 0x20;
  public static final /*uint*/int DW_EH_PE_datarel = 0x30;
  public static final /*uint*/int DW_EH_PE_funcrel = 0x40;
  public static final /*uint*/int DW_EH_PE_aligned = 0x50;
  public static final /*uint*/int DW_EH_PE_indirect = 0x80;
}
