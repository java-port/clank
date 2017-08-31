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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief One specifier in an @available expression.
///
/// \code
///   @available(macos 10.10, *)
/// \endcode
///
/// Here, 'macos 10.10' and '*' both map to an instance of this type.
///
//<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 31,
 FQN="clang::AvailabilitySpec", NM="_ZN5clang16AvailabilitySpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang16AvailabilitySpecE")
//</editor-fold>
public class AvailabilitySpec implements NativeCloneable<AvailabilitySpec>, NativeMoveable<AvailabilitySpec> {
  /// Represents the version that this specifier requires. If the host OS
  /// version is greater than or equal to Version, the @available will evaluate
  /// to true.
  private VersionTuple Version;
  
  /// Name of the platform that Version corresponds to.
  private StringRef Platform;
  
  private SourceLocation BeginLoc;
  
  private SourceLocation EndLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::AvailabilitySpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 43,
   FQN="clang::AvailabilitySpec::AvailabilitySpec", NM="_ZN5clang16AvailabilitySpecC1ENS_12VersionTupleEN4llvm9StringRefENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang16AvailabilitySpecC1ENS_12VersionTupleEN4llvm9StringRefENS_14SourceLocationES4_")
  //</editor-fold>
  public AvailabilitySpec(VersionTuple Version, StringRef Platform, 
      SourceLocation BeginLoc, SourceLocation EndLoc) {
    // : Version(Version), Platform(Platform), BeginLoc(BeginLoc), EndLoc(EndLoc) 
    //START JInit
    this.Version = new VersionTuple(Version);
    this.Platform = new StringRef(Platform);
    this.BeginLoc = new SourceLocation(BeginLoc);
    this.EndLoc = new SourceLocation(EndLoc);
    //END JInit
  }

  
  /// This constructor is used when representing the '*' case.
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::AvailabilitySpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 49,
   FQN="clang::AvailabilitySpec::AvailabilitySpec", NM="_ZN5clang16AvailabilitySpecC1ENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang16AvailabilitySpecC1ENS_14SourceLocationE")
  //</editor-fold>
  public AvailabilitySpec(SourceLocation StarLoc) {
    // : Version(), Platform(), BeginLoc(StarLoc), EndLoc(StarLoc) 
    //START JInit
    this.Version = new VersionTuple();
    this.Platform = new StringRef();
    this.BeginLoc = new SourceLocation(StarLoc);
    this.EndLoc = new SourceLocation(StarLoc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::getVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 52,
   FQN="clang::AvailabilitySpec::getVersion", NM="_ZNK5clang16AvailabilitySpec10getVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZNK5clang16AvailabilitySpec10getVersionEv")
  //</editor-fold>
  public VersionTuple getVersion() /*const*/ {
    return new VersionTuple(Version);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::getPlatform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 53,
   FQN="clang::AvailabilitySpec::getPlatform", NM="_ZNK5clang16AvailabilitySpec11getPlatformEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZNK5clang16AvailabilitySpec11getPlatformEv")
  //</editor-fold>
  public StringRef getPlatform() /*const*/ {
    return new StringRef(Platform);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::getBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 54,
   FQN="clang::AvailabilitySpec::getBeginLoc", NM="_ZNK5clang16AvailabilitySpec11getBeginLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZNK5clang16AvailabilitySpec11getBeginLocEv")
  //</editor-fold>
  public SourceLocation getBeginLoc() /*const*/ {
    return new SourceLocation(BeginLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 55,
   FQN="clang::AvailabilitySpec::getEndLoc", NM="_ZNK5clang16AvailabilitySpec9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZNK5clang16AvailabilitySpec9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    return new SourceLocation(EndLoc);
  }

  
  /// Returns true when this represents the '*' case.
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::isOtherPlatformSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 58,
   FQN="clang::AvailabilitySpec::isOtherPlatformSpec", NM="_ZNK5clang16AvailabilitySpec19isOtherPlatformSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZNK5clang16AvailabilitySpec19isOtherPlatformSpecEv")
  //</editor-fold>
  public boolean isOtherPlatformSpec() /*const*/ {
    return Version.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilitySpec::AvailabilitySpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Availability.h", line = 31,
   FQN="clang::AvailabilitySpec::AvailabilitySpec", NM="_ZN5clang16AvailabilitySpecC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang16AvailabilitySpecC1EOS0_")
  //</editor-fold>
  public /*inline*/ AvailabilitySpec(JD$Move _dparam, final AvailabilitySpec /*&&*/$Prm0) {
    // : Version(static_cast<AvailabilitySpec &&>().Version), Platform(static_cast<AvailabilitySpec &&>().Platform), BeginLoc(static_cast<AvailabilitySpec &&>().BeginLoc), EndLoc(static_cast<AvailabilitySpec &&>().EndLoc) 
    //START JInit
    this.Version = new VersionTuple(JD$Move.INSTANCE, $Prm0.Version);
    this.Platform = new StringRef(JD$Move.INSTANCE, $Prm0.Platform);
    this.BeginLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.BeginLoc);
    this.EndLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EndLoc);
    //END JInit
  }
  
  public AvailabilitySpec() {
    this.Version = new VersionTuple();
    this.Platform = new StringRef();
    this.BeginLoc = new SourceLocation();
    this.EndLoc = new SourceLocation();
  }
  
  public /*inline*/ AvailabilitySpec(final AvailabilitySpec /*&&*/$Prm0) {
    // : Version(static_cast<AvailabilitySpec &&>().Version), Platform(static_cast<AvailabilitySpec &&>().Platform), BeginLoc(static_cast<AvailabilitySpec &&>().BeginLoc), EndLoc(static_cast<AvailabilitySpec &&>().EndLoc) 
    //START JInit
    this.Version = new VersionTuple($Prm0.Version);
    this.Platform = new StringRef($Prm0.Platform);
    this.BeginLoc = new SourceLocation($Prm0.BeginLoc);
    this.EndLoc = new SourceLocation($Prm0.EndLoc);
    //END JInit
  }

  @Override public AvailabilitySpec clone() {
    return new AvailabilitySpec(this);
  }

  @Override public AvailabilitySpec move() {
    return new AvailabilitySpec(JD$Move.INSTANCE, this);
  }
  
  @Override public String toString() {
    return "" + "Version=" + Version // NOI18N
              + ", Platform=" + Platform // NOI18N
              + ", BeginLoc=" + BeginLoc // NOI18N
              + ", EndLoc=" + EndLoc; // NOI18N
  }
}
