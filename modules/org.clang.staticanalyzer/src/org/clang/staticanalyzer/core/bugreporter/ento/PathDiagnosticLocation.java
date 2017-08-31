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

package org.clang.staticanalyzer.core.bugreporter.ento;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.core.impl.PathDiagnosticStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clank.support.Native.NativePOD;


//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 134,
 FQN="clang::ento::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationE")
//</editor-fold>
public class PathDiagnosticLocation implements Native.NativeComparable<PathDiagnosticLocation>, FoldingSetTrait.Profilable, NativePOD<PathDiagnosticLocation> {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 136,
   FQN="clang::ento::PathDiagnosticLocation::Kind", NM="_ZN5clang4ento22PathDiagnosticLocation4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation4KindE")
  //</editor-fold>
  private enum Kind implements Native.NativeUIntEnum {
    RangeK(0),
    SingleLocK(RangeK.getValue() + 1),
    StmtK(SingleLocK.getValue() + 1),
    DeclK(StmtK.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
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

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  private  Kind K;
  private /*const*/ Stmt /*P*/ S;
  private /*const*/ Decl /*P*/ D;
  private /*const*/ SourceManager /*P*/ SM;
  private FullSourceLoc Loc;
  private PathDiagnosticRange Range;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 143,
   FQN="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationC1ENS_14SourceLocationERKNS_13SourceManagerENS1_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationC1ENS_14SourceLocationERKNS_13SourceManagerENS1_4KindE")
  //</editor-fold>
  private PathDiagnosticLocation(SourceLocation L, final /*const*/ SourceManager /*&*/ sm, 
      Kind kind) {
    // : K(kind), S(null), D(null), SM(&sm), Loc(genLocation(L)), Range(genRange()) 
    //START JInit
    this.K = kind;
    this.S = null;
    this.D = null;
    this.SM = $AddrOf(sm);
    this.Loc = genLocation(new SourceLocation(L));
    this.Range = genRange();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::genLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 774,
   FQN="clang::ento::PathDiagnosticLocation::genLocation", NM="_ZNK5clang4ento22PathDiagnosticLocation11genLocationENS_14SourceLocationEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation11genLocationENS_14SourceLocationEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE")
  //</editor-fold>
  private FullSourceLoc genLocation() /*const*/ {
    return genLocation(new SourceLocation(), 
             new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, (AnalysisDeclContext /*P*/ )(AnalysisDeclContext /*P*/ )null));
  }
  private FullSourceLoc genLocation(SourceLocation L/*= SourceLocation()*/) /*const*/ {
    return genLocation(L, 
             new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, (AnalysisDeclContext /*P*/ )(AnalysisDeclContext /*P*/ )null));
  }
  private FullSourceLoc genLocation(SourceLocation L/*= SourceLocation()*/, 
             PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > LAC/*= (AnalysisDeclContext * )null*/) /*const*/ {
    assert (isValid());
    // Note that we want a 'switch' here so that the compiler can warn us in
    // case we add more cases.
    switch (K) {
     case SingleLocK:
     case RangeK:
      break;
     case StmtK:
      // Defensive checking.
      if (!(S != null)) {
        break;
      }
      return new FullSourceLoc(getValidSourceLocation(S, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(LAC)), 
          ((/*const_cast*/SourceManager /*&*/ )($Deref(SM))));
     case DeclK:
      // Defensive checking.
      if (!(D != null)) {
        break;
      }
      return new FullSourceLoc(D.getLocation(), ((/*const_cast*/SourceManager /*&*/ )($Deref(SM))));
    }
    
    return new FullSourceLoc(/*NO_COPY*/L, ((/*const_cast*/SourceManager /*&*/ )($Deref(SM))));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::genRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 800,
   FQN="clang::ento::PathDiagnosticLocation::genRange", NM="_ZNK5clang4ento22PathDiagnosticLocation8genRangeEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation8genRangeEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE")
  //</editor-fold>
  private PathDiagnosticRange genRange() /*const*/ {
    return genRange(new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, (AnalysisDeclContext /*P*/ )(AnalysisDeclContext /*P*/ )null));
  }
  private PathDiagnosticRange genRange(PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > LAC/*= (AnalysisDeclContext * )null*/) /*const*/ {
    assert (isValid());
    // Note that we want a 'switch' here so that the compiler can warn us in
    // case we add more cases.
    switch (K) {
     case SingleLocK:
      return new PathDiagnosticRange(new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc), true);
     case RangeK:
      break;
     case StmtK:
      {
        /*const*/ Stmt /*P*/ S = asStmt();
        switch (S.getStmtClass()) {
         default:
          break;
         case DeclStmtClass:
          {
            /*const*/ DeclStmt /*P*/ DS = cast_DeclStmt(S);
            if (DS.isSingleDecl()) {
              // Should always be the case, but we'll be defensive.
              return new PathDiagnosticRange(new SourceRange(DS.getLocStart(), 
                      DS.getSingleDecl$Const().getLocation()));
            }
            break;
          }
         case IfStmtClass:
         case WhileStmtClass:
         case DoStmtClass:
         case ForStmtClass:
         case ChooseExprClass:
         case IndirectGotoStmtClass:
         case SwitchStmtClass:
         case BinaryConditionalOperatorClass:
         case ConditionalOperatorClass:
         case ObjCForCollectionStmtClass:
          {
            SourceLocation L = getValidSourceLocation(S, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(LAC));
            return new PathDiagnosticRange(new SourceRange(/*NO_COPY*/L, /*NO_COPY*/L));
          }
        }
        SourceRange R = S.getSourceRange();
        if (R.isValid()) {
          return new PathDiagnosticRange(new SourceRange(R));
        }
        break;
      }
     case DeclK:
      {
        /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
        if ((MD != null)) {
          return new PathDiagnosticRange(MD.getSourceRange());
        }
      }
      {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          {
            Stmt /*P*/ Body = FD.getBody();
            if ((Body != null)) {
              return new PathDiagnosticRange(Body.getSourceRange());
            }
          }
        } else {
          SourceLocation L = D.getLocation();
          return new PathDiagnosticRange(new SourceRange(/*NO_COPY*/L, /*NO_COPY*/L), true);
        }
      }
    }
    
    return new PathDiagnosticRange(new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc));
  }


/*public:*/
  /// Create an invalid location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 158,
   FQN="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationC1Ev")
  //</editor-fold>
  public PathDiagnosticLocation() {
    // : K(SingleLocK), S(null), D(null), SM(null), Loc(), Range() 
    //START JInit
    this.K = Kind.SingleLocK;
    this.S = null;
    this.D = null;
    this.SM = null;
    this.Loc = new FullSourceLoc();
    this.Range = new PathDiagnosticRange();
    //END JInit
  }

  
  /// Create a location corresponding to the given statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 162,
   FQN="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationC1EPKNS_4StmtERKNS_13SourceManagerEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationC1EPKNS_4StmtERKNS_13SourceManagerEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE")
  //</editor-fold>
  public PathDiagnosticLocation(/*const*/ Stmt /*P*/ s, 
      final /*const*/ SourceManager /*&*/ sm, 
      PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > lac) {
    // : K(s->getLocStart().isValid() ? StmtK : SingleLocK), S(K == StmtK ? s : null), D(null), SM(&sm), Loc(genLocation(SourceLocation(), lac)), Range(genRange(lac)) 
    //START JInit
    this.K = s.getLocStart().isValid() ? Kind.StmtK : Kind.SingleLocK;
    this.S = K == Kind.StmtK ? s : null;
    this.D = null;
    this.SM = $AddrOf(sm);
    this.Loc = genLocation(new SourceLocation(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(lac));
    this.Range = genRange(new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(lac));
    //END JInit
    assert (K == Kind.SingleLocK || (S != null));
    assert (K == Kind.SingleLocK || Loc.isValid());
    assert (K == Kind.SingleLocK || Range.isValid());
  }

  
  /// Create a location corresponding to the given declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 176,
   FQN="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationC1EPKNS_4DeclERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationC1EPKNS_4DeclERKNS_13SourceManagerE")
  //</editor-fold>
  public PathDiagnosticLocation(/*const*/ Decl /*P*/ d, final /*const*/ SourceManager /*&*/ sm) {
    // : K(DeclK), S(null), D(d), SM(&sm), Loc(genLocation()), Range(genRange()) 
    //START JInit
    this.K = Kind.DeclK;
    this.S = null;
    this.D = d;
    this.SM = $AddrOf(sm);
    this.Loc = genLocation();
    this.Range = genRange();
    //END JInit
    assert Native.$bool(D);
    assert (Loc.isValid());
    assert (Range.isValid());
  }

  
  /// Create a location at an explicit offset in the source.
  ///
  /// This should only be used if there are no more appropriate constructors.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 187,
   FQN="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationC1ENS_14SourceLocationERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationC1ENS_14SourceLocationERKNS_13SourceManagerE")
  //</editor-fold>
  public PathDiagnosticLocation(SourceLocation loc, final /*const*/ SourceManager /*&*/ sm) {
    // : K(SingleLocK), S(null), D(null), SM(&sm), Loc(loc, sm), Range(genRange()) 
    //START JInit
    this.K = Kind.SingleLocK;
    this.S = null;
    this.D = null;
    this.SM = $AddrOf(sm);
    this.Loc = new FullSourceLoc(/*NO_COPY*/loc, sm);
    this.Range = genRange();
    //END JInit
    assert (Loc.isValid());
    assert (Range.isValid());
  }

  
  /// Create a location corresponding to the given declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 195,
   FQN="clang::ento::PathDiagnosticLocation::create", NM="_ZN5clang4ento22PathDiagnosticLocation6createEPKNS_4DeclERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation6createEPKNS_4DeclERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation create(/*const*/ Decl /*P*/ D, 
        final /*const*/ SourceManager /*&*/ SM) {
    return new PathDiagnosticLocation(D, SM);
  }

  
  /// Create a location for the beginning of the declaration.
  
  /// Create a location for the beginning of the declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 579,
   FQN="clang::ento::PathDiagnosticLocation::createBegin", NM="_ZN5clang4ento22PathDiagnosticLocation11createBeginEPKNS_4DeclERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation11createBeginEPKNS_4DeclERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createBegin(/*const*/ Decl /*P*/ D, 
             final /*const*/ SourceManager /*&*/ SM) {
    return new PathDiagnosticLocation(D.getLocStart(), SM, Kind.SingleLocK);
  }


  
  /// Create a location for the beginning of the statement.
  
  /// Create a location for the beginning of the statement.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 585,
   FQN="clang::ento::PathDiagnosticLocation::createBegin", NM="_ZN5clang4ento22PathDiagnosticLocation11createBeginEPKNS_4StmtERKNS_13SourceManagerEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation11createBeginEPKNS_4StmtERKNS_13SourceManagerEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE")
  //</editor-fold>
  public static PathDiagnosticLocation createBegin(/*const*/ Stmt /*P*/ S, 
             final /*const*/ SourceManager /*&*/ SM, 
             PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > LAC) {
    return new PathDiagnosticLocation(getValidSourceLocation(S, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(LAC)), 
        SM, Kind.SingleLocK);
  }


  
  /// Create a location for the end of the statement.
  ///
  /// If the statement is a CompoundStatement, the location will point to the
  /// closing brace instead of following it.
  
  /// Create a location for the end of the statement.
  ///
  /// If the statement is a CompoundStatement, the location will point to the
  /// closing brace instead of following it.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 593,
   FQN="clang::ento::PathDiagnosticLocation::createEnd", NM="_ZN5clang4ento22PathDiagnosticLocation9createEndEPKNS_4StmtERKNS_13SourceManagerEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation9createEndEPKNS_4StmtERKNS_13SourceManagerEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEE")
  //</editor-fold>
  public static PathDiagnosticLocation createEnd(/*const*/ Stmt /*P*/ S, 
           final /*const*/ SourceManager /*&*/ SM, 
           PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > LAC) {
    {
      /*const*/ CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(S);
      if ((CS != null)) {
        return PathDiagnosticLocation.createEndBrace(CS, SM);
      }
    }
    return new PathDiagnosticLocation(getValidSourceLocation(S, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(LAC), /*End=*/ true), 
        SM, Kind.SingleLocK);
  }


  
  /// Create the location for the operator of the binary expression.
  /// Assumes the statement has a valid location.
  
  /// Create the location for the operator of the binary expression.
  /// Assumes the statement has a valid location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 603,
   FQN="clang::ento::PathDiagnosticLocation::createOperatorLoc", NM="_ZN5clang4ento22PathDiagnosticLocation17createOperatorLocEPKNS_14BinaryOperatorERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation17createOperatorLocEPKNS_14BinaryOperatorERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createOperatorLoc(/*const*/ BinaryOperator /*P*/ BO, 
                   final /*const*/ SourceManager /*&*/ SM) {
    return new PathDiagnosticLocation(BO.getOperatorLoc(), SM, Kind.SingleLocK);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createConditionalColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 609,
   FQN="clang::ento::PathDiagnosticLocation::createConditionalColonLoc", NM="_ZN5clang4ento22PathDiagnosticLocation25createConditionalColonLocEPKNS_19ConditionalOperatorERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation25createConditionalColonLocEPKNS_19ConditionalOperatorERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createConditionalColonLoc(/*const*/ ConditionalOperator /*P*/ CO, 
                           final /*const*/ SourceManager /*&*/ SM) {
    return new PathDiagnosticLocation(CO.getColonLoc(), SM, Kind.SingleLocK);
  }


  
  /// For member expressions, return the location of the '.' or '->'.
  /// Assumes the statement has a valid location.
  
  /// For member expressions, return the location of the '.' or '->'.
  /// Assumes the statement has a valid location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createMemberLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 617,
   FQN="clang::ento::PathDiagnosticLocation::createMemberLoc", NM="_ZN5clang4ento22PathDiagnosticLocation15createMemberLocEPKNS_10MemberExprERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation15createMemberLocEPKNS_10MemberExprERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createMemberLoc(/*const*/ MemberExpr /*P*/ ME, 
                 final /*const*/ SourceManager /*&*/ SM) {
    return new PathDiagnosticLocation(ME.getMemberLoc(), SM, Kind.SingleLocK);
  }


  
  /// Create a location for the beginning of the compound statement.
  /// Assumes the statement has a valid location.
  
  /// Create a location for the beginning of the compound statement.
  /// Assumes the statement has a valid location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createBeginBrace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 623,
   FQN="clang::ento::PathDiagnosticLocation::createBeginBrace", NM="_ZN5clang4ento22PathDiagnosticLocation16createBeginBraceEPKNS_12CompoundStmtERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation16createBeginBraceEPKNS_12CompoundStmtERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createBeginBrace(/*const*/ CompoundStmt /*P*/ CS, 
                  final /*const*/ SourceManager /*&*/ SM) {
    SourceLocation L = CS.getLBracLoc();
    return new PathDiagnosticLocation(new SourceLocation(L), SM, Kind.SingleLocK);
  }


  
  /// Create a location for the end of the compound statement.
  /// Assumes the statement has a valid location.
  
  /// Create a location for the end of the compound statement.
  /// Assumes the statement has a valid location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createEndBrace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 630,
   FQN="clang::ento::PathDiagnosticLocation::createEndBrace", NM="_ZN5clang4ento22PathDiagnosticLocation14createEndBraceEPKNS_12CompoundStmtERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation14createEndBraceEPKNS_12CompoundStmtERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createEndBrace(/*const*/ CompoundStmt /*P*/ CS, 
                final /*const*/ SourceManager /*&*/ SM) {
    SourceLocation L = CS.getRBracLoc();
    return new PathDiagnosticLocation(new SourceLocation(L), SM, Kind.SingleLocK);
  }


  
  /// Create a location for the beginning of the enclosing declaration body.
  /// Defaults to the beginning of the first statement in the declaration body.
  
  /// Create a location for the beginning of the enclosing declaration body.
  /// Defaults to the beginning of the first statement in the declaration body.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createDeclBegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 637,
   FQN="clang::ento::PathDiagnosticLocation::createDeclBegin", NM="_ZN5clang4ento22PathDiagnosticLocation15createDeclBeginEPKNS_15LocationContextERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation15createDeclBeginEPKNS_15LocationContextERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createDeclBegin(/*const*/ LocationContext /*P*/ LC, 
                 final /*const*/ SourceManager /*&*/ SM) {
    {
      // FIXME: Should handle CXXTryStmt if analyser starts supporting C++.
      /*const*/ CompoundStmt /*P*/ CS = dyn_cast_or_null_CompoundStmt(LC.getDecl().getBody());
      if ((CS != null)) {
        if (!CS.body_empty()) {
          SourceLocation Loc = (CS.body_begin$Const().$star()).getLocStart();
          return new PathDiagnosticLocation(new SourceLocation(Loc), SM, Kind.SingleLocK);
        }
      }
    }
    
    return new PathDiagnosticLocation();
  }


  
  /// Constructs a location for the end of the enclosing declaration body.
  /// Defaults to the end of brace.
  
  /// Constructs a location for the end of the enclosing declaration body.
  /// Defaults to the end of brace.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createDeclEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 651,
   FQN="clang::ento::PathDiagnosticLocation::createDeclEnd", NM="_ZN5clang4ento22PathDiagnosticLocation13createDeclEndEPKNS_15LocationContextERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation13createDeclEndEPKNS_15LocationContextERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createDeclEnd(/*const*/ LocationContext /*P*/ LC, 
               final /*const*/ SourceManager /*&*/ SM) {
    SourceLocation L = LC.getDecl().getBodyRBrace();
    return new PathDiagnosticLocation(new SourceLocation(L), SM, Kind.SingleLocK);
  }


  
  /// Create a location corresponding to the given valid ExplodedNode.
  
  /// Create a location corresponding to the given valid ExplodedNode.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 658,
   FQN="clang::ento::PathDiagnosticLocation::create", NM="_ZN5clang4ento22PathDiagnosticLocation6createERKNS_12ProgramPointERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation6createERKNS_12ProgramPointERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation create(final /*const*/ ProgramPoint /*&*/ P, 
        final /*const*/ SourceManager /*&*/ SMng) {
    /*const*/ Stmt /*P*/ S = null;
    {
      Optional<BlockEdge> BE = P.getAs(BlockEdge.class);
      if (BE.$bool()) {
        /*const*/ CFGBlock /*P*/ BSrc = BE.$arrow().getSrc();
        S = BSrc.getTerminatorCondition$Const();
      } else {
        Optional<StmtPoint> SP = P.getAs(StmtPoint.class);
        if (SP.$bool()) {
          S = SP.$arrow().getStmt();
          if (P.getAs(PostStmtPurgeDeadSymbols.class).$bool()) {
            return PathDiagnosticLocation.createEnd(S, SMng, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, P.getLocationContext()));
          }
        } else {
          Optional<PostInitializer> PIP = P.getAs(PostInitializer.class);
          if (PIP.$bool()) {
            return new PathDiagnosticLocation(PIP.$arrow().getInitializer().getSourceLocation(), 
                SMng);
          } else {
            Optional<PostImplicitCall> PIE = P.getAs(PostImplicitCall.class);
            if (PIE.$bool()) {
              return new PathDiagnosticLocation(PIE.$arrow().getLocation(), SMng);
            } else {
              Optional<CallEnter> CE = P.getAs(CallEnter.class);
              if (CE.$bool()) {
                return getLocationForCaller(CE.$arrow().getCalleeContext(), 
                    CE.$arrow().getLocationContext(), 
                    SMng);
              } else {
                Optional<CallExitEnd> CEE = P.getAs(CallExitEnd.class);
                if (CEE.$bool()) {
                  return getLocationForCaller(CEE.$arrow().getCalleeContext(), 
                      CEE.$arrow().getLocationContext(), 
                      SMng);
                } else {
                  throw new llvm_unreachable("Unexpected ProgramPoint");
                }
              }
            }
          }
        }
      }
    }
    
    return new PathDiagnosticLocation(S, SMng, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, P.getLocationContext()));
  }


  
  /// Create a location corresponding to the next valid ExplodedNode as end
  /// of path location.
  
  /// Create a location corresponding to the next valid ExplodedNode as end
  /// of path location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createEndOfPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 732,
   FQN="clang::ento::PathDiagnosticLocation::createEndOfPath", NM="_ZN5clang4ento22PathDiagnosticLocation15createEndOfPathEPKNS0_12ExplodedNodeERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation15createEndOfPathEPKNS0_12ExplodedNodeERKNS_13SourceManagerE")
  //</editor-fold>
  public static PathDiagnosticLocation createEndOfPath(/*const*/ ExplodedNode /*P*/ N, 
                 final /*const*/ SourceManager /*&*/ SM) {
    assert ((N != null)) : "Cannot create a location with a null node.";
    /*const*/ Stmt /*P*/ S = getStmt(N);
    if (!(S != null)) {
      {
        // If this is an implicit call, return the implicit call point location.
        Optional<PreImplicitCall> PIE = N.<PreImplicitCall>getLocationAs(PreImplicitCall.class);
        if (PIE.$bool()) {
          return new PathDiagnosticLocation(PIE.$arrow().getLocation(), SM);
        }
      }
      S = getNextStmt(N);
    }
    if ((S != null)) {
      ProgramPoint P = N.getLocation();
      /*const*/ LocationContext /*P*/ LC = N.getLocationContext();
      {
        
        // For member expressions, return the location of the '.' or '->'.
        /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(S);
        if ((ME != null)) {
          return PathDiagnosticLocation.createMemberLoc(ME, SM);
        }
      }
      {
        
        // For binary operators, return the location of the operator.
        /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(S);
        if ((B != null)) {
          return PathDiagnosticLocation.createOperatorLoc(B, SM);
        }
      }
      if (P.getAs(PostStmtPurgeDeadSymbols.class).$bool()) {
        return PathDiagnosticLocation.createEnd(S, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
      }
      if (S.getLocStart().isValid()) {
        return new PathDiagnosticLocation(S, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC));
      }
      return new PathDiagnosticLocation(getValidSourceLocation(S, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, LC)), SM);
    }
    
    return createDeclEnd(N.getLocationContext(), SM);
  }


  
  /// Convert the given location into a single kind location.
  
  /// Convert the given location into a single kind location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::createSingleLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 768,
   FQN="clang::ento::PathDiagnosticLocation::createSingleLocation", NM="_ZN5clang4ento22PathDiagnosticLocation20createSingleLocationERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation20createSingleLocationERKS1_")
  //</editor-fold>
  public static PathDiagnosticLocation createSingleLocation(final /*const*/ PathDiagnosticLocation /*&*/ PDL) {
    FullSourceLoc L = PDL.asLocation();
    return new PathDiagnosticLocation(new SourceLocation(L), L.getManager(), Kind.SingleLocK);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 263,
   FQN="clang::ento::PathDiagnosticLocation::operator==", NM="_ZNK5clang4ento22PathDiagnosticLocationeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocationeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ PathDiagnosticLocation /*&*/ X) /*const*/ {
    return K == X.K && FullSourceLoc.$eq_FullSourceLoc$C(Loc, X.Loc) && Range.$eq(X.Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 267,
   FQN="clang::ento::PathDiagnosticLocation::operator!=", NM="_ZNK5clang4ento22PathDiagnosticLocationneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocationneERKS1_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ PathDiagnosticLocation /*&*/ X) /*const*/ {
    return !(/*Deref*/this.$eq(X));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 271,
   FQN="clang::ento::PathDiagnosticLocation::isValid", NM="_ZNK5clang4ento22PathDiagnosticLocation7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return SM != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::asLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 275,
   FQN="clang::ento::PathDiagnosticLocation::asLocation", NM="_ZNK5clang4ento22PathDiagnosticLocation10asLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation10asLocationEv")
  //</editor-fold>
  public FullSourceLoc asLocation() /*const*/ {
    return new FullSourceLoc(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::asRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 279,
   FQN="clang::ento::PathDiagnosticLocation::asRange", NM="_ZNK5clang4ento22PathDiagnosticLocation7asRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation7asRangeEv")
  //</editor-fold>
  public PathDiagnosticRange asRange() /*const*/ {
    return new PathDiagnosticRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::asStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 283,
   FQN="clang::ento::PathDiagnosticLocation::asStmt", NM="_ZNK5clang4ento22PathDiagnosticLocation6asStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation6asStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ asStmt() /*const*/ {
    assert (isValid());
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::asDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 284,
   FQN="clang::ento::PathDiagnosticLocation::asDecl", NM="_ZNK5clang4ento22PathDiagnosticLocation6asDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation6asDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ asDecl() /*const*/ {
    assert (isValid());
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::hasRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 286,
   FQN="clang::ento::PathDiagnosticLocation::hasRange", NM="_ZNK5clang4ento22PathDiagnosticLocation8hasRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation8hasRangeEv")
  //</editor-fold>
  public boolean hasRange() /*const*/ {
    return K == Kind.StmtK || K == Kind.RangeK || K == Kind.DeclK;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::invalidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 288,
   FQN="clang::ento::PathDiagnosticLocation::invalidate", NM="_ZN5clang4ento22PathDiagnosticLocation10invalidateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation10invalidateEv")
  //</editor-fold>
  public void invalidate() {
    /*Deref*/this.$assignMove(new PathDiagnosticLocation());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::flatten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 861,
   FQN="clang::ento::PathDiagnosticLocation::flatten", NM="_ZN5clang4ento22PathDiagnosticLocation7flattenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation7flattenEv")
  //</editor-fold>
  public void flatten() {
    if (K == Kind.StmtK) {
      K = Kind.RangeK;
      S = null;
      D = null;
    } else if (K == Kind.DeclK) {
      K = Kind.SingleLocK;
      S = null;
      D = null;
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::getManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 294,
   FQN="clang::ento::PathDiagnosticLocation::getManager", NM="_ZNK5clang4ento22PathDiagnosticLocation10getManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation10getManagerEv")
  //</editor-fold>
  public /*const*/ SourceManager /*&*/ getManager() /*const*/ {
    assert (isValid());
    return $Deref(SM);
  }

  
  //===----------------------------------------------------------------------===//
  // FoldingSet profiling methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1056,
   FQN="clang::ento::PathDiagnosticLocation::Profile", NM="_ZNK5clang4ento22PathDiagnosticLocation7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddInteger_uint(Range.getBegin().getRawEncoding());
    ID.AddInteger_uint(Range.getEnd().getRawEncoding());
    ID.AddInteger_uint(Loc.getRawEncoding());
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 3520,
   FQN="clang::ento::PathDiagnosticLocation::dump", NM="_ZNK5clang4ento22PathDiagnosticLocation4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang4ento22PathDiagnosticLocation4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    if (!isValid()) {
      llvm.errs().$out(/*KEEP_STR*/"<INVALID>\n");
      return;
    }
    switch (K) {
     case RangeK:
      // FIXME: actually print the range.
      llvm.errs().$out(/*KEEP_STR*/"<range>\n");
      break;
     case SingleLocK:
      asLocation().dump();
      llvm.errs().$out(/*KEEP_STR*/$LF);
      break;
     case StmtK:
      if ((S != null)) {
        S.dump();
      } else {
        llvm.errs().$out(/*KEEP_STR*/"<NULL STMT>\n");
      }
      break;
     case DeclK:
      {
        /*const*/ NamedDecl /*P*/ ND = dyn_cast_or_null_NamedDecl(D);
        if ((ND != null)) {
          $out_raw_ostream_NamedDecl$C(llvm.errs(), $Deref(ND)).$out(/*KEEP_STR*/$LF);
        } else if (isa_BlockDecl(D)) {
          // FIXME: Make this nicer.
          llvm.errs().$out(/*KEEP_STR*/"<block>\n");
        } else if ((D != null)) {
          llvm.errs().$out(/*KEEP_STR*/"<unknown decl>\n");
        } else {
          llvm.errs().$out(/*KEEP_STR*/"<NULL DECL>\n");
        }
      }
      break;
    }
  }

  
  /// \brief Given an exploded node, retrieve the statement that should be used 
  /// for the diagnostic location.
  
  /// \brief Given an exploded node, retrieve the statement that should be used 
  /// for the diagnostic location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 689,
   FQN="clang::ento::PathDiagnosticLocation::getStmt", NM="_ZN5clang4ento22PathDiagnosticLocation7getStmtEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation7getStmtEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public static /*const*/ Stmt /*P*/ getStmt(/*const*/ ExplodedNode /*P*/ N) {
    ProgramPoint P = N.getLocation();
    {
      Optional<StmtPoint> SP = P.getAs(StmtPoint.class);
      if (SP.$bool()) {
        return SP.$arrow().getStmt();
      }
    }
    {
      Optional<BlockEdge> BE = P.getAs(BlockEdge.class);
      if (BE.$bool()) {
        return BE.$arrow().getSrc().getTerminator$Const().$Stmt$C$P();
      }
    }
    {
      Optional<CallEnter> CE = P.getAs(CallEnter.class);
      if (CE.$bool()) {
        return CE.$arrow().getCallExpr();
      }
    }
    {
      Optional<CallExitEnd> CEE = P.getAs(CallExitEnd.class);
      if (CEE.$bool()) {
        return CEE.$arrow().getCalleeContext().getCallSite();
      }
    }
    {
      Optional<PostInitializer> PIPP = P.getAs(PostInitializer.class);
      if (PIPP.$bool()) {
        return PIPP.$arrow().getInitializer().getInit();
      }
    }
    
    return null;
  }


  
  /// \brief Retrieve the statement corresponding to the successor node.
  
  /// \brief Retrieve the statement corresponding to the successor node.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::getNextStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 705,
   FQN="clang::ento::PathDiagnosticLocation::getNextStmt", NM="_ZN5clang4ento22PathDiagnosticLocation11getNextStmtEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento22PathDiagnosticLocation11getNextStmtEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  public static /*const*/ Stmt /*P*/ getNextStmt(/*const*/ ExplodedNode /*P*/ N) {
    for (N = N.getFirstSucc(); (N != null); N = N.getFirstSucc()) {
      {
        /*const*/ Stmt /*P*/ S = getStmt(N);
        if ((S != null)) {
          // Check if the statement is '?' or '&&'/'||'.  These are "merges",
          // not actual statement points.
          switch (S.getStmtClass()) {
           case ChooseExprClass:
           case BinaryConditionalOperatorClass:
           case ConditionalOperatorClass:
            continue;
           case BinaryOperatorClass:
            {
              BinaryOperatorKind Op = cast_BinaryOperator(S).getOpcode();
              if (Op == BinaryOperatorKind.BO_LAnd || Op == BinaryOperatorKind.BO_LOr) {
                continue;
              }
              break;
            }
           default:
            break;
          }
          // We found the statement, so return it.
          return S;
        }
      }
    }
    
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 134,
   FQN="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationC1ERKS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticLocation(final /*const*/ PathDiagnosticLocation /*&*/ $Prm0) {
    // : K(.K), S(.S), D(.D), SM(.SM), Loc(.Loc), Range(.Range) 
    //START JInit
    this.K = $Prm0.K;
    this.S = $Prm0.S;
    this.D = $Prm0.D;
    this.SM = $Prm0.SM;
    this.Loc = new FullSourceLoc($Prm0.Loc);
    this.Range = new PathDiagnosticRange($Prm0.Range);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 134,
   FQN="clang::ento::PathDiagnosticLocation::PathDiagnosticLocation", NM="_ZN5clang4ento22PathDiagnosticLocationC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationC1EOS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticLocation(JD$Move _dparam, final PathDiagnosticLocation /*&&*/$Prm0) {
    // : K(static_cast<PathDiagnosticLocation &&>().K), S(static_cast<PathDiagnosticLocation &&>().S), D(static_cast<PathDiagnosticLocation &&>().D), SM(static_cast<PathDiagnosticLocation &&>().SM), Loc(static_cast<PathDiagnosticLocation &&>().Loc), Range(static_cast<PathDiagnosticLocation &&>().Range) 
    //START JInit
    this.K = $Prm0.K;
    this.S = $Prm0.S;
    this.D = $Prm0.D;
    this.SM = $Prm0.SM;
    this.Loc = new FullSourceLoc(JD$Move.INSTANCE, $Prm0.Loc);
    this.Range = new PathDiagnosticRange(JD$Move.INSTANCE, $Prm0.Range);
    //END JInit
    $Prm0.K = null;
    $Prm0.S = null;
    $Prm0.D = null;
    $Prm0.SM = null;    
    $Prm0.Loc = null;
    $Prm0.Range = null;    
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 134,
   FQN="clang::ento::PathDiagnosticLocation::operator=", NM="_ZN5clang4ento22PathDiagnosticLocationaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationaSERKS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticLocation /*&*/ $assign(final /*const*/ PathDiagnosticLocation /*&*/ $Prm0) {
    this.K = $Prm0.K;
    this.S = $Prm0.S;
    this.D = $Prm0.D;
    this.SM = $Prm0.SM;
    // JAVA: we use $Clone here vs $assign to keep SrcMgr final in FullSourceLoc class
    this.Loc = Native.$Clone($Prm0.Loc);
    this.Range.$assign($Prm0.Range);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnosticLocation::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 134,
   FQN="clang::ento::PathDiagnosticLocation::operator=", NM="_ZN5clang4ento22PathDiagnosticLocationaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang4ento22PathDiagnosticLocationaSEOS1_")
  //</editor-fold>
  public /*inline*/ PathDiagnosticLocation /*&*/ $assignMove(final PathDiagnosticLocation /*&&*/$Prm0) {
    this.K = $Prm0.K;
    this.S = $Prm0.S;
    this.D = $Prm0.D;
    this.SM = $Prm0.SM;
    this.Loc = $Prm0.Loc;
    this.Range.$assignMove($Prm0.Range);
    $Prm0.K = null;
    $Prm0.S = null;
    $Prm0.D = null;
    $Prm0.SM = null;
    $Prm0.Loc = null;
    $Prm0.Range = null;
    return /*Deref*/this;
  }

  @Override public PathDiagnosticLocation clone() {
    assert this.getClass() == PathDiagnosticLocation.class : "must be overridden in " + this.getClass();
    return new PathDiagnosticLocation(this);
  }
  
  @Override public String toString() {
    return "" + "K=" + K // NOI18N
              + ", S=" + S // NOI18N
              + ", D=" + D // NOI18N
              + ", SM=" + "[SourceManager]" // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Range=" + Range; // NOI18N
  }
}
