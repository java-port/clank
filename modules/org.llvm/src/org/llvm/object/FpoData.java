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

package org.llvm.object;

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


// Corresponds to `_FPO_DATA` structure in the PE/COFF spec.
//<editor-fold defaultstate="collapsed" desc="llvm::object::FpoData">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 1015,
 FQN="llvm::object::FpoData", NM="_ZN4llvm6object7FpoDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm6object7FpoDataE")
//</editor-fold>
public class/*struct*/ FpoData {
  public llvm.support.ulittle32_t Offset; // ulOffStart: Offset 1st byte of function code
  public llvm.support.ulittle32_t Size; // cbProcSize: # bytes in function
  public llvm.support.ulittle32_t NumLocals; // cdwLocals: # bytes in locals/4
  public llvm.support.ulittle16_t NumParams; // cdwParams: # bytes in params/4
  public llvm.support.ulittle16_t Attributes;
  
  // cbProlog: # bytes in prolog
  //<editor-fold defaultstate="collapsed" desc="llvm::object::FpoData::getPrologSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 1023,
   FQN="llvm::object::FpoData::getPrologSize", NM="_ZNK4llvm6object7FpoData13getPrologSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object7FpoData13getPrologSizeEv")
  //</editor-fold>
  public int getPrologSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // cbRegs: # regs saved
  //<editor-fold defaultstate="collapsed" desc="llvm::object::FpoData::getNumSavedRegs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 1026,
   FQN="llvm::object::FpoData::getNumSavedRegs", NM="_ZNK4llvm6object7FpoData15getNumSavedRegsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object7FpoData15getNumSavedRegsEv")
  //</editor-fold>
  public int getNumSavedRegs() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // fHasSEH: true if seh is func
  //<editor-fold defaultstate="collapsed" desc="llvm::object::FpoData::hasSEH">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 1029,
   FQN="llvm::object::FpoData::hasSEH", NM="_ZNK4llvm6object7FpoData6hasSEHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object7FpoData6hasSEHEv")
  //</editor-fold>
  public boolean hasSEH() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // fUseBP: true if EBP has been allocated
  //<editor-fold defaultstate="collapsed" desc="llvm::object::FpoData::useBP">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 1032,
   FQN="llvm::object::FpoData::useBP", NM="_ZNK4llvm6object7FpoData5useBPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object7FpoData5useBPEv")
  //</editor-fold>
  public boolean useBP() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // cbFrame: frame pointer
  //<editor-fold defaultstate="collapsed" desc="llvm::object::FpoData::getFP">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Object/COFF.h", line = 1035,
   FQN="llvm::object::FpoData::getFP", NM="_ZNK4llvm6object7FpoData5getFPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm6object7FpoData5getFPEv")
  //</editor-fold>
  public int getFP() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Offset=" + Offset // NOI18N
              + ", Size=" + Size // NOI18N
              + ", NumLocals=" + NumLocals // NOI18N
              + ", NumParams=" + NumParams // NOI18N
              + ", Attributes=" + Attributes; // NOI18N
  }
}
