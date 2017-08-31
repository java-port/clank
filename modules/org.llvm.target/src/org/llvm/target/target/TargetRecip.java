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

package org.llvm.target.target;

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

//<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 28,
 FQN="llvm::TargetRecip", NM="_ZN4llvm11TargetRecipE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecipE")
//</editor-fold>
public class/*struct*/ TargetRecip implements Destructors.ClassWithDestructor, Native.NativeComparable<TargetRecip> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::TargetRecip">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 30,
   FQN="llvm::TargetRecip::TargetRecip", NM="_ZN4llvm11TargetRecipC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecipC1Ev")
  //</editor-fold>
  public TargetRecip() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Initialize all or part of the operations from command-line options or
  /// a front end.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::TargetRecip">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 34,
   FQN="llvm::TargetRecip::TargetRecip", NM="_ZN4llvm11TargetRecipC1ERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecipC1ERKSt6vectorISsSaISsEE")
  //</editor-fold>
  public TargetRecip(final /*const*/std.vectorString/*&*/ Args) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Set whether a particular reciprocal operation is enabled and how many
  /// refinement steps are needed when using it. Use "all" to set enablement
  /// and refinement steps for all operations.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::setDefaults">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 39,
   FQN="llvm::TargetRecip::setDefaults", NM="_ZN4llvm11TargetRecip11setDefaultsENS_9StringRefEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecip11setDefaultsENS_9StringRefEbj")
  //</editor-fold>
  public void setDefaults(StringRef Key, boolean Enable, /*uint*/int RefSteps) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Return true if the reciprocal operation has been enabled by default or
  /// from the command-line. Return false if the operation has been disabled
  /// by default or from the command-line.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::isEnabled">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 44,
   FQN="llvm::TargetRecip::isEnabled", NM="_ZNK4llvm11TargetRecip9isEnabledENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm11TargetRecip9isEnabledENS_9StringRefE")
  //</editor-fold>
  public boolean isEnabled(StringRef Key) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Return the number of iterations necessary to refine the
  /// the result of a machine instruction for the given reciprocal operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::getRefinementSteps">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 48,
   FQN="llvm::TargetRecip::getRefinementSteps", NM="_ZNK4llvm11TargetRecip18getRefinementStepsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm11TargetRecip18getRefinementStepsENS_9StringRefE")
  //</editor-fold>
  public /*uint*/int getRefinementSteps(StringRef Key) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 50,
   FQN="llvm::TargetRecip::operator==", NM="_ZNK4llvm11TargetRecipeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm11TargetRecipeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ TargetRecip /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 53,
   FQN="llvm::TargetRecip::(anonymous)", NM="_ZN4llvm11TargetRecipE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecipE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final int Uninitialized = -1;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::RecipParams">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 57,
   FQN="llvm::TargetRecip::RecipParams", NM="_ZN4llvm11TargetRecip11RecipParamsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecip11RecipParamsE")
  //</editor-fold>
  private static class/*struct*/ RecipParams {
    public byte/*int8_t*/ Enabled;
    public byte/*int8_t*/ RefinementSteps;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::RecipParams::RecipParams">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 61,
     FQN="llvm::TargetRecip::RecipParams::RecipParams", NM="_ZN4llvm11TargetRecip11RecipParamsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecip11RecipParamsC1Ev")
    //</editor-fold>
    public RecipParams() {
      // : Enabled(Uninitialized), RefinementSteps(Uninitialized) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::RecipParams::RecipParams">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 57,
     FQN="llvm::TargetRecip::RecipParams::RecipParams", NM="_ZN4llvm11TargetRecip11RecipParamsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecip11RecipParamsC1ERKS1_")
    //</editor-fold>
    public /*inline*/ RecipParams(final /*const*/ RecipParams /*&*/ $Prm0) {
      // : Enabled(.Enabled), RefinementSteps(.RefinementSteps) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::RecipParams::RecipParams">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 57,
     FQN="llvm::TargetRecip::RecipParams::RecipParams", NM="_ZN4llvm11TargetRecip11RecipParamsC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecip11RecipParamsC1EOS1_")
    //</editor-fold>
    public /*inline*/ RecipParams(JD$Move _dparam, final RecipParams /*&&*/$Prm0) {
      // : Enabled(static_cast<RecipParams &&>().Enabled), RefinementSteps(static_cast<RecipParams &&>().RefinementSteps) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Enabled=" + Enabled // NOI18N
                + ", RefinementSteps=" + RefinementSteps; // NOI18N
    }
  };
  
  private std.mapTypeType<StringRef, RecipParams> RecipMap;
  // JAVA: typedef std::map<StringRef, RecipParams>::iterator RecipIter
//  public final class RecipIter extends std.map.iterator</*const*/ StringRef, RecipParams>{ };
  // JAVA: typedef std::map<StringRef, RecipParams>::const_iterator ConstRecipIter
//  public final class ConstRecipIter extends std.map.iterator</*const*/ StringRef, RecipParams>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::parseGlobalParams">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 68,
   FQN="llvm::TargetRecip::parseGlobalParams", NM="_ZN4llvm11TargetRecip17parseGlobalParamsERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecip17parseGlobalParamsERKSs")
  //</editor-fold>
  private boolean parseGlobalParams(final /*const*/std.string/*&*/ Arg) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::parseIndividualParams">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 69,
   FQN="llvm::TargetRecip::parseIndividualParams", NM="_ZN4llvm11TargetRecip21parseIndividualParamsERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecip21parseIndividualParamsERKSt6vectorISsSaISsEE")
  //</editor-fold>
  private void parseIndividualParams(final /*const*/std.vectorString/*&*/ Args) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::TargetRecip">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 28,
   FQN="llvm::TargetRecip::TargetRecip", NM="_ZN4llvm11TargetRecipC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecipC1EOS0_")
  //</editor-fold>
  public /*inline*/ TargetRecip(JD$Move _dparam, final TargetRecip /*&&*/$Prm0) {
    // : RecipMap(static_cast<TargetRecip &&>().RecipMap) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 28,
   FQN="llvm::TargetRecip::operator=", NM="_ZN4llvm11TargetRecipaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecipaSEOS0_")
  //</editor-fold>
  public /*inline*/ TargetRecip /*&*/ $assignMove(final TargetRecip /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetRecip::~TargetRecip">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetRecip.h", line = 28,
   FQN="llvm::TargetRecip::~TargetRecip", NM="_ZN4llvm11TargetRecipD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm11TargetRecipD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "RecipMap=" + RecipMap; // NOI18N
  }
}
