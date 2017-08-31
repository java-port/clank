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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// The exceptions personality for a function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 605,
 FQN="clang::CodeGen::EHPersonality", NM="_ZN5clang7CodeGen13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13EHPersonalityE")
//</editor-fold>
public class/*struct*/ EHPersonality {
  public /*const*/char$ptr/*char P*/ PersonalityFn;
  
  // If this is non-null, this personality requires a non-standard
  // function for rethrowing an exception after a catchall cleanup.
  // This function must have prototype void(void*).
  public /*const*/char$ptr/*char P*/ CatchallRethrowFn;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHPersonality::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 189,
   FQN="clang::CodeGen::EHPersonality::get", NM="_ZN5clang7CodeGen13EHPersonality3getERNS0_13CodeGenModuleEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13EHPersonality3getERNS0_13CodeGenModuleEPKNS_12FunctionDeclE")
  //</editor-fold>
  public static /*const*/ EHPersonality /*&*/ get(final CodeGenModule /*&*/ CGM, 
     /*const*/ FunctionDecl /*P*/ FD) {
    final /*const*/ Triple /*&*/ T = CGM.getTarget().getTriple();
    final /*const*/ LangOptions /*&*/ L = CGM.getLangOpts();
    
    // Functions using SEH get an SEH personality.
    if ((FD != null) && FD.usesSEHTry()) {
      return CGExceptionStatics.getSEHPersonalityMSVC(T);
    }
    
    // Try to pick a personality function that is compatible with MSVC if we're
    // not compiling Obj-C. Obj-C users better have an Obj-C runtime that supports
    // the GCC-style personality function.
    if (T.isWindowsMSVCEnvironment() && !L.ObjC1) {
      if (L.SjLjExceptions) {
        return EHPersonality.GNU_CPlusPlus_SJLJ;
      } else {
        return EHPersonality.MSVC_CxxFrameHandler3;
      }
    }
    if (L.CPlusPlus && L.ObjC1) {
      return CGExceptionStatics.getObjCXXPersonality(T, L);
    } else if (L.CPlusPlus) {
      return CGExceptionStatics.getCXXPersonality(T, L);
    } else if (L.ObjC1) {
      return CGExceptionStatics.getObjCPersonality(T, L);
    } else {
      return CGExceptionStatics.getCPersonality(T, L);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHPersonality::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 218,
   FQN="clang::CodeGen::EHPersonality::get", NM="_ZN5clang7CodeGen13EHPersonality3getERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13EHPersonality3getERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public static /*const*/ EHPersonality /*&*/ get(final CodeGenFunction /*&*/ CGF) {
    return get(CGF.CGM, dyn_cast_or_null_FunctionDecl(CGF.CurCodeDecl));
  }

  
  public static /*const*/ EHPersonality GNU_C = new EHPersonality($("__gcc_personality_v0"), null);
  public static /*const*/ EHPersonality GNU_C_SJLJ = new EHPersonality($("__gcc_personality_sj0"), null);
  public static /*const*/ EHPersonality GNU_C_SEH = new EHPersonality($("__gcc_personality_seh0"), null);
  public static /*const*/ EHPersonality GNU_ObjC = new EHPersonality($("__gnu_objc_personality_v0"), $("objc_exception_throw"));
  public static /*const*/ EHPersonality GNUstep_ObjC = new EHPersonality($("__gnustep_objc_personality_v0"), null);
  public static /*const*/ EHPersonality GNU_ObjCXX = new EHPersonality($("__gnustep_objcxx_personality_v0"), null);
  public static /*const*/ EHPersonality NeXT_ObjC = new EHPersonality($("__objc_personality_v0"), null);
  public static /*const*/ EHPersonality GNU_CPlusPlus = new EHPersonality($("__gxx_personality_v0"), null);
  public static /*const*/ EHPersonality GNU_CPlusPlus_SJLJ = new EHPersonality($("__gxx_personality_sj0"), null);
  public static /*const*/ EHPersonality GNU_CPlusPlus_SEH = new EHPersonality($("__gxx_personality_seh0"), null);
  public static /*const*/ EHPersonality MSVC_except_handler = new EHPersonality($("_except_handler3"), null);
  public static /*const*/ EHPersonality MSVC_C_specific_handler = new EHPersonality($("__C_specific_handler"), null);
  public static /*const*/ EHPersonality MSVC_CxxFrameHandler3 = new EHPersonality($("__CxxFrameHandler3"), null);
  
  /// Does this personality use landingpads or the family of pad instructions
  /// designed to form funclets?
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHPersonality::usesFuncletPads">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 632,
   FQN="clang::CodeGen::EHPersonality::usesFuncletPads", NM="_ZNK5clang7CodeGen13EHPersonality15usesFuncletPadsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZNK5clang7CodeGen13EHPersonality15usesFuncletPadsEv")
  //</editor-fold>
  public boolean usesFuncletPads() /*const*/ {
    return isMSVCPersonality();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHPersonality::isMSVCPersonality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 634,
   FQN="clang::CodeGen::EHPersonality::isMSVCPersonality", NM="_ZNK5clang7CodeGen13EHPersonality17isMSVCPersonalityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZNK5clang7CodeGen13EHPersonality17isMSVCPersonalityEv")
  //</editor-fold>
  public boolean isMSVCPersonality() /*const*/ {
    return this == /*AddrOf*/MSVC_except_handler || this == /*AddrOf*/MSVC_C_specific_handler
       || this == /*AddrOf*/MSVC_CxxFrameHandler3;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHPersonality::isMSVCXXPersonality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 639,
   FQN="clang::CodeGen::EHPersonality::isMSVCXXPersonality", NM="_ZNK5clang7CodeGen13EHPersonality19isMSVCXXPersonalityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZNK5clang7CodeGen13EHPersonality19isMSVCXXPersonalityEv")
  //</editor-fold>
  public boolean isMSVCXXPersonality() /*const*/ {
    return this == /*AddrOf*/MSVC_CxxFrameHandler3;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public EHPersonality(char$ptr PersonalityFn, char$ptr CatchallRethrowFn) {
    this.PersonalityFn = PersonalityFn;
    this.CatchallRethrowFn = CatchallRethrowFn;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "PersonalityFn=" + PersonalityFn // NOI18N
              + ", CatchallRethrowFn=" + CatchallRethrowFn; // NOI18N
  }
}
