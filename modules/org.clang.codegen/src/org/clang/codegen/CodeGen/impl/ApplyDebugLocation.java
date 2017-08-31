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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;


/// A scoped helper to set the current debug location to the specified
/// location or preferred location of the specified Expr.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 539,
 FQN="clang::CodeGen::ApplyDebugLocation", NM="_ZN5clang7CodeGen18ApplyDebugLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocationE")
//</editor-fold>
public class ApplyDebugLocation implements Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 74,
   FQN="clang::CodeGen::ApplyDebugLocation::init", NM="_ZN5clang7CodeGen18ApplyDebugLocation4initENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocation4initENS_14SourceLocationEb")
  //</editor-fold>
  private void init(SourceLocation TemporaryLocation) {
    init(TemporaryLocation, 
      false);
  }
  private void init(SourceLocation TemporaryLocation, 
      boolean DefaultToEmpty/*= false*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CGDebugInfo /*P*/ DI = CGF.getDebugInfo();
      if (!(DI != null)) {
        CGF = null;
        return;
      }
      
      OriginalLocation.$assign(CGF.Builder.getCurrentDebugLocation());
      if (TemporaryLocation.isValid()) {
        DI.EmitLocation(CGF.Builder, new SourceLocation(TemporaryLocation));
        return;
      }
      if (DefaultToEmpty) {
        CGF.Builder.SetCurrentDebugLocation($c$.track(new DebugLoc())); $c$.clean();
        return;
      }
      
      // Construct a location that has a valid scope, but no line info.
      assert (!DI.LexicalBlockStack.empty());
      CGF.Builder.SetCurrentDebugLocation($c$.track(DebugLoc.get(0, 0, DI.LexicalBlockStack.back().$T$P()))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 67,
   FQN="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation", NM="_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionEbNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionEbNS_14SourceLocationE")
  //</editor-fold>
  private ApplyDebugLocation(final CodeGenFunction /*&*/ CGF, 
      boolean DefaultToEmpty, 
      SourceLocation TemporaryLocation) {
    // : OriginalLocation(), CGF(&CGF) 
    //START JInit
    this.OriginalLocation = new DebugLoc();
    this.CGF = /*AddrOf*/CGF;
    //END JInit
    init(new SourceLocation(TemporaryLocation), DefaultToEmpty);
  }

  
  private DebugLoc OriginalLocation;
  private CodeGenFunction /*P*/ CGF;
/*public:*/
  /// Set the location to the (valid) TemporaryLocation.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 61,
   FQN="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation", NM="_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionENS_14SourceLocationE")
  //</editor-fold>
  public ApplyDebugLocation(final CodeGenFunction /*&*/ CGF, 
      SourceLocation TemporaryLocation) {
    // : OriginalLocation(), CGF(&CGF) 
    //START JInit
    this.OriginalLocation = new DebugLoc();
    this.CGF = /*AddrOf*/CGF;
    //END JInit
    init(new SourceLocation(TemporaryLocation));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 99,
   FQN="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation", NM="_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionEPKNS_4ExprE")
  //</editor-fold>
  public ApplyDebugLocation(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E) {
    // : OriginalLocation(), CGF(&CGF) 
    //START JInit
    this.OriginalLocation = new DebugLoc();
    this.CGF = /*AddrOf*/CGF;
    //END JInit
    init(E.getExprLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 104,
   FQN="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation", NM="_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionEN4llvm8DebugLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocationC1ERNS0_15CodeGenFunctionEN4llvm8DebugLocE")
  //</editor-fold>
  public ApplyDebugLocation(final CodeGenFunction /*&*/ CGF, DebugLoc Loc) {
    // : OriginalLocation(), CGF(&CGF) 
    //START JInit
    this.OriginalLocation = new DebugLoc();
    this.CGF = /*AddrOf*/CGF;
    //END JInit
    if (!(CGF.getDebugInfo() != null)) {
      this.CGF = null;
      return;
    }
    OriginalLocation.$assign(CGF.Builder.getCurrentDebugLocation());
    if (Loc.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        CGF.Builder.SetCurrentDebugLocation($c$.track(new DebugLoc(JD$Move.INSTANCE, std.move(Loc)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 553,
   FQN="clang::CodeGen::ApplyDebugLocation::ApplyDebugLocation", NM="_ZN5clang7CodeGen18ApplyDebugLocationC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocationC1EOS1_")
  //</editor-fold>
  public ApplyDebugLocation(JD$Move _dparam, final ApplyDebugLocation /*&&*/Other) {
    // : OriginalLocation(), CGF(Other.CGF) 
    //START JInit
    this.OriginalLocation = new DebugLoc();
    this.CGF = Other.CGF;
    //END JInit
    Other.CGF = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::~ApplyDebugLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 115,
   FQN="clang::CodeGen::ApplyDebugLocation::~ApplyDebugLocation", NM="_ZN5clang7CodeGen18ApplyDebugLocationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocationD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Query CGF so the location isn't overwritten when location updates are
    // temporarily disabled (for C++ default function arguments)
    if ((CGF != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        CGF.Builder.SetCurrentDebugLocation($c$.track(new DebugLoc(JD$Move.INSTANCE, std.move(OriginalLocation)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    //START JDestroy
    OriginalLocation.$destroy();
    //END JDestroy
  }

  
  /// \brief Apply TemporaryLocation if it is valid. Otherwise switch
  /// to an artificial debug location that has a valid scope, but no
  /// line information.
  ///
  /// Artificial locations are useful when emitting compiler-generated
  /// helper functions that have no source location associated with
  /// them. The DWARF specification allows the compiler to use the
  /// special line number 0 to indicate code that can not be
  /// attributed to any source location. Note that passing an empty
  /// SourceLocation to CGDebugInfo::setLocation() will result in the
  /// last valid location being reused.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::CreateArtificial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 570,
   FQN="clang::CodeGen::ApplyDebugLocation::CreateArtificial", NM="_ZN5clang7CodeGen18ApplyDebugLocation16CreateArtificialERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocation16CreateArtificialERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public static ApplyDebugLocation CreateArtificial(final CodeGenFunction /*&*/ CGF) {
    return new ApplyDebugLocation(CGF, false, new SourceLocation());
  }

  /// \brief Apply TemporaryLocation if it is valid. Otherwise switch
  /// to an artificial debug location that has a valid scope, but no
  /// line information.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::CreateDefaultArtificial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 576,
   FQN="clang::CodeGen::ApplyDebugLocation::CreateDefaultArtificial", NM="_ZN5clang7CodeGen18ApplyDebugLocation23CreateDefaultArtificialERNS0_15CodeGenFunctionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocation23CreateDefaultArtificialERNS0_15CodeGenFunctionENS_14SourceLocationE")
  //</editor-fold>
  public static ApplyDebugLocation CreateDefaultArtificial(final CodeGenFunction /*&*/ CGF, 
                         SourceLocation TemporaryLocation) {
    return new ApplyDebugLocation(CGF, false, new SourceLocation(TemporaryLocation));
  }

  
  /// Set the IRBuilder to not attach debug locations.  Note that
  /// passing an empty SourceLocation to \a CGDebugInfo::setLocation()
  /// will result in the last valid location being reused.  Note that
  /// all instructions that do not have a location at the beginning of
  /// a function are counted towards to function prologue.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ApplyDebugLocation::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 587,
   FQN="clang::CodeGen::ApplyDebugLocation::CreateEmpty", NM="_ZN5clang7CodeGen18ApplyDebugLocation11CreateEmptyERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen18ApplyDebugLocation11CreateEmptyERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public static ApplyDebugLocation CreateEmpty(final CodeGenFunction /*&*/ CGF) {
    return new ApplyDebugLocation(CGF, true, new SourceLocation());
  }

  
  @Override public String toString() {
    return "" + "OriginalLocation=" + OriginalLocation // NOI18N
              + ", CGF=" + CGF; // NOI18N
  }
}
