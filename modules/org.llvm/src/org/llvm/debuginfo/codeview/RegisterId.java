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

package org.llvm.debuginfo.codeview;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


// Corresponds to CV_HREG_e enum.
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::RegisterId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 476,
 FQN="llvm::codeview::RegisterId", NM="_ZN4llvm8codeview10RegisterIdE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview10RegisterIdE")
//</editor-fold>
public enum /*class */RegisterId/* : uint16_t*/ implements Native.NativeUShortEnum {
  Unknown($int2ushort(0)),
  VFrame($int2ushort(30006)),
  AL($int2ushort(1)),
  CL($int2ushort(2)),
  DL($int2ushort(3)),
  BL($int2ushort(4)),
  AH($int2ushort(5)),
  CH($int2ushort(6)),
  DH($int2ushort(7)),
  BH($int2ushort(8)),
  AX($int2ushort(9)),
  CX($int2ushort(10)),
  DX($int2ushort(11)),
  BX($int2ushort(12)),
  SP($int2ushort(13)),
  BP($int2ushort(14)),
  SI($int2ushort(15)),
  DI($int2ushort(16)),
  EAX($int2ushort(17)),
  ECX($int2ushort(18)),
  EDX($int2ushort(19)),
  EBX($int2ushort(20)),
  ESP($int2ushort(21)),
  EBP($int2ushort(22)),
  ESI($int2ushort(23)),
  EDI($int2ushort(24)),
  ES($int2ushort(25)),
  CS($int2ushort(26)),
  SS($int2ushort(27)),
  DS($int2ushort(28)),
  FS($int2ushort(29)),
  GS($int2ushort(30)),
  IP($int2ushort(31)),
  RAX($int2ushort(328)),
  RBX($int2ushort(329)),
  RCX($int2ushort(330)),
  RDX($int2ushort(331)),
  RSI($int2ushort(332)),
  RDI($int2ushort(333)),
  RBP($int2ushort(334)),
  RSP($int2ushort(335)),
  R8($int2ushort(336)),
  R9($int2ushort(337)),
  R10($int2ushort(338)),
  R11($int2ushort(339)),
  R12($int2ushort(340)),
  R13($int2ushort(341)),
  R14($int2ushort(342)),
  R15($int2ushort(343));

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static RegisterId valueOf(/*uint16_t*/char val) {
    RegisterId out = valueOf((int)val);
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
    return out;
  }
  public static RegisterId valueOf(int val) {
    RegisterId out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final RegisterId[] VALUES;
    private static final RegisterId[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (RegisterId kind : RegisterId.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new RegisterId[min < 0 ? (1-min) : 0];
      VALUES = new RegisterId[max >= 0 ? (1+max) : 0];
      for (RegisterId kind : RegisterId.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint16_t*/char value;
  private RegisterId(int val) { this.value = (/*uint16_t*/char)val;}
  @Override public final /*uint16_t*/char getValue() { return value;}
  //</editor-fold>
}
