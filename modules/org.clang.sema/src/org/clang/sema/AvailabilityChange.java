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

package org.clang.sema;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Represents information about a change in availability for
/// an entity, which is part of the encoding of the 'availability'
/// attribute.
//<editor-fold defaultstate="collapsed" desc="clang::AvailabilityChange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 35,
 FQN="clang::AvailabilityChange", NM="_ZN5clang18AvailabilityChangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang18AvailabilityChangeE")
//</editor-fold>
public class/*struct*/ AvailabilityChange {
  /// \brief The location of the keyword indicating the kind of change.
  public SourceLocation KeywordLoc;
  
  /// \brief The version number at which the change occurred.
  public VersionTuple Version;
  
  /// \brief The source range covering the version number.
  public SourceRange VersionRange;
  
  /// \brief Determine whether this availability change is valid.
  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityChange::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 46,
   FQN="clang::AvailabilityChange::isValid", NM="_ZNK5clang18AvailabilityChange7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang18AvailabilityChange7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return !Version.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityChange::AvailabilityChange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 35,
   FQN="clang::AvailabilityChange::AvailabilityChange", NM="_ZN5clang18AvailabilityChangeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang18AvailabilityChangeC1Ev")
  //</editor-fold>
  public /*inline*/ AvailabilityChange() {
    // : KeywordLoc(), Version(), VersionRange() 
    //START JInit
    this.KeywordLoc = new SourceLocation();
    this.Version = new VersionTuple();
    this.VersionRange = new SourceRange();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityChange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 35,
   FQN="clang::AvailabilityChange::operator=", NM="_ZN5clang18AvailabilityChangeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang18AvailabilityChangeaSERKS0_")
  //</editor-fold>
  public /*inline*/ AvailabilityChange /*&*/ $assign(final /*const*/ AvailabilityChange /*&*/ $Prm0) {
    this.KeywordLoc.$assign($Prm0.KeywordLoc);
    this.Version.$assign($Prm0.Version);
    this.VersionRange.$assign($Prm0.VersionRange);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityChange::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 35,
   FQN="clang::AvailabilityChange::operator=", NM="_ZN5clang18AvailabilityChangeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang18AvailabilityChangeaSEOS0_")
  //</editor-fold>
  public /*inline*/ AvailabilityChange /*&*/ $assignMove(final AvailabilityChange /*&&*/$Prm0) {
    this.KeywordLoc.$assignMove($Prm0.KeywordLoc);
    this.Version.$assignMove($Prm0.Version);
    this.VersionRange.$assignMove($Prm0.VersionRange);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::AvailabilityChange::AvailabilityChange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 35,
   FQN="clang::AvailabilityChange::AvailabilityChange", NM="_ZN5clang18AvailabilityChangeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang18AvailabilityChangeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ AvailabilityChange(final /*const*/ AvailabilityChange /*&*/ $Prm0) {
    // : KeywordLoc(.KeywordLoc), Version(.Version), VersionRange(.VersionRange) 
    //START JInit
    this.KeywordLoc = new SourceLocation($Prm0.KeywordLoc);
    this.Version = new VersionTuple($Prm0.Version);
    this.VersionRange = new SourceRange($Prm0.VersionRange);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "KeywordLoc=" + KeywordLoc // NOI18N
              + ", Version=" + Version // NOI18N
              + ", VersionRange=" + VersionRange; // NOI18N
  }
}
