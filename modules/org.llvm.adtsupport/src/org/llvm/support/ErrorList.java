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

package org.llvm.support;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.impl.*;


/// Special ErrorInfo subclass representing a list of ErrorInfos.
/// Instances of this class are constructed by joinError.
//<editor-fold defaultstate="collapsed" desc="llvm::ErrorList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 307,
 FQN="llvm::ErrorList", NM="_ZN4llvm9ErrorListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm9ErrorListE")
//</editor-fold>
public final class ErrorList extends /*public*/ ErrorInfo<ErrorList> implements Destructors.ClassWithDestructor {
  
  // handleErrors needs to be able to iterate the payload list of an
  // ErrorList.
  /*friend template <typename ... HandlerTs> Error handleErrors(Error E, HandlerTs &&Handlers...)*/
  
  // joinErrors is implemented in terms of join.
  /*friend Error joinErrors(Error, Error)*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorList::log">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 318,
   FQN="llvm::ErrorList::log", NM="_ZNK4llvm9ErrorList3logERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm9ErrorList3logERNS_11raw_ostreamE")
  //</editor-fold>
  @Override public void log(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    OS.$out(/*KEEP_STR*/"Multiple errors:\n");
    for (final /*constconst*/unique_ptr<ErrorInfoBase> /*&*/ ErrPayload : Payloads) {
      ErrPayload.$arrow().log(OS);
      OS.$out(/*KEEP_STR*/$LF);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorList::convertToErrorCode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/Error.cpp", line = 68,
   FQN="llvm::ErrorList::convertToErrorCode", NM="_ZNK4llvm9ErrorList18convertToErrorCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZNK4llvm9ErrorList18convertToErrorCodeEv")
  //</editor-fold>
  @Override public std.error_code convertToErrorCode() /*const*//* override*/ {
    return new std.error_code(((/*static_cast*/int)ErrorErrorCode.MultipleErrors.getValue()), 
        ErrorStatics.ErrorErrorCat.$star());
  }

  
  // Used by ErrorInfo::classID.
  public static /*char*/byte ID = 0;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorList::ErrorList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 332,
   FQN="llvm::ErrorList::ErrorList", NM="_ZN4llvm9ErrorListC1ESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS2_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm9ErrorListC1ESt10unique_ptrINS_13ErrorInfoBaseESt14default_deleteIS2_EES5_")
  //</editor-fold>
  private ErrorList(std.unique_ptr<ErrorInfoBase> Payload1, 
      std.unique_ptr<ErrorInfoBase> Payload2) {
    // : ErrorInfo<ErrorList>(), Payloads() 
    //START JInit
    super();
    this.Payloads = new std.vector<std.unique_ptr<ErrorInfoBase>>(new std.unique_ptr<ErrorInfoBase>());
    //END JInit
    assert (!Payload1.$arrow().<ErrorList>isA() && !Payload2.$arrow().<ErrorList>isA()) : "ErrorList constructor payloads should be singleton errors";
    Payloads.push_back_T$RR(std.move(Payload1));
    Payloads.push_back_T$RR(std.move(Payload2));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorList::join">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 340,
   FQN="llvm::ErrorList::join", NM="_ZN4llvm9ErrorList4joinENS_5ErrorES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm9ErrorList4joinENS_5ErrorES1_")
  //</editor-fold>
  private static Error join(Error E1, Error E2) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!E1.$bool()) {
        return new Error(JD$Move.INSTANCE, E2);
      }
      if (!E2.$bool()) {
        return new Error(JD$Move.INSTANCE, E1);
      }
      if (E1.<ErrorList>isA(ErrorList.class)) {
        final ErrorList /*&*/ E1List = ((/*static_cast*/ErrorList /*&*/ )($Deref(E1.getPtr())));
        if (E2.<ErrorList>isA(ErrorList.class)) {
          unique_ptr<ErrorInfoBase> E2Payload = null;
          try {
            E2Payload = E2.takePayload();
            final ErrorList /*&*/ E2List = ((/*static_cast*/ErrorList /*&*/ )(E2Payload.$star()));
            for (final unique_ptr<ErrorInfoBase> /*&*/ Payload : E2List.Payloads)  {
              E1List.Payloads.push_back_T$RR(std.move(Payload));
            }
          } finally {
            if (E2Payload != null) { E2Payload.$destroy(); }
          }
        } else {
          E1List.Payloads.push_back_T$RR($c$.track(E2.takePayload())); $c$.clean();
        }
        
        return new Error(JD$Move.INSTANCE, E1);
      }
      if (E2.<ErrorList>isA(ErrorList.class)) {
        final ErrorList /*&*/ E2List = ((/*static_cast*/ErrorList /*&*/ )($Deref(E2.getPtr())));
        $c$.clean(E2List.Payloads.insert(new std.vector.iterator</*const*/unique_ptr<ErrorInfoBase> /*P*/>(E2List.Payloads.begin()), $c$.track(E1.takePayload())));
        return new Error(JD$Move.INSTANCE, E2);
      }
      return $c$.clean(new Error($c$.track(new std.unique_ptr<ErrorInfoBase>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(new std.unique_ptr<ErrorList>(new ErrorList($c$.track(E1.takePayload()), $c$.track(E2.takePayload()))))))));
    } finally {
      $c$.$destroy();
    }
  }

  
  private std.vector<std.unique_ptr<ErrorInfoBase>> Payloads;
  //<editor-fold defaultstate="collapsed" desc="llvm::ErrorList::~ErrorList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Error.h", line = 307,
   FQN="llvm::ErrorList::~ErrorList", NM="_ZN4llvm9ErrorListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Error.cpp -nm=_ZN4llvm9ErrorListD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Payloads.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Payloads=" + Payloads // NOI18N
              + super.toString(); // NOI18N
  }
}
