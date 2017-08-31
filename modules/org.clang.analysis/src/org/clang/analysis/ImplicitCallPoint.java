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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// Represents an implicit call event.
///
/// The nearest statement is provided for diagnostic purposes.
//<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 527,
 FQN="clang::ImplicitCallPoint", NM="_ZN5clang17ImplicitCallPointE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang17ImplicitCallPointE")
//</editor-fold>
public class ImplicitCallPoint extends /*public*/ ProgramPoint {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint::ImplicitCallPoint">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 529,
   FQN="clang::ImplicitCallPoint::ImplicitCallPoint", NM="_ZN5clang17ImplicitCallPointC1EPKNS_4DeclENS_14SourceLocationENS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang17ImplicitCallPointC1EPKNS_4DeclENS_14SourceLocationENS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ImplicitCallPoint(/*const*/ Decl /*P*/ D, SourceLocation Loc, ProgramPoint.Kind K, 
      /*const*/ LocationContext /*P*/ L, /*const*/ ProgramPointTag /*P*/ Tag) {
    // : ProgramPoint(Loc.getPtrEncoding(), D, K, L, Tag) 
    //START JInit
    super(/*pass as SourceLocation*/Loc/*.getPtrEncoding()*/, D, K, L, Tag);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 533,
   FQN="clang::ImplicitCallPoint::getDecl", NM="_ZNK5clang17ImplicitCallPoint7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang17ImplicitCallPoint7getDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDecl() /*const*/ {
    return ((/*static_cast*//*const*/ Decl /*P*/ )(getData2()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint::getLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 534,
   FQN="clang::ImplicitCallPoint::getLocation", NM="_ZNK5clang17ImplicitCallPoint11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang17ImplicitCallPoint11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    Object data = getData1();
    if (data instanceof SourceLocation) {
      return (SourceLocation) data;
    } else if (data instanceof Integer) {
      return SourceLocation.getFromPtrEncoding((Integer)data);
    }
    throw new UnsupportedOperationException("Data1 shouuld be SourceLocation or Integer. Actual type is "+data.getClass());
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint::ImplicitCallPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 539,
   FQN="clang::ImplicitCallPoint::ImplicitCallPoint", NM="_ZN5clang17ImplicitCallPointC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang17ImplicitCallPointC1Ev")
  //</editor-fold>
  /*friend*/protected/*protected*/ ImplicitCallPoint() {
    // : ProgramPoint() 
    //START JInit
    super();
    //END JInit
  }

/*private:*/
  /*friend  class ProgramPoint*/
  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 542,
   FQN="clang::ImplicitCallPoint::isKind", NM="_ZN5clang17ImplicitCallPoint6isKindERKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang17ImplicitCallPoint6isKindERKNS_12ProgramPointE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ ProgramPoint /*&*/ Location) {
    return Location.getKind().getValue() >= Kind.MinImplicitCallKind.getValue()
       && Location.getKind().getValue() <= Kind.MaxImplicitCallKind.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint::ImplicitCallPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 527,
   FQN="clang::ImplicitCallPoint::ImplicitCallPoint", NM="_ZN5clang17ImplicitCallPointC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang17ImplicitCallPointC1ERKS0_")
  //</editor-fold>
  public /*inline*/ ImplicitCallPoint(final /*const*/ ImplicitCallPoint /*&*/ $Prm0) {
    // : ProgramPoint() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImplicitCallPoint::ImplicitCallPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 527,
   FQN="clang::ImplicitCallPoint::ImplicitCallPoint", NM="_ZN5clang17ImplicitCallPointC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang17ImplicitCallPointC1EOS0_")
  //</editor-fold>
  public /*inline*/ ImplicitCallPoint(JD$Move _dparam, final ImplicitCallPoint /*&&*/$Prm0) {
    // : ProgramPoint(static_cast<ImplicitCallPoint &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public ImplicitCallPoint clone() {
    assert this.getClass() == ImplicitCallPoint.class : "must be overridden in " + this.getClass();
    return new ImplicitCallPoint(this);
  }
  
  @Override public ImplicitCallPoint move() {
    assert this.getClass() == ImplicitCallPoint.class : "must be overridden in " + this.getClass();
    return new ImplicitCallPoint(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
    
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
