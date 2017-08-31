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

package org.clang.basic.target;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.basic.*;
import org.clang.basic.target.*;


/// \brief Options for controlling the target.
//<editor-fold defaultstate="collapsed" desc="clang::TargetOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", line = 25,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", old_line = 24,
 FQN="clang::TargetOptions", NM="_ZN5clang13TargetOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang13TargetOptionsE")
//</editor-fold>
public class TargetOptions implements Destructors.ClassWithDestructor {
/*public:*/
  /// If given, the name of the target triple to compile for. If not given the
  /// target will be selected to match the host.
  public std.string Triple;
  
  /// When compiling for the device side, contains the triple used to compile
  /// for the host.
  public std.string HostTriple;
  
  /// If given, the name of the target CPU to generate code for.
  public std.string CPU;
  
  /// If given, the unit to use for floating point math.
  public std.string FPMath;
  
  /// If given, the name of the target ABI to use.
  public std.string ABI;
  
  /// The EABI version to use
  public std.string EABIVersion;
  
  /// If given, the version string of the linker in use.
  public std.string LinkerVersion;
  
  /// \brief The list of target specific features to enable or disable, as written on the command line.
  public std.vectorString FeaturesAsWritten;
  
  /// The list of target specific features to enable or disable -- this should
  /// be a list of strings starting with by '+' or '-'.
  public std.vectorString Features;
  
  public std.vectorString Reciprocals;
  
  /// Supported OpenCL extensions and optional core features.
  public OpenCLOptions SupportedOpenCLOptions;
  //<editor-fold defaultstate="collapsed" desc="clang::TargetOptions::TargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", line = 25,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", old_line = 24,
   FQN="clang::TargetOptions::TargetOptions", NM="_ZN5clang13TargetOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang13TargetOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TargetOptions(/*const*/ TargetOptions /*&*/ $Prm0) {
    /* : Triple(.Triple), HostTriple(.HostTriple), CPU(.CPU), FPMath(.FPMath), ABI(.ABI), EABIVersion(.EABIVersion), LinkerVersion(.LinkerVersion), FeaturesAsWritten(.FeaturesAsWritten), Features(.Features), Reciprocals(.Reciprocals), SupportedOpenCLOptions(.SupportedOpenCLOptions)*/ 
    //START JInit
    this.Triple = new std.string($Prm0.Triple);
    this.HostTriple = new std.string($Prm0.HostTriple);
    this.CPU = new std.string($Prm0.CPU);
    this.FPMath = new std.string($Prm0.FPMath);
    this.ABI = new std.string($Prm0.ABI);
    this.EABIVersion = new std.string($Prm0.EABIVersion);
    this.LinkerVersion = new std.string($Prm0.LinkerVersion);
    this.FeaturesAsWritten = new std.vectorString($Prm0.FeaturesAsWritten);
    this.Features = new std.vectorString($Prm0.Features);
    this.Reciprocals = new std.vectorString($Prm0.Reciprocals);
    this.SupportedOpenCLOptions = new OpenCLOptions($Prm0.SupportedOpenCLOptions);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetOptions::~TargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", line = 25,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", old_line = 24,
   FQN="clang::TargetOptions::~TargetOptions", NM="_ZN5clang13TargetOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang13TargetOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Reciprocals.$destroy();
    Features.$destroy();
    FeaturesAsWritten.$destroy();
    LinkerVersion.$destroy();
    EABIVersion.$destroy();
    ABI.$destroy();
    FPMath.$destroy();
    CPU.$destroy();
    HostTriple.$destroy();
    Triple.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetOptions::TargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", line = 25,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetOptions.h", old_line = 24,
   FQN="clang::TargetOptions::TargetOptions", NM="_ZN5clang13TargetOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang13TargetOptionsC1Ev")
  //</editor-fold>
  public /*inline*/ TargetOptions() {
    /* : Triple(), HostTriple(), CPU(), FPMath(), ABI(), EABIVersion(), LinkerVersion(), FeaturesAsWritten(), Features(), Reciprocals(), SupportedOpenCLOptions()*/ 
    //START JInit
    this.Triple = new std.string();
    this.HostTriple = new std.string();
    this.CPU = new std.string();
    this.FPMath = new std.string();
    this.ABI = new std.string();
    this.EABIVersion = new std.string();
    this.LinkerVersion = new std.string();
    this.FeaturesAsWritten = new std.vectorString(std.string.EMPTY);
    this.Features = new std.vectorString(std.string.EMPTY);
    this.Reciprocals = new std.vectorString(std.string.EMPTY);
    this.SupportedOpenCLOptions = new OpenCLOptions();
    //END JInit
  }

  
  public String toString() {
    return "" + "Triple=" + Triple // NOI18N
              + ", HostTriple=" + HostTriple // NOI18N
              + ", CPU=" + CPU // NOI18N
              + ", FPMath=" + FPMath // NOI18N
              + ", ABI=" + ABI // NOI18N
              + ", EABIVersion=" + EABIVersion // NOI18N
              + ", LinkerVersion=" + LinkerVersion // NOI18N
              + ", FeaturesAsWritten=" + FeaturesAsWritten // NOI18N
              + ", Features=" + Features // NOI18N
              + ", Reciprocals=" + Reciprocals // NOI18N
              + ", SupportedOpenCLOptions=" + SupportedOpenCLOptions; // NOI18N
  }
}
