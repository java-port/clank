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

package org.llvm.transforms.utils;

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
import org.llvm.ir.*;


/// Class to handle necessary GlobalValue changes required by ThinLTO
/// function importing, including linkage changes and any necessary renaming.
//<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 26,
 FQN="llvm::FunctionImportGlobalProcessing", NM="_ZN4llvm30FunctionImportGlobalProcessingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessingE")
//</editor-fold>
public class FunctionImportGlobalProcessing {
  /// The Module which we are exporting or importing functions from.
  private final Module /*&*/ M;
  
  /// Module summary index passed in for function importing/exporting handling.
  private final /*const*/ ModuleSummaryIndex /*&*/ ImportIndex;
  
  /// Globals to import from this module, all other functions will be
  /// imported as declarations instead of definitions.
  private DenseSet</*const*/ GlobalValue /*P*/ > /*P*/ GlobalsToImport;
  
  /// Set to true if the given ModuleSummaryIndex contains any functions
  /// from this source module, in which case we must conservatively assume
  /// that any of its functions may be imported into another module
  /// as part of a different backend compilation process.
  private boolean HasExportedFunctions/* = false*/;
  
  /// Check if we should promote the given local value to global scope.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::doPromoteLocalToGlobal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 44,
   FQN="llvm::FunctionImportGlobalProcessing::doPromoteLocalToGlobal", NM="_ZN4llvm30FunctionImportGlobalProcessing22doPromoteLocalToGlobalEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing22doPromoteLocalToGlobalEPKNS_11GlobalValueE")
  //</editor-fold>
  private boolean doPromoteLocalToGlobal(/*const*/ GlobalValue /*P*/ SGV) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Helper methods to check if we are importing from or potentially
  /// exporting from the current source module.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::isPerformingImport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 48,
   FQN="llvm::FunctionImportGlobalProcessing::isPerformingImport", NM="_ZNK4llvm30FunctionImportGlobalProcessing18isPerformingImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZNK4llvm30FunctionImportGlobalProcessing18isPerformingImportEv")
  //</editor-fold>
  private boolean isPerformingImport() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::isModuleExporting">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 49,
   FQN="llvm::FunctionImportGlobalProcessing::isModuleExporting", NM="_ZNK4llvm30FunctionImportGlobalProcessing17isModuleExportingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZNK4llvm30FunctionImportGlobalProcessing17isModuleExportingEv")
  //</editor-fold>
  private boolean isModuleExporting() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// If we are importing from the source module, checks if we should
  /// import SGV as a definition, otherwise import as a declaration.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::doImportAsDefinition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 53,
   FQN="llvm::FunctionImportGlobalProcessing::doImportAsDefinition", NM="_ZN4llvm30FunctionImportGlobalProcessing20doImportAsDefinitionEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing20doImportAsDefinitionEPKNS_11GlobalValueE")
  //</editor-fold>
  private boolean doImportAsDefinition(/*const*/ GlobalValue /*P*/ SGV) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get the name for SGV that should be used in the linked destination
  /// module. Specifically, this handles the case where we need to rename
  /// a local that is being promoted to global scope.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 58,
   FQN="llvm::FunctionImportGlobalProcessing::getName", NM="_ZN4llvm30FunctionImportGlobalProcessing7getNameEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing7getNameEPKNS_11GlobalValueE")
  //</editor-fold>
  private std.string getName(/*const*/ GlobalValue /*P*/ SGV) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Process globals so that they can be used in ThinLTO. This includes
  /// promoting local variables so that they can be reference externally by
  /// thin lto imported globals and converting strong external globals to
  /// available_externally.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::processGlobalsForThinLTO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 64,
   FQN="llvm::FunctionImportGlobalProcessing::processGlobalsForThinLTO", NM="_ZN4llvm30FunctionImportGlobalProcessing24processGlobalsForThinLTOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing24processGlobalsForThinLTOEv")
  //</editor-fold>
  private void processGlobalsForThinLTO() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::processGlobalForThinLTO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 65,
   FQN="llvm::FunctionImportGlobalProcessing::processGlobalForThinLTO", NM="_ZN4llvm30FunctionImportGlobalProcessing23processGlobalForThinLTOERNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing23processGlobalForThinLTOERNS_11GlobalValueE")
  //</editor-fold>
  private void processGlobalForThinLTO(final GlobalValue /*&*/ GV) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get the new linkage for SGV that should be used in the linked destination
  /// module. Specifically, for ThinLTO importing or exporting it may need
  /// to be adjusted.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::getLinkage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 70,
   FQN="llvm::FunctionImportGlobalProcessing::getLinkage", NM="_ZN4llvm30FunctionImportGlobalProcessing10getLinkageEPKNS_11GlobalValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing10getLinkageEPKNS_11GlobalValueE")
  //</editor-fold>
  private GlobalValue.LinkageTypes getLinkage(/*const*/ GlobalValue /*P*/ SGV) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::FunctionImportGlobalProcessing">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 73,
   FQN="llvm::FunctionImportGlobalProcessing::FunctionImportGlobalProcessing", NM="_ZN4llvm30FunctionImportGlobalProcessingC1ERNS_6ModuleERKNS_18ModuleSummaryIndexEPNS_8DenseSetIPKNS_11GlobalValueENS_12DenseMapInfoIS9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessingC1ERNS_6ModuleERKNS_18ModuleSummaryIndexEPNS_8DenseSetIPKNS_11GlobalValueENS_12DenseMapInfoIS9_EEEE")
  //</editor-fold>
  public FunctionImportGlobalProcessing(final Module /*&*/ M, final /*const*/ ModuleSummaryIndex /*&*/ Index) {
    this(M, Index, 
      (DenseSet</*const*/ GlobalValue /*P*/ > /*P*/)null);
  }
  public FunctionImportGlobalProcessing(final Module /*&*/ M, final /*const*/ ModuleSummaryIndex /*&*/ Index, 
      DenseSet</*const*/ GlobalValue /*P*/ > /*P*/ GlobalsToImport/*= null*/) {
    // : M(M), ImportIndex(Index), GlobalsToImport(GlobalsToImport), HasExportedFunctions(false) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 85,
   FQN="llvm::FunctionImportGlobalProcessing::run", NM="_ZN4llvm30FunctionImportGlobalProcessing3runEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing3runEv")
  //</editor-fold>
  public boolean run() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionImportGlobalProcessing::doImportAsDefinition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/FunctionImportUtils.h", line = 87,
   FQN="llvm::FunctionImportGlobalProcessing::doImportAsDefinition", NM="_ZN4llvm30FunctionImportGlobalProcessing20doImportAsDefinitionEPKNS_11GlobalValueEPNS_8DenseSetIS3_NS_12DenseMapInfoIS3_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_ZN4llvm30FunctionImportGlobalProcessing20doImportAsDefinitionEPKNS_11GlobalValueEPNS_8DenseSetIS3_NS_12DenseMapInfoIS3_EEEE")
  //</editor-fold>
  public static boolean doImportAsDefinition(/*const*/ GlobalValue /*P*/ SGV, 
                      DenseSet</*const*/ GlobalValue /*P*/ > /*P*/ GlobalsToImport) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "M=" + M // NOI18N
              + ", ImportIndex=" + ImportIndex // NOI18N
              + ", GlobalsToImport=" + GlobalsToImport // NOI18N
              + ", HasExportedFunctions=" + HasExportedFunctions; // NOI18N
  }
}
