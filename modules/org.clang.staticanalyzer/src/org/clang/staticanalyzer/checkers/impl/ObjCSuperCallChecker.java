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

package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.staticanalyzer.java.*;


//===----------------------------------------------------------------------===//
// ObjCSuperCallChecker
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperCallChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 65,
 FQN="(anonymous namespace)::ObjCSuperCallChecker", NM="_ZN12_GLOBAL__N_120ObjCSuperCallCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZN12_GLOBAL__N_120ObjCSuperCallCheckerE")
//</editor-fold>
public class ObjCSuperCallChecker extends /*public*/ Checker/*T<ASTDecl<ObjCImplementationDecl> > */
        implements org.clang.staticanalyzer.java.ASTDeclChecker<ObjCImplementationDecl>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperCallChecker::ObjCSuperCallChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 68,
   FQN="(anonymous namespace)::ObjCSuperCallChecker::ObjCSuperCallChecker", NM="_ZN12_GLOBAL__N_120ObjCSuperCallCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZN12_GLOBAL__N_120ObjCSuperCallCheckerC1Ev")
  //</editor-fold>
  public ObjCSuperCallChecker() {
    // : Checker<ASTDecl<ObjCImplementationDecl> >(), SelectorsForClass(), IsInitialized(false) 
    //START JInit
    super();
    this.SelectorsForClass = new StringMap<SmallSet<Selector>>(new SmallSet<Selector>(16, Selector.DEFAULT, Selector.COMPARATOR));
    this.IsInitialized = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperCallChecker::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 166,
   FQN="(anonymous namespace)::ObjCSuperCallChecker::checkASTDecl", NM="_ZNK12_GLOBAL__N_120ObjCSuperCallChecker12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZNK12_GLOBAL__N_120ObjCSuperCallChecker12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ ObjCImplementationDecl /*P*/ D, 
              final AnalysisManager /*&*/ Mgr, 
              final BugReporter /*&*/ BR) /*const*/ {
    final ASTContext /*&*/ Ctx = BR.getContext();
    
    // We need to initialize the selector table once.
    if (!IsInitialized) {
      initializeSelectors(Ctx);
    }
    
    // Find out whether this class has a superclass that we are supposed to check.
    StringRef SuperclassName/*J*/= new StringRef();
    if (!isCheckableClass(D, SuperclassName)) {
      return;
    }
    
    // Iterate over all instance methods.
    for (ObjCMethodDecl /*P*/ MD : D.instance_methods()) {
      Selector S = MD.getSelector();
      // Find out whether this is a selector that we want to check.
      if (!(SelectorsForClass.$at(/*NO_COPY*/SuperclassName).count(S) != 0)) {
        continue;
      }
      
      // Check if the method calls its superclass implementation.
      if ((MD.getBody() != null)) {
        FindSuperCallVisitor Visitor/*J*/= new FindSuperCallVisitor(new Selector(S));
        Visitor.TraverseDecl(MD);
        
        // It doesn't call super, emit a diagnostic.
        if (!Visitor.DoesCallSuper) {
          raw_svector_ostream os = null;
          try {
            PathDiagnosticLocation DLoc = PathDiagnosticLocation.createEnd(MD.getBody(), 
                BR.getSourceManager(), 
                new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, Mgr.getAnalysisDeclContext(D)));
            
            /*const*/char$ptr/*char P*/ Name = $("Missing call to superclass");
            SmallString/*320*/ Buf/*J*/= new SmallString/*320*/(320);
            os/*J*/= new raw_svector_ostream(Buf);
            
            $out_raw_ostream_ObjCImplementationDecl$C(os.$out(/*KEEP_STR*/"The '").$out(S.getAsString()).$out(
                    /*KEEP_STR*/"' instance method in "
                ).$out(SuperclassName.str()).$out(/*KEEP_STR*/" subclass '"), 
                $Deref(D)).$out(/*KEEP_STR*/"' is missing a [super ").$out(S.getAsString()).$out(/*KEEP_STR*/"] call");
            
            BR.EmitBasicReport(MD, this, new StringRef(Name), new StringRef(categories.CoreFoundationObjectiveC), 
                os.str(), new PathDiagnosticLocation(DLoc));
          } finally {
            if (os != null) { os.$destroy(); }
          }
        }
      }
    }
  }

/*private:*/
  
  /// \brief Determine whether the given class has a superclass that we want
  /// to check. The name of the found superclass is stored in SuperclassName.
  ///
  /// \param D The declaration to check for superclasses.
  /// \param[out] SuperclassName On return, the found superclass name.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperCallChecker::isCheckableClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 89,
   FQN="(anonymous namespace)::ObjCSuperCallChecker::isCheckableClass", NM="_ZNK12_GLOBAL__N_120ObjCSuperCallChecker16isCheckableClassEPKN5clang22ObjCImplementationDeclERN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZNK12_GLOBAL__N_120ObjCSuperCallChecker16isCheckableClassEPKN5clang22ObjCImplementationDeclERN4llvm9StringRefE")
  //</editor-fold>
  private boolean isCheckableClass(/*const*/ ObjCImplementationDecl /*P*/ D, 
                  final StringRef /*&*/ SuperclassName) /*const*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ ID = D.getClassInterface$Const().getSuperClass();
    for (; (ID != null); ID = ID.getSuperClass()) {
      SuperclassName.$assignMove(ID.getIdentifier().getName());
      if ((SelectorsForClass.count(/*NO_COPY*/SuperclassName) != 0)) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperCallChecker::initializeSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 119,
   FQN="(anonymous namespace)::ObjCSuperCallChecker::initializeSelectors", NM="_ZNK12_GLOBAL__N_120ObjCSuperCallChecker19initializeSelectorsERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZNK12_GLOBAL__N_120ObjCSuperCallChecker19initializeSelectorsERN5clang10ASTContextE")
  //</editor-fold>
  private void initializeSelectors(final ASTContext /*&*/ Ctx) /*const*/ {
    { // Initialize selectors for: UIViewController
      /*const*/ SelectorDescriptor Selectors[/*13*/] = new /*const*/ SelectorDescriptor [/*13*/] {
        new SelectorDescriptor($("addChildViewController"), 1), 
        new SelectorDescriptor($("viewDidAppear"), 1), 
        new SelectorDescriptor($("viewDidDisappear"), 1), 
        new SelectorDescriptor($("viewWillAppear"), 1), 
        new SelectorDescriptor($("viewWillDisappear"), 1), 
        new SelectorDescriptor($("removeFromParentViewController"), 0), 
        new SelectorDescriptor($("didReceiveMemoryWarning"), 0), 
        new SelectorDescriptor($("viewDidUnload"), 0), 
        new SelectorDescriptor($("viewDidLoad"), 0), 
        new SelectorDescriptor($("viewWillUnload"), 0), 
        new SelectorDescriptor($("updateViewConstraints"), 0), 
        new SelectorDescriptor($("encodeRestorableStateWithCoder"), 1), 
        new SelectorDescriptor($("restoreStateWithCoder"), 1)};
      
      fillSelectors(Ctx, new ArrayRef<SelectorDescriptor>(Selectors, false), new StringRef(/*KEEP_STR*/"UIViewController"));
    }
    { // Initialize selectors for: UIResponder
      /*const*/ SelectorDescriptor Selectors[/*1*/] = new /*const*/ SelectorDescriptor [/*1*/] {new SelectorDescriptor($("resignFirstResponder"), 0)};
      
      fillSelectors(Ctx, new ArrayRef<SelectorDescriptor>(Selectors, false), new StringRef(/*KEEP_STR*/"UIResponder"));
    }
    { // Initialize selectors for: NSResponder
      /*const*/ SelectorDescriptor Selectors[/*2*/] = new /*const*/ SelectorDescriptor [/*2*/] {
        new SelectorDescriptor($("encodeRestorableStateWithCoder"), 1), 
        new SelectorDescriptor($("restoreStateWithCoder"), 1)};
      
      fillSelectors(Ctx, new ArrayRef<SelectorDescriptor>(Selectors, false), new StringRef(/*KEEP_STR*/"NSResponder"));
    }
    { // Initialize selectors for: NSDocument
      /*const*/ SelectorDescriptor Selectors[/*2*/] = new /*const*/ SelectorDescriptor [/*2*/] {
        new SelectorDescriptor($("encodeRestorableStateWithCoder"), 1), 
        new SelectorDescriptor($("restoreStateWithCoder"), 1)};
      
      fillSelectors(Ctx, new ArrayRef<SelectorDescriptor>(Selectors, false), new StringRef(/*KEEP_STR*/"NSDocument"));
    }
    
    IsInitialized = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperCallChecker::fillSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 101,
   FQN="(anonymous namespace)::ObjCSuperCallChecker::fillSelectors", NM="_ZNK12_GLOBAL__N_120ObjCSuperCallChecker13fillSelectorsERN5clang10ASTContextEN4llvm8ArrayRefINS_18SelectorDescriptorEEENS4_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZNK12_GLOBAL__N_120ObjCSuperCallChecker13fillSelectorsERN5clang10ASTContextEN4llvm8ArrayRefINS_18SelectorDescriptorEEENS4_9StringRefE")
  //</editor-fold>
  private void fillSelectors(final ASTContext /*&*/ Ctx, 
               ArrayRef<SelectorDescriptor> Sel, 
               StringRef ClassName) /*const*/ {
    final SmallSet<Selector> /*&*/ ClassSelectors = SelectorsForClass.$at(/*NO_COPY*/ClassName);
    // Fill the Selectors SmallSet with all selectors we want to check.
    for (type$ptr<SelectorDescriptor> I = $tryClone(Sel.begin()), /*P*/ E = $tryClone(Sel.end());
         $noteq_ptr(I, E); I.$preInc()) {
      SelectorDescriptor Descriptor = new SelectorDescriptor(I.$star());
      assert ($lesseq_uint(Descriptor.ArgumentCount, 1)); // No multi-argument selectors yet.
      
      // Get the selector.
      type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf(Ctx.Idents.get(new StringRef(Descriptor.SelectorName))));
      
      Selector Sel$1 = Ctx.Selectors.getSelector(Descriptor.ArgumentCount, $AddrOf(II));
      ClassSelectors.insert(Sel$1);
    }
  }

  private /*mutable */StringMap<SmallSet<Selector>> SelectorsForClass;
  private /*mutable */boolean IsInitialized;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCSuperCallChecker::~ObjCSuperCallChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp", line = 65,
   FQN="(anonymous namespace)::ObjCSuperCallChecker::~ObjCSuperCallChecker", NM="_ZN12_GLOBAL__N_120ObjCSuperCallCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCMissingSuperCallChecker.cpp -nm=_ZN12_GLOBAL__N_120ObjCSuperCallCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    SelectorsForClass.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new ASTDecl<ObjCImplementationDecl>(ObjCImplementationDecl.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SelectorsForClass=" + SelectorsForClass // NOI18N
              + ", IsInitialized=" + IsInitialized // NOI18N
              + super.toString(); // NOI18N
  }
}
