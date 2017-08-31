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

package org.clang.analysis.domainspecific;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.analysis.impl.ObjCNoReturnStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::ObjCNoReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/DomainSpecific/ObjCNoReturn.h", line = 25,
 FQN="clang::ObjCNoReturn", NM="_ZN5clang12ObjCNoReturnE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ObjCNoReturn.cpp -nm=_ZN5clang12ObjCNoReturnE")
//</editor-fold>
public class ObjCNoReturn {
  /// Cached "raise" selector.
  private Selector RaiseSel;
  
  /// Cached identifier for "NSException".
  private IdentifierInfo /*P*/ NSExceptionII;
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCNoReturn::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/DomainSpecific/ObjCNoReturn.h", line = 32,
   FQN="clang::ObjCNoReturn::(anonymous)", NM="_ZN5clang12ObjCNoReturnE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ObjCNoReturn.cpp -nm=_ZN5clang12ObjCNoReturnE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NUM_RAISE_SELECTORS = 2;
  /*}*/;
  
  /// Cached set of selectors in NSException that are 'noreturn'.
  private Selector NSExceptionInstanceRaiseSelectors[/*2*/] = new Selector [2];
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCNoReturn::ObjCNoReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ObjCNoReturn.cpp", line = 29,
   FQN="clang::ObjCNoReturn::ObjCNoReturn", NM="_ZN5clang12ObjCNoReturnC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ObjCNoReturn.cpp -nm=_ZN5clang12ObjCNoReturnC1ERNS_10ASTContextE")
  //</editor-fold>
  public ObjCNoReturn(final ASTContext /*&*/ C) {
    // : RaiseSel(GetNullarySelector("raise", C)), NSExceptionII(&C.Idents.get("NSException")), NSExceptionInstanceRaiseSelectors() 
    //START JInit
    this.RaiseSel = GetNullarySelector(new StringRef(/*KEEP_STR*/"raise"), C);
    this.NSExceptionII = $AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"NSException")));
    this.NSExceptionInstanceRaiseSelectors = new$T(new Selector [2], ()->new Selector());
    //END JInit
    // Generate selectors.
    SmallVector<IdentifierInfo /*P*/> II/*J*/= new SmallVector<IdentifierInfo /*P*/>(3, (IdentifierInfo /*P*/)null);
    
    // raise:format:
    II.push_back($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"raise"))));
    II.push_back($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"format"))));
    NSExceptionInstanceRaiseSelectors[0].$assignMove(
        C.Selectors.getSelector(II.size(), $AddrOf(II.ptr$at(0)))
    );
    
    // raise:format:arguments:
    II.push_back($AddrOf(C.Idents.get(new StringRef(/*KEEP_STR*/"arguments"))));
    NSExceptionInstanceRaiseSelectors[1].$assignMove(
        C.Selectors.getSelector(II.size(), $AddrOf(II.ptr$at(0)))
    );
  }

  
  /// Return true if the given message expression is known to never
  /// return.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCNoReturn::isImplicitNoReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ObjCNoReturn.cpp", line = 49,
   FQN="clang::ObjCNoReturn::isImplicitNoReturn", NM="_ZN5clang12ObjCNoReturn18isImplicitNoReturnEPKNS_15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ObjCNoReturn.cpp -nm=_ZN5clang12ObjCNoReturn18isImplicitNoReturnEPKNS_15ObjCMessageExprE")
  //</editor-fold>
  public boolean isImplicitNoReturn(/*const*/ ObjCMessageExpr /*P*/ ME) {
    Selector S = ME.getSelector();
    if (ME.isInstanceMessage()) {
      // Check for the "raise" message.
      return S.$eq(/*NO_COPY*/RaiseSel);
    }
    {
      
      /*const*/ ObjCInterfaceDecl /*P*/ ID = ME.getReceiverInterface();
      if ((ID != null)) {
        if (isSubclass(ID, NSExceptionII)) {
          for (/*uint*/int i = 0; $less_uint(i, NUM_RAISE_SELECTORS); ++i) {
            if (S.$eq(/*NO_COPY*/NSExceptionInstanceRaiseSelectors[i])) {
              return true;
            }
          }
        }
      }
    }
    
    return false;
  }

  
  @Override public String toString() {
    return "" + "RaiseSel=" + RaiseSel // NOI18N
              + ", NSExceptionII=" + NSExceptionII // NOI18N
              + ", NSExceptionInstanceRaiseSelectors=" + NSExceptionInstanceRaiseSelectors; // NOI18N
  }
}
