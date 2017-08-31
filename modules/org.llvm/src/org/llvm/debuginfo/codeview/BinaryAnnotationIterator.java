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

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 257,
 FQN="llvm::codeview::BinaryAnnotationIterator", NM="_ZN4llvm8codeview24BinaryAnnotationIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratorE")
//</editor-fold>
public class/*struct*/ BinaryAnnotationIterator implements Destructors.ClassWithDestructor, Native.NativeComparable<BinaryAnnotationIterator> {
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::AnnotationData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 258,
   FQN="llvm::codeview::BinaryAnnotationIterator::AnnotationData", NM="_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataE")
  //</editor-fold>
  public static class/*struct*/ AnnotationData {
    public BinaryAnnotationsOpCode OpCode;
    public StringRef Name;
    public /*uint32_t*/int U1;
    public /*uint32_t*/int U2;
    public int/*int32_t*/ S1;
    //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::AnnotationData::AnnotationData">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 258,
     FQN="llvm::codeview::BinaryAnnotationIterator::AnnotationData::AnnotationData", NM="_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataC1Ev")
    //</editor-fold>
    public /*inline*/ AnnotationData() {
      // : Name() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::AnnotationData::AnnotationData">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 258,
     FQN="llvm::codeview::BinaryAnnotationIterator::AnnotationData::AnnotationData", NM="_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataC1ERKS2_")
    //</editor-fold>
    public /*inline*/ AnnotationData(final /*const*/ AnnotationData /*&*/ $Prm0) {
      // : OpCode(.OpCode), Name(.Name), U1(.U1), U2(.U2), S1(.S1) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::AnnotationData::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 258,
     FQN="llvm::codeview::BinaryAnnotationIterator::AnnotationData::operator=", NM="_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator14AnnotationDataaSERKS2_")
    //</editor-fold>
    public /*inline*/ AnnotationData /*&*/ $assign(final /*const*/ AnnotationData /*&*/ $Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "OpCode=" + OpCode // NOI18N
                + ", Name=" + Name // NOI18N
                + ", U1=" + U1 // NOI18N
                + ", U2=" + U2 // NOI18N
                + ", S1=" + S1; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::BinaryAnnotationIterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 266,
   FQN="llvm::codeview::BinaryAnnotationIterator::BinaryAnnotationIterator", NM="_ZN4llvm8codeview24BinaryAnnotationIteratorC1ENS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratorC1ENS_8ArrayRefIhEE")
  //</editor-fold>
  public BinaryAnnotationIterator(ArrayRefUChar Annotations) {
    // : Current(), Data(Annotations), Next() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::BinaryAnnotationIterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 267,
   FQN="llvm::codeview::BinaryAnnotationIterator::BinaryAnnotationIterator", NM="_ZN4llvm8codeview24BinaryAnnotationIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratorC1Ev")
  //</editor-fold>
  public BinaryAnnotationIterator() {
    // : Current(), Data(), Next() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::BinaryAnnotationIterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 268,
   FQN="llvm::codeview::BinaryAnnotationIterator::BinaryAnnotationIterator", NM="_ZN4llvm8codeview24BinaryAnnotationIteratorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratorC1ERKS1_")
  //</editor-fold>
  public BinaryAnnotationIterator(final /*const*/ BinaryAnnotationIterator /*&*/ Other) {
    // : Current(), Data(Other.Data), Next() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 271,
   FQN="llvm::codeview::BinaryAnnotationIterator::operator==", NM="_ZNK4llvm8codeview24BinaryAnnotationIteratoreqES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview24BinaryAnnotationIteratoreqES1_")
  //</editor-fold>
  public boolean $eq(BinaryAnnotationIterator Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 275,
   FQN="llvm::codeview::BinaryAnnotationIterator::operator!=", NM="_ZNK4llvm8codeview24BinaryAnnotationIteratorneES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview24BinaryAnnotationIteratorneES1_")
  //</editor-fold>
  public boolean $noteq(BinaryAnnotationIterator Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 279,
   FQN="llvm::codeview::BinaryAnnotationIterator::operator=", NM="_ZN4llvm8codeview24BinaryAnnotationIteratoraSES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratoraSES1_")
  //</editor-fold>
  public BinaryAnnotationIterator /*&*/ $assign(/*const*/ BinaryAnnotationIterator Other) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 284,
   FQN="llvm::codeview::BinaryAnnotationIterator::operator++", NM="_ZN4llvm8codeview24BinaryAnnotationIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratorppEv")
  //</editor-fold>
  public BinaryAnnotationIterator /*&*/ $preInc() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 295,
   FQN="llvm::codeview::BinaryAnnotationIterator::operator++", NM="_ZN4llvm8codeview24BinaryAnnotationIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratorppEi")
  //</editor-fold>
  public BinaryAnnotationIterator $postInc(int $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 301,
   FQN="llvm::codeview::BinaryAnnotationIterator::operator*", NM="_ZN4llvm8codeview24BinaryAnnotationIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratordeEv")
  //</editor-fold>
  public /*const*/ AnnotationData /*&*/ $star() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::GetCompressedAnnotation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 307,
   FQN="llvm::codeview::BinaryAnnotationIterator::GetCompressedAnnotation", NM="_ZN4llvm8codeview24BinaryAnnotationIterator23GetCompressedAnnotationERNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator23GetCompressedAnnotationERNS_8ArrayRefIhEE")
  //</editor-fold>
  private static /*uint32_t*/int GetCompressedAnnotation(final ArrayRefUChar/*&*/ Annotations) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::DecodeSignedOperand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 345,
   FQN="llvm::codeview::BinaryAnnotationIterator::DecodeSignedOperand", NM="_ZN4llvm8codeview24BinaryAnnotationIterator19DecodeSignedOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator19DecodeSignedOperandEj")
  //</editor-fold>
  private static int/*int32_t*/ DecodeSignedOperand(/*uint32_t*/int Operand) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::DecodeSignedOperand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 351,
   FQN="llvm::codeview::BinaryAnnotationIterator::DecodeSignedOperand", NM="_ZN4llvm8codeview24BinaryAnnotationIterator19DecodeSignedOperandERNS_8ArrayRefIhEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator19DecodeSignedOperandERNS_8ArrayRefIhEE")
  //</editor-fold>
  private static int/*int32_t*/ DecodeSignedOperand(final ArrayRefUChar/*&*/ Annotations) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::ParseCurrentAnnotation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 355,
   FQN="llvm::codeview::BinaryAnnotationIterator::ParseCurrentAnnotation", NM="_ZN4llvm8codeview24BinaryAnnotationIterator22ParseCurrentAnnotationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIterator22ParseCurrentAnnotationEv")
  //</editor-fold>
  private boolean ParseCurrentAnnotation() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private Optional<AnnotationData> Current;
  private ArrayRefUChar Data;
  private ArrayRefUChar Next;
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::BinaryAnnotationIterator::~BinaryAnnotationIterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 257,
   FQN="llvm::codeview::BinaryAnnotationIterator::~BinaryAnnotationIterator", NM="_ZN4llvm8codeview24BinaryAnnotationIteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview24BinaryAnnotationIteratorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Current=" + Current // NOI18N
              + ", Data=" + Data // NOI18N
              + ", Next=" + Next; // NOI18N
  }
}
