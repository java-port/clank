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

import java.util.function.Supplier;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import static org.clang.codegen.java.CodegenRTTI.*;


/// A stack of scopes which respond to exceptions, including cleanups
/// and catch blocks.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 100,
 FQN="clang::CodeGen::EHScopeStack", NM="_ZN5clang7CodeGen12EHScopeStackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStackE")
//</editor-fold>
public class EHScopeStack implements Destructors.ClassWithDestructor {
/*public:*/
  /* Should switch to alignof(uint64_t) instead of 8, when EHCleanupScope can */
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 103,
   FQN="clang::CodeGen::EHScopeStack::(anonymous)", NM="_ZN5clang7CodeGen12EHScopeStackE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStackE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int ScopeStackAlignment = 8;
  /*}*/;
  
  /// A saved depth on the scope stack.  This is necessary because
  /// pushing scopes onto the stack invalidates iterators.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 107,
   FQN="clang::CodeGen::EHScopeStack::stable_iterator", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iteratorE")
  //</editor-fold>
  public static class stable_iterator implements NativePOD<stable_iterator> {
    /*friend  class EHScopeStack*/
    
    /// Offset from StartOfData to EndOfBuffer.
    private int Size;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 113,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1Ei",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1Ei")
    //</editor-fold>
    private stable_iterator(int Size) {
      // : Size(Size) 
      //START JInit
      this.Size = Size;
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::invalid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 116,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::invalid", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iterator7invalidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iterator7invalidEv")
    //</editor-fold>
    public static stable_iterator invalid() {
      return new stable_iterator(-1);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 117,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1Ev")
    //</editor-fold>
    public stable_iterator() {
      // : Size(-1) 
      //START JInit
      this.Size = -1;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::isValid">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 119,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::isValid", NM="_ZNK5clang7CodeGen12EHScopeStack15stable_iterator7isValidEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack15stable_iterator7isValidEv")
    //</editor-fold>
    public boolean isValid() /*const*/ {
      return Size >= 0;
    }

    
    /// Returns true if this scope encloses I.
    /// Returns false if I is invalid.
    /// This scope must be valid.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::encloses">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 124,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::encloses", NM="_ZNK5clang7CodeGen12EHScopeStack15stable_iterator8enclosesES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack15stable_iterator8enclosesES2_")
    //</editor-fold>
    public boolean encloses(stable_iterator I) /*const*/ {
      return Size <= I.Size;
    }

    
    /// Returns true if this scope strictly encloses I: that is,
    /// if it encloses I and is not I.
    /// Returns false is I is invalid.
    /// This scope must be valid.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::strictlyEncloses">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 130,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::strictlyEncloses", NM="_ZNK5clang7CodeGen12EHScopeStack15stable_iterator16strictlyEnclosesES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack15stable_iterator16strictlyEnclosesES2_")
    //</editor-fold>
    public boolean strictlyEncloses(stable_iterator I) /*const*/ {
      return Size < I.Size;
    }

    
    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 132,
     FQN="clang::CodeGen::operator==", NM="_ZN5clang7CodeGeneqENS0_12EHScopeStack15stable_iteratorES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGeneqENS0_12EHScopeStack15stable_iteratorES2_")
    //</editor-fold>
    public static boolean $eq_stable_iterator(EHScopeStack.stable_iterator A, EHScopeStack.stable_iterator B) {
      return A.Size == B.Size;
    }

    /*friend*///<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 135,
     FQN="clang::CodeGen::operator!=", NM="_ZN5clang7CodeGenneENS0_12EHScopeStack15stable_iteratorES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGenneENS0_12EHScopeStack15stable_iteratorES2_")
    //</editor-fold>
    public static boolean $noteq_stable_iterator(EHScopeStack.stable_iterator A, EHScopeStack.stable_iterator B) {
      return A.Size != B.Size;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 107,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1ERKS2_")
    //</editor-fold>
    public /*inline*/ stable_iterator(final /*const*/ stable_iterator /*&*/ $Prm0) {
      // : Size(.Size) 
      //START JInit
      this.Size = $Prm0.Size;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 107,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::stable_iterator", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ stable_iterator(JD$Move _dparam, final stable_iterator /*&&*/$Prm0) {
      // : Size(static_cast<stable_iterator &&>().Size) 
      //START JInit
      this.Size = $Prm0.Size;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 107,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::operator=", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iteratoraSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iteratoraSERKS2_")
    //</editor-fold>
    public /*inline*/ stable_iterator /*&*/ $assign(final /*const*/ stable_iterator /*&*/ $Prm0) {
      this.Size = $Prm0.Size;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_iterator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 107,
     FQN="clang::CodeGen::EHScopeStack::stable_iterator::operator=", NM="_ZN5clang7CodeGen12EHScopeStack15stable_iteratoraSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack15stable_iteratoraSEOS2_")
    //</editor-fold>
    public /*inline*/ stable_iterator /*&*/ $assignMove(final stable_iterator /*&&*/$Prm0) {
      this.Size = $Prm0.Size;
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public stable_iterator clone() {
      return new stable_iterator(this);
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Size=" + Size; // NOI18N
    }
  };
  
  /// Information for lazily generating a cleanup.  Subclasses must be
  /// POD-like: cleanups will not be destructed, and they will be
  /// allocated on the cleanup stack and freely copied and moved
  /// around.
  ///
  /// Cleanup implementations should generally be declared in an
  /// anonymous namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 147,
   FQN="clang::CodeGen::EHScopeStack::Cleanup", NM="_ZN5clang7CodeGen12EHScopeStack7CleanupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7CleanupE")
  //</editor-fold>
  public abstract static class Cleanup implements Destructors.ClassWithDestructor {
    // Anchor the construction vtable.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::anchor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 306,
     FQN="clang::CodeGen::EHScopeStack::Cleanup::anchor", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup6anchorEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup6anchorEv")
    //</editor-fold>
    protected/*private*/ void anchor() {
    }

  /*protected:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::~Cleanup">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 152,
     FQN="clang::CodeGen::EHScopeStack::Cleanup::~Cleanup", NM="_ZN5clang7CodeGen12EHScopeStack7CleanupD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7CleanupD0Ev")
    //</editor-fold>
    public/*protected*/ void $destroy()/* = default*/ {
      /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
    }


  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Cleanup">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 155,
     FQN="clang::CodeGen::EHScopeStack::Cleanup::Cleanup", NM="_ZN5clang7CodeGen12EHScopeStack7CleanupC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7CleanupC1ERKS2_")
    //</editor-fold>
    public Cleanup(final /*const*/ Cleanup /*&*/ $Prm0)/* = default*/ {
      /*<<<default copy constructor: may be there is another TU where objects are copied?>>>*/
      // memcpy(this, $1, sizeof($1));
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Cleanup">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 156,
     FQN="clang::CodeGen::EHScopeStack::Cleanup::Cleanup", NM="_ZN5clang7CodeGen12EHScopeStack7CleanupC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7CleanupC1EOS2_")
    //</editor-fold>
    public Cleanup(JD$Move _dparam, final Cleanup /*&&*/$Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Cleanup">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 157,
     FQN="clang::CodeGen::EHScopeStack::Cleanup::Cleanup", NM="_ZN5clang7CodeGen12EHScopeStack7CleanupC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7CleanupC1Ev")
    //</editor-fold>
    public Cleanup()/* = default*/ {
    }

    
    /// Generation flags.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 160,
     FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsE")
    //</editor-fold>
    public static class Flags {
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::(anonymous)">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 161,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::(anonymous)", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsE_Unnamed_enum",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsE_Unnamed_enum")
      //</editor-fold>
      /*enum ANONYMOUS_INT_CONSTANTS {*/
        public static final /*uint*/int F_IsForEH = 0x1;
        public static final /*uint*/int F_IsNormalCleanupKind = 0x2;
        public static final /*uint*/int F_IsEHCleanupKind = 0x4;
      /*}*/;
      private /*uint*/int flags;
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::Flags">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 169,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::Flags", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsC1Ev")
      //</editor-fold>
      public Flags() {
        // : flags(0) 
        //START JInit
        this.flags = 0;
        //END JInit
      }

      
      /// isForEH - true if the current emission is for an EH cleanup.
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::isForEHCleanup">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 172,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::isForEHCleanup", NM="_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags14isForEHCleanupEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags14isForEHCleanupEv")
      //</editor-fold>
      public boolean isForEHCleanup() /*const*/ {
        return ((flags & F_IsForEH) != 0);
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::isForNormalCleanup">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 173,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::isForNormalCleanup", NM="_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags18isForNormalCleanupEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags18isForNormalCleanupEv")
      //</editor-fold>
      public boolean isForNormalCleanup() /*const*/ {
        return !isForEHCleanup();
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::setIsForEHCleanup">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 174,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::setIsForEHCleanup", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup5Flags17setIsForEHCleanupEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup5Flags17setIsForEHCleanupEv")
      //</editor-fold>
      public void setIsForEHCleanup() {
        flags |= F_IsForEH;
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::isNormalCleanupKind">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 176,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::isNormalCleanupKind", NM="_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags19isNormalCleanupKindEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags19isNormalCleanupKindEv")
      //</editor-fold>
      public boolean isNormalCleanupKind() /*const*/ {
        return ((flags & F_IsNormalCleanupKind) != 0);
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::setIsNormalCleanupKind">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 177,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::setIsNormalCleanupKind", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup5Flags22setIsNormalCleanupKindEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup5Flags22setIsNormalCleanupKindEv")
      //</editor-fold>
      public void setIsNormalCleanupKind() {
        flags |= F_IsNormalCleanupKind;
      }

      
      /// isEHCleanupKind - true if the cleanup was pushed as an EH
      /// cleanup.
      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::isEHCleanupKind">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 181,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::isEHCleanupKind", NM="_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags15isEHCleanupKindEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack7Cleanup5Flags15isEHCleanupKindEv")
      //</editor-fold>
      public boolean isEHCleanupKind() /*const*/ {
        return ((flags & F_IsEHCleanupKind) != 0);
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::setIsEHCleanupKind">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 182,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::setIsEHCleanupKind", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup5Flags18setIsEHCleanupKindEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup5Flags18setIsEHCleanupKindEv")
      //</editor-fold>
      public void setIsEHCleanupKind() {
        flags |= F_IsEHCleanupKind;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Flags::Flags">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 160,
       FQN="clang::CodeGen::EHScopeStack::Cleanup::Flags::Flags", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsC1ERKS3_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup5FlagsC1ERKS3_")
      //</editor-fold>
      public /*inline*/ Flags(final /*const*/ Flags /*&*/ $Prm0) {
        // : flags(.flags) 
        //START JInit
        this.flags = $Prm0.flags;
        //END JInit
      }

      
      @Override public String toString() {
        return "" + "flags=" + flags; // NOI18N
      }
    };
    
    /// Emit the cleanup.  For normal cleanups, this is run in the
    /// same EH context as when the cleanup was pushed, i.e. the
    /// immediately-enclosing context of the cleanup scope.  For
    /// EH cleanups, this is run in a terminate context.
    ///
    // \param flags cleanup kind.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::Cleanup::Emit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 192,
     FQN="clang::CodeGen::EHScopeStack::Cleanup::Emit", NM="_ZN5clang7CodeGen12EHScopeStack7Cleanup4EmitERNS0_15CodeGenFunctionENS2_5FlagsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack7Cleanup4EmitERNS0_15CodeGenFunctionENS2_5FlagsE")
    //</editor-fold>
    public abstract /*virtual*/ void Emit(final CodeGenFunction /*&*/ CGF, Flags flags)/* = 0*/;

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// ConditionalCleanup stores the saved form of its parameters,
  /// then restores them and performs the cleanup.
  /*template <class T, class ... As> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::ConditionalCleanup">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 197,
   FQN="clang::CodeGen::EHScopeStack::ConditionalCleanup", NM="_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanupE")
  //</editor-fold>
  public static final class ConditionalCleanup</*class*/ T extends Cleanup /*, class ... As*/>  extends /*public*/ Cleanup {
    // JAVA: typedef std::tuple<typename DominatingValue<As>::saved_type...> SavedTuple
//    public final class SavedTuple extends DominatingValue.saved_type[]{ };
    private tuple Saved;
    
    /*template <std::size_t... Is> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::ConditionalCleanup::restore">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 203,
     FQN="clang::CodeGen::EHScopeStack::ConditionalCleanup::restore", NM="Tpl__ZN5clang7CodeGen12EHScopeStack18ConditionalCleanup7restoreERNS0_15CodeGenFunctionEN4llvm14index_sequenceIJXspT_EEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=Tpl__ZN5clang7CodeGen12EHScopeStack18ConditionalCleanup7restoreERNS0_15CodeGenFunctionEN4llvm14index_sequenceIJXspT_EEEE")
    //</editor-fold>
    private /*<uint... Is>*/ T restore(final CodeGenFunction /*&*/ CGF) {
      // It's important that the restores are emitted in order. The braced init
      // list guarentees that.
      //return T(((void)DominatingValue.<As>restore(CGF, std.<Is>get(Saved))...));
      Object[] a = new Object[index_sequence.length];
      for (int i = 0; i < index_sequence.length; i++) {
        a[i] = DominatingValue.restore(CGF, std.get(index_sequence[i], Saved));
      }
      return $factory.$call(a);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::ConditionalCleanup::Emit">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 209,
     FQN="clang::CodeGen::EHScopeStack::ConditionalCleanup::Emit", NM="_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanup4EmitERNS0_15CodeGenFunctionENS1_7Cleanup5FlagsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanup4EmitERNS0_15CodeGenFunctionENS1_7Cleanup5FlagsE")
    //</editor-fold>
    @Override public/*private*/ void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
      restore(CGF).Emit(CGF, flags);
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::ConditionalCleanup::ConditionalCleanup<T, As...>">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 214,
     FQN="clang::CodeGen::EHScopeStack::ConditionalCleanup::ConditionalCleanup<T, As...>", NM="_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanupC1EDpNS0_15DominatingValueIT0_E10saved_typeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanupC1EDpNS0_15DominatingValueIT0_E10saved_typeE")
    //</editor-fold>
    public ConditionalCleanup(SupplierEx<T> $factory, int[] index_sequence, Object... A) {
      // : Saved(A...) 
      //START JInit
      this($factory, index_sequence);
      this.Saved = /*ParenListExpr*/make_tuple(A.length);
      System.arraycopy(A, 0, Saved, 0, A.length);
      //END JInit
    }

    
//    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::ConditionalCleanup::ConditionalCleanup<T, As...>">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 217,
//     FQN="clang::CodeGen::EHScopeStack::ConditionalCleanup::ConditionalCleanup<T, As...>", NM="_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanupC1ESt5tupleIJDpNS0_15DominatingValueIT0_E10saved_typeEEE",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack18ConditionalCleanupC1ESt5tupleIJDpNS0_15DominatingValueIT0_E10saved_typeEEE")
//    //</editor-fold>
//    public ConditionalCleanup(DominatingValue.saved_type[] Tuple) {
//      // : Saved(std::move(Tuple)) 
//      //START JInit
//      this.Saved = /*ParenListExpr*/new DominatingValue.saved_type[](std.move(Tuple));
//      //END JInit
//    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private final SupplierEx<T> $factory;
    private final int[] index_sequence;
    public ConditionalCleanup(SupplierEx<T> $factory, int[] index_sequence) {
      this.$factory = $factory;
      this.index_sequence = index_sequence;
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Saved=" + Saved // NOI18N
                + super.toString(); // NOI18N
    }
  };
/*private:*/
  // The implementation for this class is in CGException.h and
  // CGException.cpp; the definition is here because it's used as a
  // member of CodeGenFunction.
  
  /// The start of the scope-stack buffer, i.e. the allocated pointer
  /// for the buffer.  All of these pointers are either simultaneously
  /// null or simultaneously valid.
  private char$ptr/*char P*/ StartOfBuffer;
  
  /// The end of the buffer.
  private char$ptr/*char P*/ EndOfBuffer;
  
  /// The first valid entry in the buffer.
  private char$ptr/*char P*/ StartOfData;
  
  /// The innermost normal cleanup on the stack.
  private stable_iterator InnermostNormalCleanup;
  
  /// The innermost EH scope on the stack.
  private stable_iterator InnermostEHScope;
  
  /// The current set of branch fixups.  A branch fixup is a jump to
  /// an as-yet unemitted label, i.e. a label for which we don't yet
  /// know the EH stack depth.  Whenever we pop a cleanup, we have
  /// to thread all the current branch fixups through it.
  ///
  /// Fixups are recorded as the Use of the respective branch or
  /// switch statement.  The use points to the final destination.
  /// When popping out of a cleanup, these uses are threaded through
  /// the cleanup and adjusted to point to the new cleanup.
  ///
  /// Note that branches are allowed to jump into protected scopes
  /// in certain situations;  e.g. the following code is legal:
  ///     struct A { ~A(); }; // trivial ctor, non-trivial dtor
  ///     goto foo;
  ///     A a;
  ///    foo:
  ///     bar();
  private SmallVector<BranchFixup> BranchFixups;
  
  
  /// Push an entry of the given size onto this protected-scope stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::allocate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 114,
   FQN="clang::CodeGen::EHScopeStack::allocate", NM="_ZN5clang7CodeGen12EHScopeStack8allocateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8allocateEj")
  //</editor-fold>
  private char$ptr/*char P*/ allocate(/*size_t*/int Size) {
    Size = $ulong2uint(llvm.alignTo($uint2ulong(Size), $uint2ulong(ScopeStackAlignment)));
    if (!Native.$bool(StartOfBuffer)) {
      /*uint*/int Capacity = 1024;
      while ($less_uint(Capacity, Size)) {
        Capacity *= 2;
      }
      StartOfBuffer = create_char$ptr(new$char(Capacity));
      StartOfData = $tryClone(EndOfBuffer = $tryClone(StartOfBuffer.$add(Capacity)));
    } else if ($less_uint(((/*static_cast*//*size_t*/int)(StartOfData.$sub(StartOfBuffer))), Size)) {
      /*uint*/int CurrentCapacity = EndOfBuffer.$sub(StartOfBuffer);
      /*uint*/int UsedCapacity = CurrentCapacity - (StartOfData.$sub(StartOfBuffer));
      
      /*uint*/int NewCapacity = CurrentCapacity;
      do {
        NewCapacity *= 2;
      } while ($less_uint(NewCapacity, UsedCapacity + Size));
      
      char$ptr/*char P*/ NewStartOfBuffer = create_char$ptr(new$char(NewCapacity));
      char$ptr/*char P*/ NewEndOfBuffer = $tryClone(NewStartOfBuffer.$add(NewCapacity));
      char$ptr/*char P*/ NewStartOfData = $tryClone(NewEndOfBuffer.$sub(UsedCapacity));
      memcpy(NewStartOfData, StartOfData, UsedCapacity);
      /*delete[]*/Destructors.$destroyArray(StartOfBuffer);
      StartOfBuffer = $tryClone(NewStartOfBuffer);
      EndOfBuffer = $tryClone(NewEndOfBuffer);
      StartOfData = $tryClone(NewStartOfData);
    }
    assert (StartOfBuffer.$add(Size).$lesseq(StartOfData));
    StartOfData.$dec(Size);
    return StartOfData;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::deallocate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 145,
   FQN="clang::CodeGen::EHScopeStack::deallocate", NM="_ZN5clang7CodeGen12EHScopeStack10deallocateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack10deallocateEj")
  //</editor-fold>
  private void deallocate(/*size_t*/int Size) {
    StartOfData.$inc((int)llvm.alignTo($uint2ulong(Size), $uint2ulong(ScopeStackAlignment)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushCleanup">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 186,
   FQN="clang::CodeGen::EHScopeStack::pushCleanup", NM="_ZN5clang7CodeGen12EHScopeStack11pushCleanupENS0_11CleanupKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack11pushCleanupENS0_11CleanupKindEj")
  //</editor-fold>
  private Object/*void P*/ pushCleanup(/*CleanupKind*//*uint*/int Kind, /*size_t*/int Size) {
    char$ptr/*char P*/ Buffer = $tryClone(allocate(EHCleanupScope.getSizeForCleanupSize(Size)));
    boolean IsNormalCleanup = ((Kind & CleanupKind.NormalCleanup) != 0);
    boolean IsEHCleanup = ((Kind & CleanupKind.EHCleanup) != 0);
    boolean IsActive = !((Kind & CleanupKind.InactiveCleanup) != 0);
    boolean IsLifetimeMarker = ((Kind & CleanupKind.LifetimeMarker) != 0);
    //EHCleanupScope /*P*/ Scope = ((/*JCast*/EHCleanupScope /*P*/ )(/*NEW_EXPR [System]*/Buffer = /*new (Buffer)*/ $new_uint_voidPtr(Buffer, (type$ptr<?> New$Mem)->{
    EHCleanupScope /*P*/ Scope = $new_uint_voidPtr(Buffer, (type$ptr<?> New$Mem)->{
        return new EHCleanupScope(IsNormalCleanup, 
                IsEHCleanup, 
                IsActive, 
                Size, 
                BranchFixups.size(), 
                new EHScopeStack.stable_iterator(InnermostNormalCleanup), 
                new EHScopeStack.stable_iterator(InnermostEHScope));
     });
    if (IsNormalCleanup) {
      InnermostNormalCleanup.$assignMove(stable_begin());
    }
    if (IsEHCleanup) {
      InnermostEHScope.$assignMove(stable_begin());
    }
    if (IsLifetimeMarker) {
      Scope.setLifetimeMarker();
    }
    
    return Scope.getCleanupBuffer();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::EHScopeStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 267,
   FQN="clang::CodeGen::EHScopeStack::EHScopeStack", NM="_ZN5clang7CodeGen12EHScopeStackC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStackC1Ev")
  //</editor-fold>
  public EHScopeStack() {
    // : StartOfBuffer(null), EndOfBuffer(null), StartOfData(null), InnermostNormalCleanup(stable_end()), InnermostEHScope(stable_end()), BranchFixups() 
    //START JInit
    this.StartOfBuffer = null;
    this.EndOfBuffer = null;
    this.StartOfData = null;
    this.InnermostNormalCleanup = EHScopeStack.stable_end();
    this.InnermostEHScope = EHScopeStack.stable_end();
    this.BranchFixups = new SmallVector<BranchFixup>(8, new BranchFixup());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::~EHScopeStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 270,
   FQN="clang::CodeGen::EHScopeStack::~EHScopeStack", NM="_ZN5clang7CodeGen12EHScopeStackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStackD0Ev")
  //</editor-fold>
  public void $destroy() {
    /*delete[]*/Destructors.$destroyArray(StartOfBuffer);
    //START JDestroy
    BranchFixups.$destroy();
    //END JDestroy
  }

  
  /// Push a lazily-created cleanup on the stack.
  /*template <class T, class ... As> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushCleanup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 273,
   FQN="clang::CodeGen::EHScopeStack::pushCleanup", NM="Tpl__ZN5clang7CodeGen12EHScopeStack11pushCleanupENS0_11CleanupKindEDpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=Tpl__ZN5clang7CodeGen12EHScopeStack11pushCleanupENS0_11CleanupKindEDpT0_")
  //</editor-fold>
  public </*class*/ T extends Cleanup> void pushCleanup$T(/*CleanupKind*//*uint*/int Kind, Supplier<T> $factory) {
    static_assert(AlignOf.Unnamed_enum.Alignment$Native <=  ScopeStackAlignment, $("Cleanup's alignment is too large."));
    Object/*void P*/ Buffer = pushCleanup(Kind, $sizeof_T());
    //Cleanup /*P*/ Obj = ((/*JCast*/T /*P*/ )(/*FIXME: NEW_EXPR [NoNewFun]*/Buffer = /*new (Buffer)*/ new T(( A... ))));
    Cleanup /*P*/ Obj = /*FIXME: NEW_EXPR [NoNewFun]*/ /*new (Buffer)*/ $factory.get();
    ///*J:(void)*/Obj;
  }

  
  /// Push a lazily-created cleanup on the stack. Tuple version.
  /*template <class T, class ... As> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushCleanupTuple">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 283,
   FQN="clang::CodeGen::EHScopeStack::pushCleanupTuple", NM="Tpl__ZN5clang7CodeGen12EHScopeStack16pushCleanupTupleENS0_11CleanupKindESt5tupleIJDpT0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=Tpl__ZN5clang7CodeGen12EHScopeStack16pushCleanupTupleENS0_11CleanupKindESt5tupleIJDpT0_EE")
  //</editor-fold>
  public </*class*/ T extends Cleanup> void pushCleanupTuple(/*CleanupKind*//*uint*/int Kind, final SupplierEx<T> $factory, Object ... A) {
    static_assert(AlignOf.Unnamed_enum.Alignment$Native < ScopeStackAlignment, $("Cleanup's alignment is too large."));
    Object/*void P*/ Buffer = pushCleanup(Kind, $sizeof_T());
    Cleanup /*P*/ Obj = /*FIXME: NEW_EXPR [NoNewFun]*/ /*new (Buffer)*/ $factory.$call(std.move(A));
    ///*J:(void)*/Obj;
  }

  
  // Feel free to add more variants of the following:
  
  /// Push a cleanup with non-constant storage requirements on the
  /// stack.  The cleanup type must provide an additional static method:
  ///   static size_t getExtraSize(size_t);
  /// The argument to this method will be the value N, which will also
  /// be passed as the first argument to the constructor.
  ///
  /// The data stored in the extra storage must obey the same
  /// restrictions as normal cleanup member data.
  ///
  /// The pointer returned from this method is valid until the cleanup
  /// stack is modified.
  /*template <class T, class ... As> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushCleanupWithExtra">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 305,
   FQN="clang::CodeGen::EHScopeStack::pushCleanupWithExtra", NM="Tpl__ZN5clang7CodeGen12EHScopeStack20pushCleanupWithExtraENS0_11CleanupKindEjDpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=Tpl__ZN5clang7CodeGen12EHScopeStack20pushCleanupWithExtraENS0_11CleanupKindEjDpT0_")
  //</editor-fold>
  public </*class*/ T extends CallDeleteDuringNew/*, class*/ /* As...*/> T /*P*/ pushCleanupWithExtra$CallDeleteDuringNew(/*CleanupKind*//*uint*/int Kind, /*size_t*/int N, final Supplier<T> $factory) {
    static_assert($lesseq_void_uint(AlignOf.Unnamed_enum.Alignment$Native, ScopeStackAlignment), $("Cleanup's alignment is too large."));
    Object/*void P*/ Buffer = pushCleanup(Kind, $sizeof_T() + T.getExtraSize(N));
    return /*FIXME: NEW_EXPR [NoNewFun]*/ /*new (Buffer)*/ $factory.get();
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED /*specialization*/)
  public </*class*/ T extends CallDeleteDuringConditionalNew/*, class*/ /* As...*/> T /*P*/ pushCleanupWithExtra$CallDeleteDuringConditionalNew(/*CleanupKind*//*uint*/int Kind, /*size_t*/int N, final Supplier<T> $factory) {
    static_assert($lesseq_void_uint(AlignOf.Unnamed_enum.Alignment$Native, ScopeStackAlignment), $("Cleanup's alignment is too large."));
    Object/*void P*/ Buffer = pushCleanup(Kind, $sizeof_T() + T.getExtraSize(N));
    return /*FIXME: NEW_EXPR [NoNewFun]*/ /*new (Buffer)*/ $factory.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushCopyOfCleanup">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 312,
   FQN="clang::CodeGen::EHScopeStack::pushCopyOfCleanup", NM="_ZN5clang7CodeGen12EHScopeStack17pushCopyOfCleanupENS0_11CleanupKindEPKvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack17pushCopyOfCleanupENS0_11CleanupKindEPKvj")
  //</editor-fold>
  public void pushCopyOfCleanup(/*CleanupKind*//*uint*/int Kind, /*const*/Object/*void P*/ Cleanup, /*size_t*/int Size) {
    throw new UnsupportedOperationException("EmptyBody");
    //Object/*void P*/ Buffer = pushCleanup(Kind, Size);
    //std.memcpy(Buffer, Cleanup, Size);
  }

  
  /// Pops a cleanup scope off the stack.  This is private to CGCleanup.cpp.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::popCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 210,
   FQN="clang::CodeGen::EHScopeStack::popCleanup", NM="_ZN5clang7CodeGen12EHScopeStack10popCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack10popCleanupEv")
  //</editor-fold>
  public void popCleanup() {
    assert (!empty()) : "popping exception stack when not empty";
    assert (isa_EHCleanupScope(begin().$star()));
    final EHCleanupScope /*&*/ Cleanup = cast_EHCleanupScope(begin().$star());
    InnermostNormalCleanup.$assignMove(Cleanup.getEnclosingNormalCleanup());
    InnermostEHScope.$assignMove(Cleanup.getEnclosingEHScope());
    deallocate(Cleanup.getAllocatedSize());
    
    // Destroy the cleanup.
    Cleanup.Destroy();
    
    // Check whether we can shrink the branch-fixups stack.
    if (!BranchFixups.empty()) {
      // If we no longer have any normal cleanups, all the fixups are
      // complete.
      if (!hasNormalCleanups()) {
        BranchFixups.clear();
      } else {
        
        // Otherwise we can still trim out unnecessary nulls.
        popNullFixups();
      }
    }
  }

  
  /// Push a set of catch handlers on the stack.  The catch is
  /// uninitialized and will need to have the given number of handlers
  /// set on it.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushCatch">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 252,
   FQN="clang::CodeGen::EHScopeStack::pushCatch", NM="_ZN5clang7CodeGen12EHScopeStack9pushCatchEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack9pushCatchEj")
  //</editor-fold>
  public EHCatchScope /*P*/ pushCatch(/*uint*/int numHandlers) {
    char$ptr/*char P*/ buffer = $tryClone(allocate(EHCatchScope.getSizeForNumHandlers(numHandlers)));
    EHCatchScope /*P*/ scope = /*NEW_EXPR [System]*/ /*new (buffer)*/ $new_uint_voidPtr(buffer, (type$ptr<?> New$Mem)->{
        return new EHCatchScope(numHandlers, new EHScopeStack.stable_iterator(InnermostEHScope));
     });
    InnermostEHScope.$assignMove(stable_begin());
    return scope;
  }

  
  /// Pops a catch scope off the stack.  This is private to CGException.cpp.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::popCatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 576,
   FQN="clang::CodeGen::EHScopeStack::popCatch", NM="_ZN5clang7CodeGen12EHScopeStack8popCatchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8popCatchEv")
  //</editor-fold>
  public /*inline*/ void popCatch() {
    assert (!empty()) : "popping exception stack when not empty";
    
    final EHCatchScope /*&*/ scope = cast_EHCatchScope(begin().$star());
    InnermostEHScope.$assignMove(scope.getEnclosingEHScope());
    deallocate(EHCatchScope.getSizeForNumHandlers(scope.getNumHandlers()));
  }

  
  /// Push an exceptions filter on the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushFilter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 235,
   FQN="clang::CodeGen::EHScopeStack::pushFilter", NM="_ZN5clang7CodeGen12EHScopeStack10pushFilterEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack10pushFilterEj")
  //</editor-fold>
  public EHFilterScope /*P*/ pushFilter(/*uint*/int numFilters) {
    assert (stable_iterator.$eq_stable_iterator(getInnermostEHScope(), EHScopeStack.stable_end()));
    char$ptr/*char P*/ buffer = $tryClone(allocate(EHFilterScope.getSizeForNumFilters(numFilters)));
    EHFilterScope /*P*/ filter = /*NEW_EXPR [System]*/ /*new (buffer)*/ $new_uint_voidPtr(buffer, (type$ptr<?> New$Mem)->{
        return new EHFilterScope(numFilters);
     });
    InnermostEHScope.$assignMove(stable_begin());
    return filter;
  }

  
  /// Pops an exceptions filter off the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::popFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 243,
   FQN="clang::CodeGen::EHScopeStack::popFilter", NM="_ZN5clang7CodeGen12EHScopeStack9popFilterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack9popFilterEv")
  //</editor-fold>
  public void popFilter() {
    assert (!empty()) : "popping exception stack when not empty";
    
    final EHFilterScope /*&*/ filter = cast_EHFilterScope(begin().$star());
    deallocate(EHFilterScope.getSizeForNumFilters(filter.getNumFilters()));
    
    InnermostEHScope.$assignMove(filter.getEnclosingEHScope());
  }

  
  /// Push a terminate handler on the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::pushTerminate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 260,
   FQN="clang::CodeGen::EHScopeStack::pushTerminate", NM="_ZN5clang7CodeGen12EHScopeStack13pushTerminateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack13pushTerminateEv")
  //</editor-fold>
  public void pushTerminate() {
    char$ptr/*char P*/ Buffer = $tryClone(allocate(EHTerminateScope.getSize()));
    /*NEW_EXPR [System]*/ /*new (Buffer)*/ $new_uint_voidPtr(Buffer, (type$ptr<?> New$Mem)->{
        return new EHTerminateScope(new EHScopeStack.stable_iterator(InnermostEHScope));
     });
    InnermostEHScope.$assignMove(stable_begin());
  }

  
  /// Pops a terminate handler off the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::popTerminate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 584,
   FQN="clang::CodeGen::EHScopeStack::popTerminate", NM="_ZN5clang7CodeGen12EHScopeStack12popTerminateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack12popTerminateEv")
  //</editor-fold>
  public /*inline*/ void popTerminate() {
    assert (!empty()) : "popping exception stack when not empty";
    
    final EHTerminateScope /*&*/ scope = cast_EHTerminateScope(begin().$star());
    InnermostEHScope.$assignMove(scope.getEnclosingEHScope());
    deallocate(EHTerminateScope.getSize());
  }

  
  // Returns true iff the current scope is either empty or contains only
  // lifetime markers, i.e. no real cleanup code
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::containsOnlyLifetimeMarkers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 149,
   FQN="clang::CodeGen::EHScopeStack::containsOnlyLifetimeMarkers", NM="_ZNK5clang7CodeGen12EHScopeStack27containsOnlyLifetimeMarkersENS1_15stable_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack27containsOnlyLifetimeMarkersENS1_15stable_iteratorE")
  //</editor-fold>
  public boolean containsOnlyLifetimeMarkers(EHScopeStack.stable_iterator Old) /*const*/ {
    for (EHScopeStack.iterator it = begin(); stable_iterator.$noteq_stable_iterator(stabilize(new iterator(it)), /*NO_COPY*/Old); it.$postInc(0)) {
      EHCleanupScope /*P*/ cleanup = dyn_cast_EHCleanupScope(/*AddrOf*/it.$star());
      if (!(cleanup != null) || !cleanup.isLifetimeMarker()) {
        return false;
      }
    }
    
    return true;
  }

  
  /// Determines whether the exception-scopes stack is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 345,
   FQN="clang::CodeGen::EHScopeStack::empty", NM="_ZNK5clang7CodeGen12EHScopeStack5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return $eq_ptr(StartOfData, EndOfBuffer);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::requiresLandingPad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 160,
   FQN="clang::CodeGen::EHScopeStack::requiresLandingPad", NM="_ZNK5clang7CodeGen12EHScopeStack18requiresLandingPadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack18requiresLandingPadEv")
  //</editor-fold>
  public boolean requiresLandingPad() /*const*/ {
    for (stable_iterator si = getInnermostEHScope(); stable_iterator.$noteq_stable_iterator(/*NO_COPY*/si, EHScopeStack.stable_end());) {
      {
        // Skip lifetime markers.
        EHCleanupScope /*P*/ cleanup = dyn_cast_EHCleanupScope(/*AddrOf*/find(/*NO_COPY*/si).$star());
        if ((cleanup != null)) {
          if (cleanup.isLifetimeMarker()) {
            si.$assignMove(cleanup.getEnclosingEHScope());
            continue;
          }
        }
      }
      return true;
    }
    
    return false;
  }

  
  /// Determines whether there are any normal cleanups on the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::hasNormalCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 350,
   FQN="clang::CodeGen::EHScopeStack::hasNormalCleanups", NM="_ZNK5clang7CodeGen12EHScopeStack17hasNormalCleanupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack17hasNormalCleanupsEv")
  //</editor-fold>
  public boolean hasNormalCleanups() /*const*/ {
    return stable_iterator.$noteq_stable_iterator(/*NO_COPY*/InnermostNormalCleanup, EHScopeStack.stable_end());
  }

  
  /// Returns the innermost normal cleanup on the stack, or
  /// stable_end() if there are no normal cleanups.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::getInnermostNormalCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 356,
   FQN="clang::CodeGen::EHScopeStack::getInnermostNormalCleanup", NM="_ZNK5clang7CodeGen12EHScopeStack25getInnermostNormalCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack25getInnermostNormalCleanupEv")
  //</editor-fold>
  public stable_iterator getInnermostNormalCleanup() /*const*/ {
    return new stable_iterator(InnermostNormalCleanup);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::getInnermostActiveNormalCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 174,
   FQN="clang::CodeGen::EHScopeStack::getInnermostActiveNormalCleanup", NM="_ZNK5clang7CodeGen12EHScopeStack31getInnermostActiveNormalCleanupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack31getInnermostActiveNormalCleanupEv")
  //</editor-fold>
  public EHScopeStack.stable_iterator getInnermostActiveNormalCleanup() /*const*/ {
    for (stable_iterator si = getInnermostNormalCleanup(), se = EHScopeStack.stable_end();
         stable_iterator.$noteq_stable_iterator(/*NO_COPY*/si, /*NO_COPY*/se);) {
      final EHCleanupScope /*&*/ cleanup = cast_EHCleanupScope(find(/*NO_COPY*/si).$star());
      if (cleanup.isActive()) {
        return si;
      }
      si.$assignMove(cleanup.getEnclosingNormalCleanup());
    }
    return EHScopeStack.stable_end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::getInnermostEHScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 361,
   FQN="clang::CodeGen::EHScopeStack::getInnermostEHScope", NM="_ZNK5clang7CodeGen12EHScopeStack19getInnermostEHScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack19getInnermostEHScopeEv")
  //</editor-fold>
  public stable_iterator getInnermostEHScope() /*const*/ {
    return new stable_iterator(InnermostEHScope);
  }

  
  /// An unstable reference to a scope-stack depth.  Invalidated by
  /// pushes but not pops.
  
  /// A non-stable pointer into the scope stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 504,
   FQN="clang::CodeGen::EHScopeStack::iterator", NM="_ZN5clang7CodeGen12EHScopeStack8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iteratorE")
  //</editor-fold>
  public static class iterator implements Native.NativeComparable<iterator> {
    private char$ptr/*char P*/ Ptr;
    
    /*friend  class EHScopeStack*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 508,
     FQN="clang::CodeGen::EHScopeStack::iterator::iterator", NM="_ZN5clang7CodeGen12EHScopeStack8iteratorC1EPc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iteratorC1EPc")
    //</editor-fold>
    private /*explicit*/ iterator(char$ptr/*char P*/ Ptr) {
      // : Ptr(Ptr) 
      //START JInit
      this.Ptr = $tryClone(Ptr);
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 511,
     FQN="clang::CodeGen::EHScopeStack::iterator::iterator", NM="_ZN5clang7CodeGen12EHScopeStack8iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iteratorC1Ev")
    //</editor-fold>
    public iterator() {
      // : Ptr(null) 
      //START JInit
      this.Ptr = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::get">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 513,
     FQN="clang::CodeGen::EHScopeStack::iterator::get", NM="_ZNK5clang7CodeGen12EHScopeStack8iterator3getEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack8iterator3getEv")
    //</editor-fold>
    public EHScope /*P*/ get() /*const*/ {
      return reinterpret_cast(EHScope /*P*/ .class, Ptr);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 517,
     FQN="clang::CodeGen::EHScopeStack::iterator::operator->", NM="_ZNK5clang7CodeGen12EHScopeStack8iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack8iteratorptEv")
    //</editor-fold>
    public EHScope /*P*/ $arrow() /*const*/ {
      return get();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 518,
     FQN="clang::CodeGen::EHScopeStack::iterator::operator*", NM="_ZNK5clang7CodeGen12EHScopeStack8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack8iteratordeEv")
    //</editor-fold>
    public EHScope /*&*/ $star() /*const*/ {
      return /*Deref*/get();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 520,
     FQN="clang::CodeGen::EHScopeStack::iterator::operator++", NM="_ZN5clang7CodeGen12EHScopeStack8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iteratorppEv")
    //</editor-fold>
    public iterator /*&*/ $preInc() {
      /*size_t*/int Size = 0;
      switch (get().getKind()) {
       case Catch:
        Size = EHCatchScope.getSizeForNumHandlers(((/*static_cast*//*const*/ EHCatchScope /*P*/ )(get())).getNumHandlers());
        break;
       case Filter:
        Size = EHFilterScope.getSizeForNumFilters(((/*static_cast*//*const*/ EHFilterScope /*P*/ )(get())).getNumFilters());
        break;
       case Cleanup:
        Size = ((/*static_cast*//*const*/ EHCleanupScope /*P*/ )(get())).getAllocatedSize();
        break;
       case Terminate:
        Size = EHTerminateScope.getSize();
        break;
       case PadEnd:
        Size = EHPadEndScope.getSize();
        break;
      }
      Ptr.$inc((int)llvm.alignTo($uint2ulong(Size), $uint2ulong(ScopeStackAlignment)));
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::next">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 549,
     FQN="clang::CodeGen::EHScopeStack::iterator::next", NM="_ZN5clang7CodeGen12EHScopeStack8iterator4nextEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iterator4nextEv")
    //</editor-fold>
    public iterator next() {
      iterator copy = new iterator(/*Deref*/this);
      copy.$preInc();
      return copy;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 555,
     FQN="clang::CodeGen::EHScopeStack::iterator::operator++", NM="_ZN5clang7CodeGen12EHScopeStack8iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iteratorppEi")
    //</editor-fold>
    public iterator $postInc(int $Prm0) {
      iterator copy = new iterator(/*Deref*/this);
      $preInc();
      return copy;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::encloses">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 561,
     FQN="clang::CodeGen::EHScopeStack::iterator::encloses", NM="_ZNK5clang7CodeGen12EHScopeStack8iterator8enclosesES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack8iterator8enclosesES2_")
    //</editor-fold>
    public boolean encloses(iterator other) /*const*/ {
      return Ptr.$greatereq(other.Ptr);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::strictlyEncloses">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 562,
     FQN="clang::CodeGen::EHScopeStack::iterator::strictlyEncloses", NM="_ZNK5clang7CodeGen12EHScopeStack8iterator16strictlyEnclosesES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack8iterator16strictlyEnclosesES2_")
    //</editor-fold>
    public boolean strictlyEncloses(iterator other) /*const*/ {
      return Ptr.$greater(other.Ptr);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 564,
     FQN="clang::CodeGen::EHScopeStack::iterator::operator==", NM="_ZNK5clang7CodeGen12EHScopeStack8iteratoreqES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack8iteratoreqES2_")
    //</editor-fold>
    public boolean $eq(iterator other) /*const*/ {
      return $eq_ptr(Ptr, other.Ptr);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 565,
     FQN="clang::CodeGen::EHScopeStack::iterator::operator!=", NM="_ZNK5clang7CodeGen12EHScopeStack8iteratorneES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack8iteratorneES2_")
    //</editor-fold>
    public boolean $noteq(iterator other) /*const*/ {
      return $noteq_ptr(Ptr, other.Ptr);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 504,
     FQN="clang::CodeGen::EHScopeStack::iterator::iterator", NM="_ZN5clang7CodeGen12EHScopeStack8iteratorC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iteratorC1ERKS2_")
    //</editor-fold>
    public /*inline*/ iterator(final /*const*/ iterator /*&*/ $Prm0) {
      // : Ptr(.Ptr) 
      //START JInit
      this.Ptr = $tryClone($Prm0.Ptr);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 504,
     FQN="clang::CodeGen::EHScopeStack::iterator::iterator", NM="_ZN5clang7CodeGen12EHScopeStack8iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack8iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ iterator(JD$Move _dparam, final iterator /*&&*/$Prm0) {
      // : Ptr(static_cast<iterator &&>().Ptr) 
      //START JInit
      this.Ptr = $tryClone($Prm0.Ptr);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Ptr=" + Ptr; // NOI18N
    }
  };
  
  /// Returns an iterator pointing to the innermost EH scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 568,
   FQN="clang::CodeGen::EHScopeStack::begin", NM="_ZNK5clang7CodeGen12EHScopeStack5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack5beginEv")
  //</editor-fold>
  public /*inline*/ EHScopeStack.iterator begin() /*const*/ {
    return new iterator(StartOfData);
  }

  
  /// Returns an iterator pointing to the outermost EH scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 572,
   FQN="clang::CodeGen::EHScopeStack::end", NM="_ZNK5clang7CodeGen12EHScopeStack3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack3endEv")
  //</editor-fold>
  public /*inline*/ EHScopeStack.iterator end() /*const*/ {
    return new iterator(EndOfBuffer);
  }

  
  /// Create a stable reference to the top of the EH stack.  The
  /// returned reference is valid until that scope is popped off the
  /// stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 379,
   FQN="clang::CodeGen::EHScopeStack::stable_begin", NM="_ZNK5clang7CodeGen12EHScopeStack12stable_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack12stable_beginEv")
  //</editor-fold>
  public stable_iterator stable_begin() /*const*/ {
    return new stable_iterator(std.distance(StartOfData, EndOfBuffer));
  }

  
  /// Create a stable reference to the bottom of the EH stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stable_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 384,
   FQN="clang::CodeGen::EHScopeStack::stable_end", NM="_ZN5clang7CodeGen12EHScopeStack10stable_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack10stable_endEv")
  //</editor-fold>
  public static stable_iterator stable_end() {
    return new stable_iterator(0);
  }

  
  /// Translates an iterator into a stable_iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::stabilize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 598,
   FQN="clang::CodeGen::EHScopeStack::stabilize", NM="_ZNK5clang7CodeGen12EHScopeStack9stabilizeENS1_8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack9stabilizeENS1_8iteratorE")
  //</editor-fold>
  public /*inline*/ EHScopeStack.stable_iterator stabilize(iterator ir) /*const*/ {
    assert (StartOfData.$lesseq(ir.Ptr) && ir.Ptr.$lesseq(EndOfBuffer));
    return new stable_iterator(EndOfBuffer.$sub(ir.Ptr));
  }

  
  /// Turn a stable reference to a scope depth into a unstable pointer
  /// to the EH stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::find">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 592,
   FQN="clang::CodeGen::EHScopeStack::find", NM="_ZNK5clang7CodeGen12EHScopeStack4findENS1_15stable_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack4findENS1_15stable_iteratorE")
  //</editor-fold>
  public /*inline*/ EHScopeStack.iterator find(stable_iterator sp) /*const*/ {
    assert (sp.isValid()) : "finding invalid savepoint";
    assert (sp.Size <= stable_begin().Size) : "finding savepoint after pop";
    return new iterator(EndOfBuffer.$sub(sp.Size));
  }

  
  /// Add a branch fixup to the current cleanup scope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::addBranchFixup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 396,
   FQN="clang::CodeGen::EHScopeStack::addBranchFixup", NM="_ZN5clang7CodeGen12EHScopeStack14addBranchFixupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack14addBranchFixupEv")
  //</editor-fold>
  public BranchFixup /*&*/ addBranchFixup() {
    assert (hasNormalCleanups()) : "adding fixup in scope without cleanups";
    BranchFixups.push_back(new BranchFixup());
    return BranchFixups.back();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::getNumBranchFixups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 402,
   FQN="clang::CodeGen::EHScopeStack::getNumBranchFixups", NM="_ZNK5clang7CodeGen12EHScopeStack18getNumBranchFixupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHScopeStack18getNumBranchFixupsEv")
  //</editor-fold>
  public /*uint*/int getNumBranchFixups() /*const*/ {
    return BranchFixups.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::getBranchFixup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 403,
   FQN="clang::CodeGen::EHScopeStack::getBranchFixup", NM="_ZN5clang7CodeGen12EHScopeStack14getBranchFixupEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack14getBranchFixupEj")
  //</editor-fold>
  public BranchFixup /*&*/ getBranchFixup(/*uint*/int I) {
    assert ($less_uint(I, getNumBranchFixups()));
    return BranchFixups.$at(I);
  }

  
  /// Pops lazily-removed fixups from the end of the list.  This
  /// should only be called by procedures which have just popped a
  /// cleanup or resolved one or more fixups.
  
  /// Remove any 'null' fixups on the stack.  However, we can't pop more
  /// fixups than the fixup depth on the innermost normal cleanup, or
  /// else fixups that we try to add to that cleanup will end up in the
  /// wrong place.  We *could* try to shrink fixup depths, but that's
  /// actually a lot of work for little benefit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::popNullFixups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp", line = 271,
   FQN="clang::CodeGen::EHScopeStack::popNullFixups", NM="_ZN5clang7CodeGen12EHScopeStack13popNullFixupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack13popNullFixupsEv")
  //</editor-fold>
  public void popNullFixups() {
    // We expect this to only be called when there's still an innermost
    // normal cleanup;  otherwise there really shouldn't be any fixups.
    assert (hasNormalCleanups());
    
    EHScopeStack.iterator it = find(/*NO_COPY*/InnermostNormalCleanup);
    /*uint*/int MinSize = cast_EHCleanupScope(it.$star()).getFixupDepth();
    assert ($greatereq_uint(BranchFixups.size(), MinSize)) : "fixup stack out of order";
    while ($greater_uint(BranchFixups.size(), MinSize)
       && BranchFixups.back().Destination == null) {
      BranchFixups.pop_back();
    }
  }

  
  /// Clears the branch-fixups list.  This should only be called by
  /// ResolveAllBranchFixups.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHScopeStack::clearFixups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/EHScopeStack.h", line = 415,
   FQN="clang::CodeGen::EHScopeStack::clearFixups", NM="_ZN5clang7CodeGen12EHScopeStack11clearFixupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHScopeStack11clearFixupsEv")
  //</editor-fold>
  public void clearFixups() {
    BranchFixups.clear();
  }
  
  private int $sizeof_T() {
    return 1;
  }

  @Override public String toString() {
    return "" + "StartOfBuffer=" + StartOfBuffer // NOI18N
              + ", EndOfBuffer=" + EndOfBuffer // NOI18N
              + ", StartOfData=" + StartOfData // NOI18N
              + ", InnermostNormalCleanup=" + InnermostNormalCleanup // NOI18N
              + ", InnermostEHScope=" + InnermostEHScope // NOI18N
              + ", BranchFixups=" + BranchFixups; // NOI18N
  }
}
