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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::Mangler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Mangler.h", line = 27,
 FQN="llvm::Mangler", NM="_ZN4llvm7ManglerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/AsmPrinter/AsmPrinter.cpp -nm=_ZN4llvm7ManglerE")
//</editor-fold>
public class Mangler implements Destructors.ClassWithDestructor {
  /// We need to give global values the same name every time they are mangled.
  /// This keeps track of the number we give to anonymous ones.
  private /*mutable */DenseMapTypeUInt</*const*/ GlobalValue /*P*/ > AnonGlobalIDs;

  /// This simple counter is used to unique value names.
  private /*mutable *//*uint*/int NextAnonGlobalID;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Mangler::Mangler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Mangler.h", line = 36,
   FQN="llvm::Mangler::Mangler", NM="_ZN4llvm7ManglerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/AsmPrinter/AsmPrinter.cpp -nm=_ZN4llvm7ManglerC1Ev")
  //</editor-fold>
  public Mangler() {
    // : AnonGlobalIDs(), NextAnonGlobalID(1)
    //START JInit
    this.AnonGlobalIDs = new DenseMapTypeUInt</*const*/ GlobalValue /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.NextAnonGlobalID = 1;
    //END JInit
  }


  /// Print the appropriate prefix and the specified global variable's name.
  /// If the global variable doesn't have a name, this fills in a unique name
  /// for the global.

  /// Print the appropriate prefix and the specified global variable's name.
  /// If the global variable doesn't have a name, this fills in a unique name
  /// for the global.
  //<editor-fold defaultstate="collapsed" desc="llvm::Mangler::getNameWithPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 108,
   FQN="llvm::Mangler::getNameWithPrefix", NM="_ZNK4llvm7Mangler17getNameWithPrefixERNS_11raw_ostreamEPKNS_11GlobalValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZNK4llvm7Mangler17getNameWithPrefixERNS_11raw_ostreamEPKNS_11GlobalValueEb")
  //</editor-fold>
  public void getNameWithPrefix(final raw_ostream /*&*/ OS, /*const*/ GlobalValue /*P*/ GV,
                   boolean CannotUsePrivateLabel) /*const*/ {
    ManglerPrefixTy PrefixTy = ManglerPrefixTy.Default;
    if (GV.hasPrivateLinkage()) {
      if (CannotUsePrivateLabel) {
        PrefixTy = ManglerPrefixTy.LinkerPrivate;
      } else {
        PrefixTy = ManglerPrefixTy.Private;
      }
    }

    final /*const*/ DataLayout /*&*/ DL = GV.getParent$Const().getDataLayout();
    if (!GV.hasName()) {
      // Get the ID for the global, assigning a new one if we haven't got one
      // already.
      final uint$ref/*uint &*/ ID = AnonGlobalIDs.ref$at(GV);
      if (ID.$deref() == 0) {
        ID.$set(NextAnonGlobalID++);
      }

      // Must mangle the global into a unique ID.
      ManglerStatics.getNameWithPrefixImpl(OS, $add_Twine$C(new Twine(/*KEEP_STR*/"__unnamed_"), new Twine(JD$UInt.INSTANCE, ID.$deref())), DL, PrefixTy);
      return;
    }

    StringRef Name = GV.getName();
    /*char*/byte Prefix = DL.getGlobalPrefix();

    // Mangle functions with Microsoft calling conventions specially.  Only do
    // this mangling for x86_64 vectorcall and 32-bit x86.
    /*const*/ Function /*P*/ MSFunc = dyn_cast_Function(GV);
    if (Name.startswith(/*STRINGREF_STR*/"\001")) {
      MSFunc = null; // Don't mangle when \01 is present.
    }
    /*uint*/int CC = (MSFunc != null) ? MSFunc.getCallingConv() : (/*uint*/int)CallingConv.C;
    if (!DL.hasMicrosoftFastStdCallMangling()
       && CC != CallingConv.X86_VectorCall) {
      MSFunc = null;
    }
    if ((MSFunc != null)) {
      if (CC == CallingConv.X86_FastCall) {
        Prefix = $$AT; // fastcall functions have an @ prefix instead of _.
      } else if (CC == CallingConv.X86_VectorCall) {
        Prefix = $$TERM; // vectorcall functions have no prefix.
      }
    }

    ManglerStatics.getNameWithPrefixImpl(OS, new Twine(Name), PrefixTy, DL, Prefix);
    if (!(MSFunc != null)) {
      return;
    }

    // If we are supposed to add a microsoft-style suffix for stdcall, fastcall,
    // or vectorcall, add it.  These functions have a suffix of @N where N is the
    // cumulative byte size of all of the parameters to the function in decimal.
    if (CC == CallingConv.X86_VectorCall) {
      OS.$out_char($$AT); // vectorcall functions use a double @ suffix.
    }
    FunctionType /*P*/ FT = MSFunc.getFunctionType();
    if (ManglerStatics.hasByteCountSuffix(CC)
      // "Pure" variadic functions do not receive @0 suffix.
       && (!FT.isVarArg() || FT.getNumParams() == 0
       || (FT.getNumParams() == 1 && MSFunc.hasStructRetAttr()))) {
      ManglerStatics.addByteCountSuffix(OS, MSFunc, DL);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Mangler::getNameWithPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 169,
   FQN="llvm::Mangler::getNameWithPrefix", NM="_ZNK4llvm7Mangler17getNameWithPrefixERNS_15SmallVectorImplIcEEPKNS_11GlobalValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZNK4llvm7Mangler17getNameWithPrefixERNS_15SmallVectorImplIcEEPKNS_11GlobalValueEb")
  //</editor-fold>
  public void getNameWithPrefix(final SmallString/*&*/ OutName,
                   /*const*/ GlobalValue /*P*/ GV,
                   boolean CannotUsePrivateLabel) /*const*/ {
    raw_svector_ostream OS = null;
    try {
      OS/*J*/= new raw_svector_ostream(OutName);
      getNameWithPrefix(OS, GV, CannotUsePrivateLabel);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }



  /// Print the appropriate prefix and the specified name as the global variable
  /// name. GVName must not be empty.

  /// Print the appropriate prefix and the specified name as the global variable
  /// name. GVName must not be empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::Mangler::getNameWithPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 65,
   FQN="llvm::Mangler::getNameWithPrefix", NM="_ZN4llvm7Mangler17getNameWithPrefixERNS_11raw_ostreamERKNS_5TwineERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZN4llvm7Mangler17getNameWithPrefixERNS_11raw_ostreamERKNS_5TwineERKNS_10DataLayoutE")
  //</editor-fold>
  public static void getNameWithPrefix(final raw_ostream /*&*/ OS, final /*const*/ Twine /*&*/ GVName,
                   final /*const*/ DataLayout /*&*/ DL) {
    ManglerStatics.getNameWithPrefixImpl(OS, GVName, DL, ManglerPrefixTy.Default);
    /*JAVA:return*/return;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Mangler::getNameWithPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 70,
   FQN="llvm::Mangler::getNameWithPrefix", NM="_ZN4llvm7Mangler17getNameWithPrefixERNS_15SmallVectorImplIcEERKNS_5TwineERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZN4llvm7Mangler17getNameWithPrefixERNS_15SmallVectorImplIcEERKNS_5TwineERKNS_10DataLayoutE")
  //</editor-fold>
  public static void getNameWithPrefix(final SmallString/*&*/ OutName,
                   final /*const*/ Twine /*&*/ GVName, final /*const*/ DataLayout /*&*/ DL) {
    raw_svector_ostream OS = null;
    try {
      OS/*J*/= new raw_svector_ostream(OutName);
      /*char*/byte Prefix = DL.getGlobalPrefix();
      ManglerStatics.getNameWithPrefixImpl(OS, GVName, ManglerPrefixTy.Default, DL, Prefix);
      /*JAVA:return*/return;
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Mangler::~Mangler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Mangler.h", line = 27,
   FQN="llvm::Mangler::~Mangler", NM="_ZN4llvm7ManglerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/AsmPrinter/AsmPrinter.cpp -nm=_ZN4llvm7ManglerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AnonGlobalIDs.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "AnonGlobalIDs=" + AnonGlobalIDs // NOI18N
              + ", NextAnonGlobalID=" + NextAnonGlobalID; // NOI18N
  }
}
