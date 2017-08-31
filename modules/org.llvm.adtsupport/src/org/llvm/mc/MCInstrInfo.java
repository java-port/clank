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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.mc.*;


//---------------------------------------------------------------------------
///
/// MCInstrInfo - Interface to description of machine instruction set
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCInstrInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", line = 24,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", old_line = 26,
 FQN = "llvm::MCInstrInfo", NM = "_ZN4llvm11MCInstrInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm11MCInstrInfoE")
//</editor-fold>
public class MCInstrInfo {
  private /*const*/MCInstrDesc /*P*/ Desc; // Raw array to allow static init'n
  private /*const*/uint$ptr/*uint P*/ InstrNameIndices; // Array for name indices in InstrNameData
  private /*const*/char$ptr/*char P*/ InstrNameData; // Instruction name string pool
  private /*uint*/int NumOpcodes; // Number of entries in the desc array
/*public:*/
  /// InitMCInstrInfo - Initialize MCInstrInfo, called by TableGen
  /// auto-generated routines. *DO NOT USE*.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrInfo::InitMCInstrInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", line = 33,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", old_line = 35,
   FQN = "llvm::MCInstrInfo::InitMCInstrInfo", NM = "_ZN4llvm11MCInstrInfo15InitMCInstrInfoEPKNS_11MCInstrDescEPKjPKcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm11MCInstrInfo15InitMCInstrInfoEPKNS_11MCInstrDescEPKjPKcj")
  //</editor-fold>
  public void InitMCInstrInfo(/*const*/MCInstrDesc /*P*/ D, /*const*/uint$ptr/*uint P*/ NI, /*const*/char$ptr/*char P*/ ND, /*uint*/int NO) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrInfo::getNumOpcodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", old_line = 43,
   FQN = "llvm::MCInstrInfo::getNumOpcodes", NM = "_ZNK4llvm11MCInstrInfo13getNumOpcodesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm11MCInstrInfo13getNumOpcodesEv")
  //</editor-fold>
  public /*uint*/int getNumOpcodes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// get - Return the machine instruction descriptor that corresponds to the
  /// specified instruction opcode.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrInfo::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", line = 45,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", old_line = 48,
   FQN = "llvm::MCInstrInfo::get", NM = "_ZNK4llvm11MCInstrInfo3getEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm11MCInstrInfo3getEj")
  //</editor-fold>
  public /*const*/MCInstrDesc /*&*/ get(/*uint*/int Opcode) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getName - Returns the name for the instructions with the given opcode.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstrInfo::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", line = 51,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrInfo.h", old_line = 54,
   FQN = "llvm::MCInstrInfo::getName", NM = "_ZNK4llvm11MCInstrInfo7getNameEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm11MCInstrInfo7getNameEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName(/*uint*/int Opcode) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
