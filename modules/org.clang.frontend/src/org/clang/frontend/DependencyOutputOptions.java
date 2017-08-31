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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.frontend.*;


/// DependencyOutputOptions - Options for controlling the compiler dependency
/// file generation.
//<editor-fold defaultstate="collapsed" desc="clang::DependencyOutputOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DependencyOutputOptions.h", line = 23,
 FQN="clang::DependencyOutputOptions", NM="_ZN5clang23DependencyOutputOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang23DependencyOutputOptionsE")
//</editor-fold>
public class DependencyOutputOptions implements Destructors.ClassWithDestructor {
/*public:*/
  public /*JBIT unsigned int*/ boolean IncludeSystemHeaders /*: 1*/; ///< Include system header dependencies.
  public /*JBIT unsigned int*/ boolean ShowHeaderIncludes /*: 1*/; ///< Show header inclusions (-H).
  public /*JBIT unsigned int*/ boolean UsePhonyTargets /*: 1*/; ///< Include phony targets for each
  /// dependency, which can avoid some 'make'
  /// problems.
  public /*JBIT unsigned int*/ boolean AddMissingHeaderDeps /*: 1*/; ///< Add missing headers to dependency list
  public /*JBIT unsigned int*/ boolean PrintShowIncludes /*: 1*/; ///< Print cl.exe style /showIncludes info.
  public /*JBIT unsigned int*/ boolean IncludeModuleFiles /*: 1*/; ///< Include module file dependencies.
  
  /// The format for the dependency file.
  public DependencyOutputFormat OutputFormat;
  
  /// The file to write dependency output to.
  public std.string OutputFile;
  
  /// The file to write header include output to. This is orthogonal to
  /// ShowHeaderIncludes (-H) and will include headers mentioned in the
  /// predefines buffer. If the output file is "-", output will be sent to
  /// stderr.
  public std.string HeaderIncludeOutputFile;
  
  /// A list of names to use as the targets in the dependency file; this list
  /// must contain at least one entry.
  public std.vectorString Targets;
  
  /// A list of filenames to be used as extra dependencies for every target.
  public std.vectorString ExtraDeps;
  
  /// In /showIncludes mode, pretend the main TU is a header with this name.
  public std.string ShowIncludesPretendHeader;
  
  /// \brief The file to write GraphViz-formatted header dependencies to.
  public std.string DOTOutputFile;
  
  /// \brief The directory to copy module dependencies to when collecting them.
  public std.string ModuleDependencyOutputDir;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyOutputOptions::DependencyOutputOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DependencyOutputOptions.h", line = 63,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DependencyOutputOptions.h", old_line = 60,
   FQN="clang::DependencyOutputOptions::DependencyOutputOptions", NM="_ZN5clang23DependencyOutputOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang23DependencyOutputOptionsC1Ev")
  //</editor-fold>
  public DependencyOutputOptions() {
    // : OutputFile(), HeaderIncludeOutputFile(), Targets(), ExtraDeps(), ShowIncludesPretendHeader(), DOTOutputFile(), ModuleDependencyOutputDir() 
    //START JInit
    this.OutputFile = new std.string();
    this.HeaderIncludeOutputFile = new std.string();
    this.Targets = new std.vectorString(std.string.EMPTY);
    this.ExtraDeps = new std.vectorString(std.string.EMPTY);
    this.ShowIncludesPretendHeader = new std.string();
    this.DOTOutputFile = new std.string();
    this.ModuleDependencyOutputDir = new std.string();
    //END JInit
    IncludeSystemHeaders = false;
    ShowHeaderIncludes = false;
    UsePhonyTargets = false;
    AddMissingHeaderDeps = false;
    PrintShowIncludes = false;
    IncludeModuleFiles = false;
    OutputFormat = DependencyOutputFormat.Make;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependencyOutputOptions::DependencyOutputOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DependencyOutputOptions.h", line = 23,
   FQN="clang::DependencyOutputOptions::DependencyOutputOptions", NM="_ZN5clang23DependencyOutputOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang23DependencyOutputOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DependencyOutputOptions(/*const*/ DependencyOutputOptions /*&*/ $Prm0) {
    // : IncludeSystemHeaders(.IncludeSystemHeaders), ShowHeaderIncludes(.ShowHeaderIncludes), UsePhonyTargets(.UsePhonyTargets), AddMissingHeaderDeps(.AddMissingHeaderDeps), PrintShowIncludes(.PrintShowIncludes), IncludeModuleFiles(.IncludeModuleFiles), OutputFormat(.OutputFormat), OutputFile(.OutputFile), HeaderIncludeOutputFile(.HeaderIncludeOutputFile), Targets(.Targets), ExtraDeps(.ExtraDeps), ShowIncludesPretendHeader(.ShowIncludesPretendHeader), DOTOutputFile(.DOTOutputFile), ModuleDependencyOutputDir(.ModuleDependencyOutputDir) 
    //START JInit
    this.IncludeSystemHeaders = $Prm0.IncludeSystemHeaders;
    this.ShowHeaderIncludes = $Prm0.ShowHeaderIncludes;
    this.UsePhonyTargets = $Prm0.UsePhonyTargets;
    this.AddMissingHeaderDeps = $Prm0.AddMissingHeaderDeps;
    this.PrintShowIncludes = $Prm0.PrintShowIncludes;
    this.IncludeModuleFiles = $Prm0.IncludeModuleFiles;
    this.OutputFormat = $Prm0.OutputFormat;
    this.OutputFile = new std.string($Prm0.OutputFile);
    this.HeaderIncludeOutputFile = new std.string($Prm0.HeaderIncludeOutputFile);
    this.Targets = new std.vectorString($Prm0.Targets);
    this.ExtraDeps = new std.vectorString($Prm0.ExtraDeps);
    this.ShowIncludesPretendHeader = new std.string($Prm0.ShowIncludesPretendHeader);
    this.DOTOutputFile = new std.string($Prm0.DOTOutputFile);
    this.ModuleDependencyOutputDir = new std.string($Prm0.ModuleDependencyOutputDir);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependencyOutputOptions::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DependencyOutputOptions.h", line = 23,
   FQN="clang::DependencyOutputOptions::operator=", NM="_ZN5clang23DependencyOutputOptionsaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang23DependencyOutputOptionsaSEOS0_")
  //</editor-fold>
  public /*inline*/ DependencyOutputOptions /*&*/ $assignMove(DependencyOutputOptions /*&&*/$Prm0) {
    this.IncludeSystemHeaders = $Prm0.IncludeSystemHeaders;
    this.ShowHeaderIncludes = $Prm0.ShowHeaderIncludes;
    this.UsePhonyTargets = $Prm0.UsePhonyTargets;
    this.AddMissingHeaderDeps = $Prm0.AddMissingHeaderDeps;
    this.PrintShowIncludes = $Prm0.PrintShowIncludes;
    this.IncludeModuleFiles = $Prm0.IncludeModuleFiles;
    this.OutputFormat = $Prm0.OutputFormat;
    this.OutputFile.$assignMove($Prm0.OutputFile);
    this.HeaderIncludeOutputFile.$assignMove($Prm0.HeaderIncludeOutputFile);
    this.Targets.$assignMove($Prm0.Targets);
    this.ExtraDeps.$assignMove($Prm0.ExtraDeps);
    this.ShowIncludesPretendHeader.$assignMove($Prm0.ShowIncludesPretendHeader);
    this.DOTOutputFile.$assignMove($Prm0.DOTOutputFile);
    this.ModuleDependencyOutputDir.$assignMove($Prm0.ModuleDependencyOutputDir);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependencyOutputOptions::~DependencyOutputOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/DependencyOutputOptions.h", line = 23,
   FQN="clang::DependencyOutputOptions::~DependencyOutputOptions", NM="_ZN5clang23DependencyOutputOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang23DependencyOutputOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ModuleDependencyOutputDir.$destroy();
    DOTOutputFile.$destroy();
    ShowIncludesPretendHeader.$destroy();
    ExtraDeps.$destroy();
    Targets.$destroy();
    HeaderIncludeOutputFile.$destroy();
    OutputFile.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "IncludeSystemHeaders=" + IncludeSystemHeaders // NOI18N
              + ", ShowHeaderIncludes=" + ShowHeaderIncludes // NOI18N
              + ", UsePhonyTargets=" + UsePhonyTargets // NOI18N
              + ", AddMissingHeaderDeps=" + AddMissingHeaderDeps // NOI18N
              + ", PrintShowIncludes=" + PrintShowIncludes // NOI18N
              + ", IncludeModuleFiles=" + IncludeModuleFiles // NOI18N
              + ", OutputFormat=" + OutputFormat // NOI18N
              + ", OutputFile=" + OutputFile // NOI18N
              + ", HeaderIncludeOutputFile=" + HeaderIncludeOutputFile // NOI18N
              + ", Targets=" + Targets // NOI18N
              + ", ExtraDeps=" + ExtraDeps // NOI18N
              + ", ShowIncludesPretendHeader=" + ShowIncludesPretendHeader // NOI18N
              + ", DOTOutputFile=" + DOTOutputFile // NOI18N
              + ", ModuleDependencyOutputDir=" + ModuleDependencyOutputDir; // NOI18N
  }
}
