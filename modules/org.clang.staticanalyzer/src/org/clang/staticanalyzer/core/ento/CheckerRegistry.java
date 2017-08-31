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

package org.clang.staticanalyzer.core.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.staticanalyzer.core.impl.CheckerRegistryStatics.*;


/// Manages a set of available checkers for running a static analysis.
/// The checkers are organized into packages by full name, where including
/// a package will recursively include all subpackages and checkers within it.
/// For example, the checker "core.builtin.NoReturnFunctionChecker" will be
/// included if initializeManager() is called with an option of "core",
/// "core.builtin", or the full name "core.builtin.NoReturnFunctionChecker".
//<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 80,
 FQN="clang::ento::CheckerRegistry", NM="_ZN5clang4ento15CheckerRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento15CheckerRegistryE")
//</editor-fold>
public class CheckerRegistry implements Destructors.ClassWithDestructor {
/*public:*/
  /// Initialization functions perform any necessary setup for a checker.
  /// They should include a call to CheckerManager::registerChecker.
  /*typedef void (*InitializationFunction)(CheckerManager &)*/;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::CheckerInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 85,
   FQN="clang::ento::CheckerRegistry::CheckerInfo", NM="_ZN5clang4ento15CheckerRegistry11CheckerInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento15CheckerRegistry11CheckerInfoE")
  //</editor-fold>
  public static class/*struct*/ CheckerInfo implements NativeCloneable<CheckerInfo> {
    public CheckerManager2Void Initialize;
    public StringRef FullName;
    public StringRef Desc;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::CheckerInfo::CheckerInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 90,
     FQN="clang::ento::CheckerRegistry::CheckerInfo::CheckerInfo", NM="_ZN5clang4ento15CheckerRegistry11CheckerInfoC1EPFvRNS0_14CheckerManagerEEN4llvm9StringRefES8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento15CheckerRegistry11CheckerInfoC1EPFvRNS0_14CheckerManagerEEN4llvm9StringRefES8_")
    //</editor-fold>
    public CheckerInfo(CheckerManager2Void fn, StringRef name, StringRef desc) {
      // : Initialize(fn), FullName(name), Desc(desc) 
      //START JInit
      this.Initialize = $tryClone(fn);
      this.FullName = new StringRef(name);
      this.Desc = new StringRef(desc);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::CheckerInfo::CheckerInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 85,
     FQN="clang::ento::CheckerRegistry::CheckerInfo::CheckerInfo", NM="_ZN5clang4ento15CheckerRegistry11CheckerInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZN5clang4ento15CheckerRegistry11CheckerInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ CheckerInfo(JD$Move _dparam, final CheckerInfo /*&&*/$Prm0) {
      // : Initialize(static_cast<CheckerInfo &&>().Initialize), FullName(static_cast<CheckerInfo &&>().FullName), Desc(static_cast<CheckerInfo &&>().Desc) 
      //START JInit
      this.Initialize = $tryClone($Prm0.Initialize);
      this.FullName = new StringRef(JD$Move.INSTANCE, $Prm0.FullName);
      this.Desc = new StringRef(JD$Move.INSTANCE, $Prm0.Desc);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::CheckerInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 85,
     FQN="clang::ento::CheckerRegistry::CheckerInfo::operator=", NM="_ZN5clang4ento15CheckerRegistry11CheckerInfoaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZN5clang4ento15CheckerRegistry11CheckerInfoaSEOS2_")
    //</editor-fold>
    public /*inline*/ CheckerInfo /*&*/ $assignMove(final CheckerInfo /*&&*/$Prm0) {
      this.Initialize = $tryClone($Prm0.Initialize);
      this.FullName.$assignMove($Prm0.FullName);
      this.Desc.$assignMove($Prm0.Desc);
      return /*Deref*/this;
    }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

    public CheckerInfo() { this(null, StringRef.R$EMPTY, StringRef.R$EMPTY); }

    @Override public CheckerInfo clone() { return new CheckerInfo(this.Initialize, this.FullName, this.Desc); }
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Initialize=" + Initialize // NOI18N
                + ", FullName=" + FullName // NOI18N
                + ", Desc=" + Desc; // NOI18N
    }
  };
  
  /*typedef std::vector<CheckerInfo> CheckerInfoList*/
//  public final class CheckerInfoList extends std.vector<CheckerInfo>{ };
/*private:*/
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::initializeManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 98,
   FQN="clang::ento::CheckerRegistry::initializeManager", NM="Tpl__ZN5clang4ento15CheckerRegistry17initializeManagerERNS0_14CheckerManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=Tpl__ZN5clang4ento15CheckerRegistry17initializeManagerERNS0_14CheckerManagerE")
  //</editor-fold>
  private static </*typename*/ T extends CheckerBase> void initializeManager$T(Class<T> cls, final CheckerManager /*&*/ mgr) {
    mgr.registerChecker(cls);
  }

/*public:*/
  /// Adds a checker to the registry. Use this non-templated overload when your
  /// checker requires custom initialization.
  /// Adds a checker to the registry. Use this non-templated overload when your
  /// checker requires custom initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::addChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 84,
   FQN="clang::ento::CheckerRegistry::addChecker", NM="_ZN5clang4ento15CheckerRegistry10addCheckerEPFvRNS0_14CheckerManagerEEN4llvm9StringRefES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZN5clang4ento15CheckerRegistry10addCheckerEPFvRNS0_14CheckerManagerEEN4llvm9StringRefES7_")
  //</editor-fold>
  public void addChecker(CheckerManager2Void fn, StringRef name, 
            StringRef desc) {
    Checkers.push_back_T$RR(new CheckerInfo(fn, new StringRef(name), new StringRef(desc)));
    
    // Record the presence of the checker in its packages.
    StringRef packageName/*J*/= new StringRef();
    StringRef leafName/*J*/= new StringRef();
    // JAVA: unfold std.tie(packageName, leafName).$assign($rsplit);
    std.pairTypeType<StringRef, StringRef> $rsplit = name.rsplit(PackageSeparator);
    packageName.$assign($rsplit.first);
    leafName.$assign($rsplit.second);
    while (!leafName.empty()) {
      Packages.$set(/*NO_COPY*/packageName, Packages.$at(packageName) + 1);
      // JAVA: unfold std.tie(packageName, leafName).$assign(packageName.rsplit(PackageSeparator));
      $rsplit = packageName.rsplit(PackageSeparator);
      packageName.$assign($rsplit.first);
      leafName.$assign($rsplit.second);
    }
  }


  
  /// Adds a checker to the registry. Use this templated overload when your
  /// checker does not require any custom initialization.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::addChecker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 111,
   FQN="clang::ento::CheckerRegistry::addChecker", NM="Tpl__ZN5clang4ento15CheckerRegistry10addCheckerEN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=Tpl__ZN5clang4ento15CheckerRegistry10addCheckerEN4llvm9StringRefES3_")
  //</editor-fold>
  public </*class*/ T extends CheckerBase> void addChecker$T(Class<T> cls, StringRef fullName, StringRef desc) {
    // Avoid MSVC's Compiler Error C2276:
    // http://msdn.microsoft.com/en-us/library/850cstw1(v=VS.80).aspx
    addChecker((CheckerManager cm) -> {CheckerRegistry.initializeManager$T(cls, cm);}, //CheckerRegistry.initializeManager(cls)
               fullName, desc);
  }

  
  /// Initializes a CheckerManager by calling the initialization functions for
  /// all checkers specified by the given CheckerOptInfo list. The order of this
  /// list is significant; later options can be used to reverse earlier ones.
  /// This can be used to exclude certain checkers in an included package.
  
  /// Initializes a CheckerManager by calling the initialization functions for
  /// all checkers specified by the given CheckerOptInfo list. The order of this
  /// list is significant; later options can be used to reverse earlier ones.
  /// This can be used to exclude certain checkers in an included package.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::initializeManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 97,
   FQN="clang::ento::CheckerRegistry::initializeManager", NM="_ZNK5clang4ento15CheckerRegistry17initializeManagerERNS0_14CheckerManagerERN4llvm15SmallVectorImplINS0_14CheckerOptInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZNK5clang4ento15CheckerRegistry17initializeManagerERNS0_14CheckerManagerERN4llvm15SmallVectorImplINS0_14CheckerOptInfoEEE")
  //</editor-fold>
  public void initializeManager(final CheckerManager /*&*/ checkerMgr, 
                   final SmallVectorImpl<CheckerOptInfo> /*&*/ opts) /*const*/ {
    SetVector</*const*/ CheckerRegistry.CheckerInfo /*P*/ > enabledCheckers = null;
    try {
      // Sort checkers for efficient collection.
      std.sort(Checkers.begin(), Checkers.end(), /*FuncRef*/CheckerRegistryStatics::checkerNameLT);
      
      // Collect checkers enabled by the options.
      enabledCheckers/*J*/= new SetVector</*const*/ CheckerRegistry.CheckerInfo /*P*/ >((/*const*/ CheckerRegistry.CheckerInfo /*P*/ )null);
      for (type$ptr<CheckerOptInfo> i = $tryClone(opts.begin()), /*P*/ e = $tryClone(opts.end()); $noteq_ptr(i, e); i.$preInc()) {
        collectCheckers(Checkers, Packages, i.$star(), enabledCheckers);
      }
      
      // Initialize the CheckerManager with all enabled checkers.
      for (std.vector.iterator</*const*/ CheckerInfo /*P*/ > i = enabledCheckers.begin(), e = enabledCheckers.end(); $noteq___normal_iterator$C(i, e); i.$preInc()) {
        try {
          checkerMgr.setCurrentCheckName(new CheckName(new StringRef((i.$star()).FullName)));
          (i.$star()).Initialize.$call(checkerMgr);
        } catch (Throwable checkerInitException) {
          // JAVAFIX: checker might fire exception, but we'd like to be recoverable
          NativeTrace.printStackTraceOnce(checkerInitException);
        }
      }
    } finally {
      if (enabledCheckers != null) { enabledCheckers.$destroy(); }
    }
  }


  
  /// Check if every option corresponds to a specific checker or package.
  
  /// Check if every option corresponds to a specific checker or package.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::validateCheckerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 117,
   FQN="clang::ento::CheckerRegistry::validateCheckerOptions", NM="_ZNK5clang4ento15CheckerRegistry22validateCheckerOptionsERKNS_15AnalyzerOptionsERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZNK5clang4ento15CheckerRegistry22validateCheckerOptionsERKNS_15AnalyzerOptionsERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public void validateCheckerOptions(final /*const*/ AnalyzerOptions /*&*/ opts, 
                        final DiagnosticsEngine /*&*/ diags) /*const*/ {
    for (final /*const*/ StringMapEntry<std.string> /*&*/ config : opts.Config) {
      /*size_t*/int pos = config.getKey().find($$COLON);
      if (pos == StringRef.npos) {
        continue;
      }
      
      boolean hasChecker = false;
      StringRef checkerName = config.getKey().substr(0, pos);
      for (final CheckerInfo /*&*/ checker : Checkers) {
        if (checker.FullName.startswith(/*NO_COPY*/checkerName)
           && (checker.FullName.size() == pos || checker.FullName.$at(pos) == $$DOT)) {
          hasChecker = true;
          break;
        }
      }
      if (!hasChecker) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(diags.Report(diag.err_unknown_analyzer_checker)), /*NO_COPY*/checkerName));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }


  
  /// Prints the name and description of all checkers in this registry.
  /// This output is not intended to be machine-parseable.
  
  /// Prints the name and description of all checkers in this registry.
  /// This output is not intended to be machine-parseable.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::printHelp">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp", line = 139,
   FQN="clang::ento::CheckerRegistry::printHelp", NM="_ZNK5clang4ento15CheckerRegistry9printHelpERN4llvm11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerRegistry.cpp -nm=_ZNK5clang4ento15CheckerRegistry9printHelpERN4llvm11raw_ostreamEj")
  //</editor-fold>
  public void printHelp(final raw_ostream /*&*/ out) /*const*/ {
    printHelp(out, 
           30);
  }
  public void printHelp(final raw_ostream /*&*/ out, 
           /*size_t*/int maxNameChars/*= 30*/) /*const*/ {
    // FIXME: Alphabetical sort puts 'experimental' in the middle.
    // Would it be better to name it '~experimental' or something else
    // that's ASCIIbetically last?
    std.sort(Checkers.begin(), Checkers.end(), /*FuncRef*/CheckerRegistryStatics::checkerNameLT);
    
    // FIXME: Print available packages.
    out.$out(/*KEEP_STR*/"CHECKERS:\n");
    
    // Find the maximum option length.
    /*size_t*/int optionFieldWidth = 0;
    for (std.vector.iterator</*const*/ CheckerInfo /*P*/ > i = new std.vector.iterator</*const*/ CheckerInfo /*P*/ >(Checkers.begin()), e = new std.vector.iterator</*const*/ CheckerInfo /*P*/ >(Checkers.end());
         $noteq___normal_iterator$C(i, e); i.$preInc()) {
      // Limit the amount of padding we are willing to give up for alignment.
      //   Package.Name     Description  [Hidden]
      /*size_t*/int nameLength = i.$arrow().FullName.size();
      if ($lesseq_uint(nameLength, maxNameChars)) {
        optionFieldWidth = std.max(optionFieldWidth, nameLength);
      }
    }
    
    /*const*//*size_t*/int initialPad = 2;
    for (std.vector.iterator</*const*/ CheckerInfo /*P*/ > i = new std.vector.iterator</*const*/ CheckerInfo /*P*/ >(Checkers.begin()), e = new std.vector.iterator</*const*/ CheckerInfo /*P*/ >(Checkers.end());
         $noteq___normal_iterator$C(i, e); i.$preInc()) {
      out.indent(initialPad).$out(/*NO_COPY*/i.$arrow().FullName);
      
      int pad = optionFieldWidth - i.$arrow().FullName.size();
      
      // Break on long option names.
      if (pad < 0) {
        out.$out_char($$LF);
        pad = optionFieldWidth + initialPad;
      }
      out.indent(pad + 2).$out(/*NO_COPY*/i.$arrow().Desc);
      
      out.$out_char($$LF);
    }
  }


/*private:*/
  private /*mutable */std.vector<CheckerInfo> Checkers;
  private /*mutable */StringMapUInt Packages;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::~CheckerRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 80,
   FQN="clang::ento::CheckerRegistry::~CheckerRegistry", NM="_ZN5clang4ento15CheckerRegistryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento15CheckerRegistryD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Packages.$destroy();
    Checkers.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerRegistry::CheckerRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerRegistry.h", line = 80,
   FQN="clang::ento::CheckerRegistry::CheckerRegistry", NM="_ZN5clang4ento15CheckerRegistryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento15CheckerRegistryC1Ev")
  //</editor-fold>
  public /*inline*/ CheckerRegistry() {
    // : Checkers(), Packages() 
    //START JInit
    this.Checkers = new std.vector<CheckerInfo>(new CheckerInfo());
    this.Packages = new StringMapUInt((/*size_t*/int)0);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Checkers=" + Checkers // NOI18N
              + ", Packages=" + Packages; // NOI18N
  }
}
