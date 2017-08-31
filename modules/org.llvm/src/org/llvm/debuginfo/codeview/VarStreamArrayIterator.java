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

/*template <typename ValueType, typename Extractor> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 107,
 FQN="llvm::codeview::VarStreamArrayIterator", NM="_ZN4llvm8codeview22VarStreamArrayIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorE")
//</editor-fold>
public class VarStreamArrayIterator</*typename*/ ValueType, /*typename*/ Extractor>  implements Destructors.ClassWithDestructor, Native.NativeComparable<VarStreamArrayIterator> {
  // JAVA: typedef VarStreamArrayIterator<ValueType, Extractor> IterType
//  public final class IterType extends VarStreamArrayIterator<ValueType, Extractor>{ };
  // JAVA: typedef VarStreamArray<ValueType, Extractor> ArrayType
//  public final class ArrayType extends VarStreamArray<ValueType, Extractor>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::VarStreamArrayIterator<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 112,
   FQN="llvm::codeview::VarStreamArrayIterator::VarStreamArrayIterator<ValueType, Extractor>", NM="_ZN4llvm8codeview22VarStreamArrayIteratorC1ERKNS0_14VarStreamArrayIT_T0_EERKS4_Pb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorC1ERKNS0_14VarStreamArrayIT_T0_EERKS4_Pb")
  //</editor-fold>
  public VarStreamArrayIterator(final /*const*/ VarStreamArray<ValueType, Extractor> /*&*/ Array, final /*const*/ Extractor /*&*/ E) {
    this(Array, E, 
      (bool$ptr/*bool P*/ )null);
  }
  public VarStreamArrayIterator(final /*const*/ VarStreamArray<ValueType, Extractor> /*&*/ Array, final /*const*/ Extractor /*&*/ E, 
      bool$ptr/*bool P*/ HadError/*= null*/) {
    // : IterRef(Array.Stream), Array(& Array), HadError(HadError), Extract(E) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::VarStreamArrayIterator<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 125,
   FQN="llvm::codeview::VarStreamArrayIterator::VarStreamArrayIterator<ValueType, Extractor>", NM="_ZN4llvm8codeview22VarStreamArrayIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorC1Ev")
  //</editor-fold>
  public VarStreamArrayIterator() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::VarStreamArrayIterator<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 126,
   FQN="llvm::codeview::VarStreamArrayIterator::VarStreamArrayIterator<ValueType, Extractor>", NM="_ZN4llvm8codeview22VarStreamArrayIteratorC1ERKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorC1ERKT0_")
  //</editor-fold>
  public /*explicit*/ VarStreamArrayIterator(final /*const*/ Extractor /*&*/ E) {
    // : Extract(E) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::~VarStreamArrayIterator<ValueType, Extractor>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 127,
   FQN="llvm::codeview::VarStreamArrayIterator::~VarStreamArrayIterator<ValueType, Extractor>", NM="_ZN4llvm8codeview22VarStreamArrayIteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 129,
   FQN="llvm::codeview::VarStreamArrayIterator::operator==", NM="_ZNK4llvm8codeview22VarStreamArrayIteratoreqERKNS0_22VarStreamArrayIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview22VarStreamArrayIteratoreqERKNS0_22VarStreamArrayIteratorIT_T0_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ VarStreamArrayIterator<ValueType, Extractor> /*&*/ R) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 144,
   FQN="llvm::codeview::VarStreamArrayIterator::operator!=", NM="_ZN4llvm8codeview22VarStreamArrayIteratorneERKNS0_22VarStreamArrayIteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorneERKNS0_22VarStreamArrayIteratorIT_T0_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ VarStreamArrayIterator<ValueType, Extractor> /*&*/ R) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 146,
   FQN="llvm::codeview::VarStreamArrayIterator::operator*", NM="_ZNK4llvm8codeview22VarStreamArrayIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview22VarStreamArrayIteratordeEv")
  //</editor-fold>
  public /*const*/ ValueType /*&*/ $star() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 151,
   FQN="llvm::codeview::VarStreamArrayIterator::operator++", NM="_ZN4llvm8codeview22VarStreamArrayIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorppEv")
  //</editor-fold>
  public VarStreamArrayIterator<ValueType, Extractor> /*&*/ $preInc() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 173,
   FQN="llvm::codeview::VarStreamArrayIterator::operator++", NM="_ZN4llvm8codeview22VarStreamArrayIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIteratorppEi")
  //</editor-fold>
  public VarStreamArrayIterator<ValueType, Extractor> $postInc(int $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::moveToEnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 180,
   FQN="llvm::codeview::VarStreamArrayIterator::moveToEnd", NM="_ZN4llvm8codeview22VarStreamArrayIterator9moveToEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIterator9moveToEndEv")
  //</editor-fold>
  private void moveToEnd() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::VarStreamArrayIterator::markError">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/StreamArray.h", line = 184,
   FQN="llvm::codeview::VarStreamArrayIterator::markError", NM="_ZN4llvm8codeview22VarStreamArrayIterator9markErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview22VarStreamArrayIterator9markErrorEv")
  //</editor-fold>
  private void markError() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private ValueType ThisValue;
  private StreamRef IterRef;
  private /*const*/ VarStreamArray<ValueType, Extractor> /*P*/ Array/* {null}*/;
  private /*uint32_t*/int ThisLen/* {0}*/;
  private boolean HasError/* {false}*/;
  private bool$ptr/*bool P*/ HadError/* {null}*/;
  private Extractor Extract;
  
  @Override public String toString() {
    return "" + "ThisValue=" + ThisValue // NOI18N
              + ", IterRef=" + IterRef // NOI18N
              + ", Array=" + Array // NOI18N
              + ", ThisLen=" + ThisLen // NOI18N
              + ", HasError=" + HasError // NOI18N
              + ", HadError=" + HadError // NOI18N
              + ", Extract=" + Extract; // NOI18N
  }
}
