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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.core.impl.PathDiagnosticStatics;


/// PathDiagnostic - PathDiagnostic objects represent a single path-sensitive
///  diagnostic.  It represents an ordered-collection of PathDiagnosticPieces,
///  each which represent the pieces of the path.
//<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 716,
 FQN="clang::ento::PathDiagnostic", NM="_ZN5clang4ento14PathDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnosticE")
//</editor-fold>
public class PathDiagnostic extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  private std.string CheckName;
  private /*const*/ Decl /*P*/ DeclWithIssue;
  private std.string BugType;
  private std.string VerboseDesc;
  private std.string ShortDesc;
  private std.string Category;
  private std.deque<std.string> OtherDesc;
  
  /// \brief Loc The location of the path diagnostic report.
  private PathDiagnosticLocation Loc;
  
  private PathPieces pathImpl;
  private SmallVector<PathPieces /*P*/ > pathStack;
  
  /// \brief Important bug uniqueing location.
  /// The location info is useful to differentiate between bugs.
  private PathDiagnosticLocation UniqueingLoc;
  private /*const*/ Decl /*P*/ UniqueingDecl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::PathDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 736,
   FQN="clang::ento::PathDiagnostic::PathDiagnostic", NM="_ZN5clang4ento14PathDiagnosticC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnosticC1Ev")
  //</editor-fold>
  private PathDiagnostic() { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::PathDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 106,
   FQN="clang::ento::PathDiagnostic::PathDiagnostic", NM="_ZN5clang4ento14PathDiagnosticC1EN4llvm9StringRefEPKNS_4DeclES3_S3_S3_S3_NS0_22PathDiagnosticLocationES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnosticC1EN4llvm9StringRefEPKNS_4DeclES3_S3_S3_S3_NS0_22PathDiagnosticLocationES6_")
  //</editor-fold>
  public PathDiagnostic(StringRef CheckName, /*const*/ Decl /*P*/ declWithIssue, 
      StringRef bugtype, StringRef verboseDesc, 
      StringRef shortDesc, StringRef category, 
      PathDiagnosticLocation LocationToUnique, 
      /*const*/ Decl /*P*/ DeclToUnique) {
    // : FoldingSetNode(), CheckName(CheckName.operator basic_string()), DeclWithIssue(declWithIssue), BugType(StripTrailingDots(bugtype).operator basic_string()), VerboseDesc(StripTrailingDots(verboseDesc).operator basic_string()), ShortDesc(StripTrailingDots(shortDesc).operator basic_string()), Category(StripTrailingDots(category).operator basic_string()), OtherDesc(), Loc(), pathImpl(), pathStack(), UniqueingLoc(LocationToUnique), UniqueingDecl(DeclToUnique), path(pathImpl) 
    //START JInit
    $Node();
    this.CheckName = CheckName.$string();
    this.DeclWithIssue = declWithIssue;
    this.BugType = PathDiagnosticStatics.StripTrailingDots(new StringRef(bugtype)).$string();
    this.VerboseDesc = PathDiagnosticStatics.StripTrailingDots(new StringRef(verboseDesc)).$string();
    this.ShortDesc = PathDiagnosticStatics.StripTrailingDots(new StringRef(shortDesc)).$string();
    this.Category = PathDiagnosticStatics.StripTrailingDots(new StringRef(category)).$string();
    this.OtherDesc = new std.deque<std.string>(false);
    this.Loc = new PathDiagnosticLocation();
    this.pathImpl = new PathPieces();
    this.pathStack = new SmallVector<PathPieces /*P*/ >(3, (PathPieces /*P*/ )null);
    this.UniqueingLoc = new PathDiagnosticLocation(LocationToUnique);
    this.UniqueingDecl = DeclToUnique;
    this./*&*/_path=/*&*/pathImpl;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::~PathDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 104,
   FQN="clang::ento::PathDiagnostic::~PathDiagnostic", NM="_ZN5clang4ento14PathDiagnosticD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnosticD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    pathStack.$destroy();
    pathImpl.$destroy();
    OtherDesc.$destroy();
    Category.$destroy();
    ShortDesc.$destroy();
    VerboseDesc.$destroy();
    BugType.$destroy();
    CheckName.$destroy();
    FoldingSetImpl.Node.super.$destroy$Node();
    //END JDestroy
  }

  
  public final /*const*/ PathPieces /*&*/ _path;
  
  /// Return the path currently used by builders for constructing the 
  /// PathDiagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getActivePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 749,
   FQN="clang::ento::PathDiagnostic::getActivePath", NM="_ZN5clang4ento14PathDiagnostic13getActivePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic13getActivePathEv")
  //</editor-fold>
  public PathPieces /*&*/ getActivePath() {
    if (pathStack.empty()) {
      return pathImpl;
    }
    return $Deref(pathStack.back());
  }

  
  /// Return a mutable version of 'path'.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getMutablePieces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 756,
   FQN="clang::ento::PathDiagnostic::getMutablePieces", NM="_ZN5clang4ento14PathDiagnostic16getMutablePiecesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic16getMutablePiecesEv")
  //</editor-fold>
  public PathPieces /*&*/ getMutablePieces() {
    return pathImpl;
  }

  
  /// Return the unrolled size of the path.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::full_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1046,
   FQN="clang::ento::PathDiagnostic::full_size", NM="_ZN5clang4ento14PathDiagnostic9full_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic9full_sizeEv")
  //</editor-fold>
  public /*uint*/int full_size() {
    uint$ref size = create_uint$ref(0);
    PathDiagnosticStatics.compute_path_size(_path, size);
    return size.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::pushActivePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 763,
   FQN="clang::ento::PathDiagnostic::pushActivePath", NM="_ZN5clang4ento14PathDiagnostic14pushActivePathEPNS0_10PathPiecesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic14pushActivePathEPNS0_10PathPiecesE")
  //</editor-fold>
  public void pushActivePath(PathPieces /*P*/ p) {
    pathStack.push_back(p);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::popActivePath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 764,
   FQN="clang::ento::PathDiagnostic::popActivePath", NM="_ZN5clang4ento14PathDiagnostic13popActivePathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic13popActivePathEv")
  //</editor-fold>
  public void popActivePath() {
    if (!pathStack.empty()) {
      pathStack.pop_back();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::isWithinCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 766,
   FQN="clang::ento::PathDiagnostic::isWithinCall", NM="_ZNK5clang4ento14PathDiagnostic12isWithinCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic12isWithinCallEv")
  //</editor-fold>
  public boolean isWithinCall() /*const*/ {
    return !pathStack.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::setEndOfPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 768,
   FQN="clang::ento::PathDiagnostic::setEndOfPath", NM="_ZN5clang4ento14PathDiagnostic12setEndOfPathESt10unique_ptrINS0_19PathDiagnosticPieceESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic12setEndOfPathESt10unique_ptrINS0_19PathDiagnosticPieceESt14default_deleteIS3_EE")
  //</editor-fold>
  public void setEndOfPath(std.unique_ptr<PathDiagnosticPiece> EndPiece) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!Loc.isValid()) : "End location already set!";
      Loc.$assignMove(EndPiece.$arrow().getLocation());
      assert (Loc.isValid()) : "Invalid location for end-of-path piece";
      getActivePath().push_back_T$RR($c$.track(new IntrusiveRefCntPtr<PathDiagnosticPiece>(EndPiece.release()))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::appendToDesc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 775,
   FQN="clang::ento::PathDiagnostic::appendToDesc", NM="_ZN5clang4ento14PathDiagnostic12appendToDescEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic12appendToDescEN4llvm9StringRefE")
  //</editor-fold>
  public void appendToDesc(StringRef S) {
    if (!ShortDesc.empty()) {
      $addassign_string_StringRef(ShortDesc, /*NO_COPY*/S);
    }
    $addassign_string_StringRef(VerboseDesc, /*NO_COPY*/S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::resetPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 781,
   FQN="clang::ento::PathDiagnostic::resetPath", NM="_ZN5clang4ento14PathDiagnostic9resetPathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic9resetPathEv")
  //</editor-fold>
  public void resetPath() {
    pathStack.clear();
    pathImpl.clear();
    Loc.$assignMove(new PathDiagnosticLocation());
  }

  
  /// \brief If the last piece of the report point to the header file, resets
  /// the location of the report to be the last location in the main source
  /// file.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::resetDiagnosticLocationToMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 152,
   FQN="clang::ento::PathDiagnostic::resetDiagnosticLocationToMainFile", NM="_ZN5clang4ento14PathDiagnostic33resetDiagnosticLocationToMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic33resetDiagnosticLocationToMainFileEv")
  //</editor-fold>
  public void resetDiagnosticLocationToMainFile() {
    if (_path.empty()) {
      return;
    }
    
    PathDiagnosticPiece /*P*/ LastP = _path.back$Const().get();
    assert Native.$bool(LastP);
    final /*const*/ SourceManager /*&*/ SMgr = LastP.getLocation().getManager();
    {
      
      // We only need to check if the report ends inside headers, if the last piece
      // is a call piece.
      PathDiagnosticCallPiece /*P*/ CP = dyn_cast_PathDiagnosticCallPiece(LastP);
      if ((CP != null)) {
        CP = PathDiagnosticStatics.getFirstStackedCallToHeaderFile(CP, SMgr);
        if ((CP != null)) {
          // Mark the piece.
          CP.setAsLastInMainSourceFile();
          
          // Update the path diagnostic message.
          /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(CP.getCallee());
          if ((ND != null)) {
            raw_svector_ostream os = null;
            try {
              SmallString/*<200>*/ buf/*J*/= new SmallString/*<200>*/(200);
              os/*J*/= new raw_svector_ostream(buf);
              $out_raw_ostream_DeclarationName(os.$out(/*KEEP_STR*/" (within a call to '"), ND.getDeclName()).$out(/*KEEP_STR*/"')");
              appendToDesc(os.str());
            } finally {
              if (os != null) { os.$destroy(); }
            }
          }
          
          // Reset the report containing declaration and location.
          DeclWithIssue = CP.getCaller();
          Loc.$assignMove(CP.getLocation());
          
          return;
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getVerboseDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 792,
   FQN="clang::ento::PathDiagnostic::getVerboseDescription", NM="_ZNK5clang4ento14PathDiagnostic21getVerboseDescriptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic21getVerboseDescriptionEv")
  //</editor-fold>
  public StringRef getVerboseDescription() /*const*/ {
    return new StringRef(VerboseDesc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getShortDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 793,
   FQN="clang::ento::PathDiagnostic::getShortDescription", NM="_ZNK5clang4ento14PathDiagnostic19getShortDescriptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic19getShortDescriptionEv")
  //</editor-fold>
  public StringRef getShortDescription() /*const*/ {
    return new StringRef(ShortDesc.empty() ? VerboseDesc : ShortDesc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getCheckName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 796,
   FQN="clang::ento::PathDiagnostic::getCheckName", NM="_ZNK5clang4ento14PathDiagnostic12getCheckNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic12getCheckNameEv")
  //</editor-fold>
  public StringRef getCheckName() /*const*/ {
    return new StringRef(CheckName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 797,
   FQN="clang::ento::PathDiagnostic::getBugType", NM="_ZNK5clang4ento14PathDiagnostic10getBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic10getBugTypeEv")
  //</editor-fold>
  public StringRef getBugType() /*const*/ {
    return new StringRef(BugType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 798,
   FQN="clang::ento::PathDiagnostic::getCategory", NM="_ZNK5clang4ento14PathDiagnostic11getCategoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic11getCategoryEv")
  //</editor-fold>
  public StringRef getCategory() /*const*/ {
    return new StringRef(Category);
  }

  
  /// Return the semantic context where an issue occurred.  If the
  /// issue occurs along a path, this represents the "central" area
  /// where the bug manifests.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getDeclWithIssue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 803,
   FQN="clang::ento::PathDiagnostic::getDeclWithIssue", NM="_ZNK5clang4ento14PathDiagnostic16getDeclWithIssueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic16getDeclWithIssueEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDeclWithIssue() /*const*/ {
    return DeclWithIssue;
  }

  
  // JAVA: typedef std::deque<std::string>::const_iterator meta_iterator
//  public final class meta_iterator extends std.deque.iterator<std.string>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::meta_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 806,
   FQN="clang::ento::PathDiagnostic::meta_begin", NM="_ZNK5clang4ento14PathDiagnostic10meta_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic10meta_beginEv")
  //</editor-fold>
  public std.deque.iterator<std.string> meta_begin() /*const*/ {
    return OtherDesc.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::meta_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 807,
   FQN="clang::ento::PathDiagnostic::meta_end", NM="_ZNK5clang4ento14PathDiagnostic8meta_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic8meta_endEv")
  //</editor-fold>
  public std.deque.iterator<std.string> meta_end() /*const*/ {
    return OtherDesc.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::addMeta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 808,
   FQN="clang::ento::PathDiagnostic::addMeta", NM="_ZN5clang4ento14PathDiagnostic7addMetaEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic7addMetaEN4llvm9StringRefE")
  //</editor-fold>
  public void addMeta(StringRef s) {
    OtherDesc.push_back_T$RR(s.$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 810,
   FQN="clang::ento::PathDiagnostic::getLocation", NM="_ZNK5clang4ento14PathDiagnostic11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic11getLocationEv")
  //</editor-fold>
  public PathDiagnosticLocation getLocation() /*const*/ {
    assert (Loc.isValid()) : "No report location set yet!";
    return new PathDiagnosticLocation(Loc);
  }

  
  /// \brief Get the location on which the report should be uniqued.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getUniqueingLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 816,
   FQN="clang::ento::PathDiagnostic::getUniqueingLoc", NM="_ZNK5clang4ento14PathDiagnostic15getUniqueingLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic15getUniqueingLocEv")
  //</editor-fold>
  public PathDiagnosticLocation getUniqueingLoc() /*const*/ {
    return new PathDiagnosticLocation(UniqueingLoc);
  }

  
  /// \brief Get the declaration containing the uniqueing location.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::getUniqueingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 821,
   FQN="clang::ento::PathDiagnostic::getUniqueingDecl", NM="_ZNK5clang4ento14PathDiagnostic16getUniqueingDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic16getUniqueingDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getUniqueingDecl() /*const*/ {
    return UniqueingDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::flattenLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 825,
   FQN="clang::ento::PathDiagnostic::flattenLocations", NM="_ZN5clang4ento14PathDiagnostic16flattenLocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento14PathDiagnostic16flattenLocationsEv")
  //</editor-fold>
  public void flattenLocations() {
    Loc.flatten();
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = pathImpl.begin(), E = pathImpl.end();
         I.$noteq(E); I.$preInc())  {
      (I.$star()).$arrow().flattenLocations();
    }
  }

  
  /// Profiles the diagnostic, independent of the path it references.
  ///
  /// This can be used to merge diagnostics that refer to the same issue
  /// along different paths.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1101,
   FQN="clang::ento::PathDiagnostic::Profile", NM="_ZNK5clang4ento14PathDiagnostic7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.Add(getLocation());
    ID.AddString(new StringRef(BugType));
    ID.AddString(new StringRef(VerboseDesc));
    ID.AddString(new StringRef(Category));
  }

  
  /// Profiles the diagnostic, including its path.
  ///
  /// Two diagnostics with the same issue along different paths will generate
  /// different profiles.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PathDiagnostic::FullProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1108,
   FQN="clang::ento::PathDiagnostic::FullProfile", NM="_ZNK5clang4ento14PathDiagnostic11FullProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZNK5clang4ento14PathDiagnostic11FullProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void FullProfile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    Profile(ID);
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = _path.begin$Const(), E = _path.end$Const(); I.$noteq(E); I.$preInc())  {
      ID.Add(I.$star().$star());
    }
    for (std.deque.iterator<std.string> I = meta_begin(), E = meta_end(); $noteq__Deque_iterator$_Tp$_Ref$_Ptr$C(I, E); I.$preInc())  {
      ID.AddString(new StringRef(I.$star()));
    }
  }

  
  @Override public String toString() {
    return "" + "CheckName=" + CheckName // NOI18N
              + ", DeclWithIssue=" + "[Decl]" // NOI18N
              + ", BugType=" + BugType // NOI18N
              + ", VerboseDesc=" + VerboseDesc // NOI18N
              + ", ShortDesc=" + ShortDesc // NOI18N
              + ", Category=" + Category // NOI18N
              + ", OtherDesc=" + OtherDesc // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", pathImpl=" + pathImpl // NOI18N
              + ", pathStack=" + pathStack // NOI18N
              + ", UniqueingLoc=" + UniqueingLoc // NOI18N
              + ", UniqueingDecl=" + "[Decl]" // NOI18N
              + ", _path=" + _path // NOI18N
              + super.toString(); // NOI18N
  }
}
