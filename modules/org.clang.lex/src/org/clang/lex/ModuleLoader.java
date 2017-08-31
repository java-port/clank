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
package org.clang.lex;

import org.clang.lex.llvm.ModuleIdPath;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.spi.GlobalModuleIndexImplementation;


/// \brief Abstract interface for a module loader.
///
/// This abstract interface describes a module loader, which is responsible
/// for resolving a module name (e.g., "std") to an actual module file, and
/// then loading that module.
//<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 56,
 FQN="clang::ModuleLoader", NM="_ZN5clang12ModuleLoaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoaderE")
//</editor-fold>
public abstract class ModuleLoader implements Destructors.ClassWithDestructor {
  // Building a module if true.
  private boolean BuildingModule;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::ModuleLoader">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 60,
   FQN = "clang::ModuleLoader::ModuleLoader", NM = "_ZN5clang12ModuleLoaderC1Eb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoaderC1Eb")
  //</editor-fold>
  public /*explicit*/ ModuleLoader() {
    this(false);
  }
  public /*explicit*/ ModuleLoader(boolean BuildingModule/*= false*/) {
    /* : BuildingModule(BuildingModule), HadFatalFailure(false)*/ 
    //START JInit
    this.BuildingModule = BuildingModule;
    this.HadFatalFailure = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::~ModuleLoader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", line = 904,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp", old_line = 901,
   FQN="clang::ModuleLoader::~ModuleLoader", NM="_ZN5clang12ModuleLoaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoaderD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// \brief Returns true if this instance is building a module.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::buildingModule">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 67,
   FQN = "clang::ModuleLoader::buildingModule", NM = "_ZNK5clang12ModuleLoader14buildingModuleEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZNK5clang12ModuleLoader14buildingModuleEv")
  //</editor-fold>
  public boolean buildingModule() /*const*/ {
    return BuildingModule;
  }

  /// \brief Flag indicating whether this instance is building a module.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::setBuildingModule">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 71,
   FQN = "clang::ModuleLoader::setBuildingModule", NM = "_ZN5clang12ModuleLoader17setBuildingModuleEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoader17setBuildingModuleEb")
  //</editor-fold>
  public void setBuildingModule(boolean BuildingModuleFlag) {
    BuildingModule = BuildingModuleFlag;
  }

  
  /// \brief Attempt to load the given module.
  ///
  /// This routine attempts to load the module described by the given 
  /// parameters.
  ///
  /// \param ImportLoc The location of the 'import' keyword.
  ///
  /// \param Path The identifiers (and their locations) of the module
  /// "path", e.g., "std.vector" would be split into "std" and "vector".
  /// 
  /// \param Visibility The visibility provided for the names in the loaded
  /// module.
  ///
  /// \param IsInclusionDirective Indicates that this module is being loaded
  /// implicitly, due to the presence of an inclusion directive. Otherwise,
  /// it is being loaded due to an import declaration.
  ///
  /// \returns If successful, returns the loaded module. Otherwise, returns 
  /// NULL to indicate that the module could not be loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::loadModule">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 94,
   FQN = "clang::ModuleLoader::loadModule", NM = "_ZN5clang12ModuleLoader10loadModuleENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEENS_6Module18NameVisibilityKindEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoader10loadModuleENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEENS_6Module18NameVisibilityKindEb")
  //</editor-fold>
  public abstract /*virtual*/ ModuleLoadResult loadModule(SourceLocation ImportLoc, 
            ModuleIdPath Path, 
            Module.NameVisibilityKind Visibility, 
            boolean IsInclusionDirective)/* = 0*/;

  
  /// \brief Make the given module visible.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::makeModuleVisible">
  @Converted(kind = Converted.Kind.DELETED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 100,
   FQN="clang::ModuleLoader::makeModuleVisible", NM="_ZN5clang12ModuleLoader17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoader17makeModuleVisibleEPNS_6ModuleENS1_18NameVisibilityKindENS_14SourceLocationE")
  //</editor-fold>
  public abstract /*virtual*/ void makeModuleVisible(Module /*P*/ Mod, 
                   Module.NameVisibilityKind Visibility, 
                   SourceLocation ImportLoc)/* = 0*/;

  
  /// \brief Load, create, or return global module.
  /// This function returns an existing global module index, if one
  /// had already been loaded or created, or loads one if it
  /// exists, or creates one if it doesn't exist.
  /// Also, importantly, if the index doesn't cover all the modules
  /// in the module map, it will be update to do so here, because
  /// of its use in searching for needed module imports and
  /// associated fixit messages.
  /// \param TriggerLoc The location for what triggered the load.
  /// \returns Returns null if load failed.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::loadGlobalModuleIndex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", old_line = 115,
   FQN = "clang::ModuleLoader::loadGlobalModuleIndex", NM = "_ZN5clang12ModuleLoader21loadGlobalModuleIndexENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoader21loadGlobalModuleIndexENS_14SourceLocationE")
  //</editor-fold>
  public abstract /*virtual*/ GlobalModuleIndexImplementation /*P*/ loadGlobalModuleIndex(SourceLocation TriggerLoc);

  
  /// Check global module index for missing imports.
  /// \param Name The symbol name to look for.
  /// \param TriggerLoc The location for what triggered the load.
  /// \returns Returns true if any modules with that symbol found.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleLoader::lookupMissingImports">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ModuleLoader.h", old_line = 122,
   FQN = "clang::ModuleLoader::lookupMissingImports", NM = "_ZN5clang12ModuleLoader20lookupMissingImportsEN4llvm9StringRefENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Preprocessor.cpp -nm=_ZN5clang12ModuleLoader20lookupMissingImportsEN4llvm9StringRefENS_14SourceLocationE")
  //</editor-fold>
  public abstract /*virtual*/ boolean lookupMissingImports(StringRef Name, 
                      SourceLocation TriggerLoc)/* = 0*/;

  
  public boolean HadFatalFailure;
  
  public String toString() {
    return "" + "BuildingModule=" + BuildingModule // NOI18N
              + ", HadFatalFailure=" + HadFatalFailure; // NOI18N
  }
}
