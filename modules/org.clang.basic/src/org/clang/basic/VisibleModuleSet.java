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

package org.clang.basic;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.Module.Conflict;
import org.clang.basic.java.BasicFunctionPointers.*;


/// \brief A set of visible modules.
//<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 508,
 FQN="clang::VisibleModuleSet", NM="_ZN5clang16VisibleModuleSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang16VisibleModuleSetE")
//</editor-fold>
public class VisibleModuleSet implements Destructors.ClassWithDestructor, NativeCloneable<VisibleModuleSet>, NativeMoveable<VisibleModuleSet> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::VisibleModuleSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 510,
   FQN="clang::VisibleModuleSet::VisibleModuleSet", NM="_ZN5clang16VisibleModuleSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang16VisibleModuleSetC1Ev")
  //</editor-fold>
  public VisibleModuleSet() {
    /* : ImportLocs(), Generation(0)*/ 
    //START JInit
    this.ImportLocs = new std.vector<SourceLocation>(new SourceLocation());
    this.Generation = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::VisibleModuleSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 511,
   FQN="clang::VisibleModuleSet::VisibleModuleSet", NM="_ZN5clang16VisibleModuleSetC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang16VisibleModuleSetC1EOS0_")
  //</editor-fold>
  public VisibleModuleSet(JD$Move _dparam, VisibleModuleSet /*&&*/O) {
    /* : ImportLocs(std::move(O.ImportLocs)), Generation(O.Generation ? 1 : 0)*/ 
    //START JInit
    this.ImportLocs = new std.vector<SourceLocation>(JD$Move.INSTANCE, std.move(O.ImportLocs));
    this.Generation = (O.Generation != 0) ? 1 : 0;
    //END JInit
    O.ImportLocs.clear();
    ++O.Generation;
  }

  
  /// Move from another visible modules set. Guaranteed to leave the source
  /// empty and bump the generation on both.
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 519,
   FQN="clang::VisibleModuleSet::operator=", NM="_ZN5clang16VisibleModuleSetaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang16VisibleModuleSetaSEOS0_")
  //</editor-fold>
  public VisibleModuleSet /*&*/ $assignMove(VisibleModuleSet /*&&*/O) {
    ImportLocs.$assignMove(std.move(O.ImportLocs));
    O.ImportLocs.clear();
    ++O.Generation;
    ++Generation;
    return /*Deref*/this;
  }

  
  /// \brief Get the current visibility generation. Incremented each time the
  /// set of visible modules changes in any way.
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::getGeneration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 529,
   FQN="clang::VisibleModuleSet::getGeneration", NM="_ZNK5clang16VisibleModuleSet13getGenerationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang16VisibleModuleSet13getGenerationEv")
  //</editor-fold>
  public /*uint*/int getGeneration() /*const*/ {
    return Generation;
  }

  
  /// \brief Determine whether a module is visible.
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::isVisible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 532,
   FQN="clang::VisibleModuleSet::isVisible", NM="_ZNK5clang16VisibleModuleSet9isVisibleEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang16VisibleModuleSet9isVisibleEPKNS_6ModuleE")
  //</editor-fold>
  public boolean isVisible(/*const*/ Module /*P*/ M) /*const*/ {
    return getImportLoc(M).isValid();
  }

  
  /// \brief Get the location at which the import of a module was triggered.
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::getImportLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 537,
   FQN="clang::VisibleModuleSet::getImportLoc", NM="_ZNK5clang16VisibleModuleSet12getImportLocEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang16VisibleModuleSet12getImportLocEPKNS_6ModuleE")
  //</editor-fold>
  public SourceLocation getImportLoc(/*const*/ Module /*P*/ M) /*const*/ {
    return $less_uint(M.getVisibilityID(), ImportLocs.size()) ? new SourceLocation(ImportLocs.$at(M.getVisibilityID())) : new SourceLocation();
  }


  /// \brief A callback to call when a module is made visible (directly or
  /// indirectly) by a call to \ref setVisible.
  /*typedef llvm::function_ref<void (Module *)> VisibleCallback*/
//  public final class VisibleCallback extends VisibleCallback{ };
  /// \brief A callback to call when a module conflict is found. \p Path
  /// consists of a sequence of modules from the conflicting module to the one
  /// made visible, where each was exported by the next.
  /*typedef llvm::function_ref<void (ArrayRef<Module *>, Module *, StringRef)> ConflictCallback*/
//  public final class ConflictCallback extends ConflictCallback{ };
  
  // JAVA: private interfaces for lambdas used by setVisible method
  @Converted(kind = Converted.Kind.MANUAL_ADDED, /*dummy NM for upgrade tool*/NM = "_ZN5clang16VisibleModuleSetE_Unnamed_class1")
  @FunctionalInterface
  private interface Visiting2Void {
    @Converted(kind = Converted.Kind.DUMMY/*for NM*/, NM = "_ZZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEEEd0_NKUlS2_E_clES2_")
    public void $call(Visiting V);  
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED, /*dummy NM for upgrade tool*/NM="_ZN5clang16VisibleModuleSetE_Unnamed_class2")
  @FunctionalInterface
  private interface Visiting2VoidRecursive {
    @Converted(kind = Converted.Kind.DUMMY/*for NM*/, NM="_ZZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEEEd_NKUlS9_S2_SA_E_clES9_S2_SA_")
    public void $call(Visiting2VoidRecursive var, Visiting V);  
  }
  
  // JAVA: extracted from function setVisible to make it part of interface Visiting2Void
  //<editor-fold defaultstate="collapsed" desc="Visiting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 497,
   FQN="Visiting", NM="_ZZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEEE8Visiting",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEEE8Visiting")
  //</editor-fold>
  private static class/*struct*/ Visiting {
    public Module /*P*/ M;
    public Visiting /*P*/ ExportedBy;

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public Visiting(Module M, Visiting ExportedBy) {
      this.M = M;
      this.ExportedBy = ExportedBy;
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::setVisible(Module * , SourceLocation, VisibleCallback, ConflictCallback)::Visiting::Visiting">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 497,
         FQN="clang::VisibleModuleSet::setVisible(Module * , SourceLocation, VisibleCallback, ConflictCallback)::Visiting::Visiting", NM="_ZZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEEEN8VisitingC1EOSD_",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEEEN8VisitingC1EOSD_")
        //</editor-fold>
    public /*inline*/ Visiting(JD$Move _dparam, Visiting /*&&*/$Prm0) {
      /* : M(static_cast<Visiting &&>().M), ExportedBy(static_cast<Visiting &&>().ExportedBy)*/ 
      //START JInit
      this.M = $Prm0.M;
      this.ExportedBy = $Prm0.ExportedBy;
      //END JInit
    }


    public String toString() {
      return "" + "M=" + M // NOI18N
                + ", ExportedBy=" + ExportedBy; // NOI18N
    }
  };
  
  /// \brief Make a specific module visible.
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::setVisible">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 489,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 493,
   FQN="clang::VisibleModuleSet::setVisible", NM="_ZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang16VisibleModuleSet10setVisibleEPNS_6ModuleENS_14SourceLocationEN4llvm12function_refIFvS2_EEENS5_IFvNS4_8ArrayRefIS2_EES2_NS4_9StringRefEEEE")
  //</editor-fold>
  public void setVisible(Module /*P*/ M, SourceLocation Loc) {
    setVisible(M, Loc.getRawEncoding(), (Mod) -> {}, (Path, Conflict, Message) -> {});
  }
  public void setVisible(Module /*P*/ M, SourceLocation Loc, 
            VisibleCallback Vis) {
    setVisible(M, Loc.getRawEncoding(), Vis, (Path, Conflict, Message) -> {});
  }
  public void setVisible(Module /*P*/ M, SourceLocation Loc, 
            VisibleCallback Vis/*= [] (Module /*P*/, ConflictCallback Cb) {
    setVisible(M, Loc.getRawEncoding(), Vis, Cb);
  }
  public void setVisible(Module /*P*/ M, /*SourceLocation*/int Loc) {
    setVisible(M, Loc, (Mod) -> {}, (Path, Conflict, Message) -> {});
  }
  public void setVisible(Module /*P*/ M, /*SourceLocation*/int Loc, 
            VisibleCallback Vis) {
    setVisible(M, Loc, Vis, (Path, Conflict, Message) -> {});
  }
  public void setVisible(Module /*P*/ M, /*SourceLocation*/int Loc, 
            VisibleCallback Vis/*= [] (Module /*P*/, ConflictCallback Cb) {
    Visiting2Void VisitModule = null;
    try {
      assert (SourceLocation.isValid(Loc)) : "setVisible expects a valid import location";
      if (isVisible(M)) {
        return;
      }

      ++Generation;

      // JAVA: added first parameter to the lambda to allow recursion
      final Visiting2VoidRecursive $VisitModule = (F, V) -> 
      {
        // Modules that aren't available cannot be made visible.
        if (!V.M.isAvailable()) {
          return;
        }

        // Nothing to do for a module that's already visible.
        /*uint*/int ID = V.M.getVisibilityID();
        if ($lesseq_uint(ImportLocs.size(), ID)) {
          ImportLocs.resize(ID + 1);
        } else if (ImportLocs.$at(ID).isValid()) {
          return;
        }

        ImportLocs.$at(ID).$assign(Loc);
        Vis.$call(M);

        // Make any exported modules visible.
        SmallVector<Module /*P*/> Exports/*J*/= new SmallVector<Module /*P*/>(16, (Module /*P*/)null);
        V.M.getExportedModules(Exports);
        for (Module /*P*/ E : Exports)  {
          F.$call(F, new Visiting(E, $AddrOf(V)));
        }

        for (Conflict /*&*/ C : V.M.Conflicts) {
          if (isVisible(C.Other)) {
            SmallVector<Module /*P*/> Path/*J*/= new SmallVector<Module /*P*/>(8, (Module /*P*/)null);
            for (Visiting /*P*/ I = $AddrOf(V); (I != null); I = I.ExportedBy)  {
              Path.push_back(I.M);
            }
            Cb.$call(new ArrayRef<Module /*P*/ >(Path), C.Other, new StringRef(C.Message));
          }
        }
      };
            
      // JAVA: visit module calls recursive implementation
      VisitModule = (V) -> {
        $VisitModule.$call($VisitModule, V);
      };
    
      VisitModule.$call(new Visiting(M, (Visiting /*P*/ )null));
    } finally {
      //if (VisitModule != null) { VisitModule.$destroy(); }
    }
  }

/*private:*/
  /// Import locations for each visible module. Indexed by the module's
  /// VisibilityID.
  private std.vector<SourceLocation> ImportLocs;
  /// Visibility generation, bumped every time the visibility state changes.
  private /*uint*/int Generation;
  //<editor-fold defaultstate="collapsed" desc="clang::VisibleModuleSet::~VisibleModuleSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 508,
   FQN="clang::VisibleModuleSet::~VisibleModuleSet", NM="_ZN5clang16VisibleModuleSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang16VisibleModuleSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ImportLocs.$destroy();
    //END JDestroy
  }

  @Override public VisibleModuleSet clone() {
    // only for check of cloneable, in collections have to use move
    assert this.Generation == 0 : "only empty is expected here";
    assert this.ImportLocs.empty() : "only empty is expected here";
    return new VisibleModuleSet();
  }

  @Override public VisibleModuleSet move() {
    return new VisibleModuleSet(JD$Move.INSTANCE, this);
  }

  public String toString() {
    return "" + "ImportLocs=" + ImportLocs // NOI18N
              + ", Generation=" + Generation; // NOI18N
  }
}
