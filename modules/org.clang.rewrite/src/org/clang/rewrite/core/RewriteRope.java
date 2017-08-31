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

package org.clang.rewrite.core;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.clang.rewrite.core.RopeRefCountString.$sizeof_RopeRefCountString;


//===--------------------------------------------------------------------===//
// RewriteRope Class
//===--------------------------------------------------------------------===//

/// RewriteRope - A powerful string class.  This class supports extremely
/// efficient insertions and deletions into the middle of it, even for
/// ridiculously long strings.
//<editor-fold defaultstate="collapsed" desc="clang::RewriteRope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 165,
 FQN="clang::RewriteRope", NM="_ZN5clang11RewriteRopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRopeE")
//</editor-fold>
public class RewriteRope implements Destructors.ClassWithDestructor {
  private RopePieceBTree Chunks;
  
  /// We allocate space for string data out of a buffer of size AllocChunkSize.
  /// This keeps track of how much space is left.
  private IntrusiveRefCntPtr<RopeRefCountString> AllocBuffer;
  private /*uint*/int AllocOffs;
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 172,
   FQN="clang::RewriteRope::(anonymous)", NM="_ZN5clang11RewriteRopeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRopeE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int AllocChunkSize = 4080;
  /*}*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::RewriteRope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 175,
   FQN="clang::RewriteRope::RewriteRope", NM="_ZN5clang11RewriteRopeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRopeC1Ev")
  //</editor-fold>
  public RewriteRope() {
    // : Chunks(), AllocBuffer(null), AllocOffs(AllocChunkSize) 
    //START JInit
    this.Chunks = new RopePieceBTree();
    this.AllocBuffer = new IntrusiveRefCntPtr<RopeRefCountString>((RopeRefCountString /*P*/ )null);
    this.AllocOffs = AllocChunkSize;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::RewriteRope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 176,
   FQN="clang::RewriteRope::RewriteRope", NM="_ZN5clang11RewriteRopeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRopeC1ERKS0_")
  //</editor-fold>
  public RewriteRope(/*const*/ RewriteRope /*&*/ RHS) {
    // : Chunks(RHS.Chunks), AllocBuffer(null), AllocOffs(AllocChunkSize) 
    //START JInit
    this.Chunks = new RopePieceBTree(RHS.Chunks);
    this.AllocBuffer = new IntrusiveRefCntPtr<RopeRefCountString>((RopeRefCountString /*P*/ )null);
    this.AllocOffs = AllocChunkSize;
    //END JInit
  }

  
  /*typedef RopePieceBTree::iterator iterator*/
//  public final class iterator extends RopePieceBTreeIterator{ };
  /*typedef RopePieceBTree::iterator const_iterator*/
//  public final class const_iterator extends RopePieceBTreeIterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 182,
   FQN="clang::RewriteRope::begin", NM="_ZNK5clang11RewriteRope5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang11RewriteRope5beginEv")
  //</editor-fold>
  public RopePieceBTreeIterator begin() /*const*/ {
    return Chunks.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 183,
   FQN="clang::RewriteRope::end", NM="_ZNK5clang11RewriteRope3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang11RewriteRope3endEv")
  //</editor-fold>
  public RopePieceBTreeIterator end() /*const*/ {
    return Chunks.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 184,
   FQN="clang::RewriteRope::size", NM="_ZNK5clang11RewriteRope4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang11RewriteRope4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Chunks.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 186,
   FQN="clang::RewriteRope::clear", NM="_ZN5clang11RewriteRope5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRope5clearEv")
  //</editor-fold>
  public void clear() {
    Chunks.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::assign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 190,
   FQN="clang::RewriteRope::assign", NM="_ZN5clang11RewriteRope6assignEPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRope6assignEPKcS2_")
  //</editor-fold>
  public void assign(/*const*/char$ptr/*char P*/ Start, /*const*/char$ptr/*char P*/ End) {
    clear();
    if ($noteq_ptr(Start, End)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Chunks.insert(0, $c$.track(MakeRopeString(Start, End))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 196,
   FQN="clang::RewriteRope::insert", NM="_ZN5clang11RewriteRope6insertEjPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRope6insertEjPKcS2_")
  //</editor-fold>
  public void insert(/*uint*/int Offset, /*const*/char$ptr/*char P*/ Start, /*const*/char$ptr/*char P*/ End) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($lesseq_uint(Offset, size())) : "Invalid position to insert!";
      if ($eq_ptr(Start, End)) {
        return;
      }
      Chunks.insert(Offset, $c$.track(MakeRopeString(Start, End))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 202,
   FQN="clang::RewriteRope::erase", NM="_ZN5clang11RewriteRope5eraseEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRope5eraseEjj")
  //</editor-fold>
  public void erase(/*uint*/int Offset, /*uint*/int NumBytes) {
    assert ($lesseq_uint(Offset + NumBytes, size())) : "Invalid region to erase!";
    if (NumBytes == 0) {
      return;
    }
    Chunks.erase(Offset, NumBytes);
  }

/*private:*/
  
  //===----------------------------------------------------------------------===//
  // RewriteRope Implementation
  //===----------------------------------------------------------------------===//
  
  /// MakeRopeString - This copies the specified byte range into some instance of
  /// RopeRefCountString, and return a RopePiece that represents it.  This uses
  /// the AllocBuffer object to aggregate requests for small strings into one
  /// allocation instead of doing tons of tiny allocations.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::MakeRopeString">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp", line = 768,
   FQN="clang::RewriteRope::MakeRopeString", NM="_ZN5clang11RewriteRope14MakeRopeStringEPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang11RewriteRope14MakeRopeStringEPKcS2_")
  //</editor-fold>
  private RopePiece MakeRopeString(/*const*/char$ptr/*char P*/ Start, /*const*/char$ptr/*char P*/ End) {
    /*uint*/int Len = End.$sub(Start);
    assert ((Len != 0)) : "Zero length RopePiece is invalid!";
    
    // If we have space for this string in the current alloc buffer, use it.
    if ($lesseq_uint(AllocOffs + Len, AllocChunkSize)) {
      memcpy(AllocBuffer.$arrow().Data.$add(AllocOffs), Start, Len);
      AllocOffs += Len;
      return new RopePiece(new IntrusiveRefCntPtr<RopeRefCountString>(AllocBuffer), AllocOffs - Len, AllocOffs);
    }
    
    // If we don't have enough room because this specific allocation is huge,
    // just allocate a new rope piece for it alone.
    if ($greater_uint(Len, AllocChunkSize)) {
      // JAVA: Alloc
      /*uint*/int Size = Len + (true ? 1 : $sizeof_RopeRefCountString()) - 1;
      RopeRefCountString /*P*/ Res = new RopeRefCountString();//reinterpret_cast(RopeRefCountString /*P*/ .class, new$char(Size));
      Res.Data = create_char$ptr(new$char(Size));
      Res.RefCount = 0;
      memcpy(Res.Data, Start, Len);
      return new RopePiece(new IntrusiveRefCntPtr<RopeRefCountString>(Res), 0, Len);
    }
    
    // Otherwise, this was a small request but we just don't have space for it
    // Make a new chunk and share it with later allocations.
    // JAVA: Alloc
    /*uint*/int AllocSize = /*__builtin_offsetof(RopeRefCountString.class, "Data") +*/ AllocChunkSize;
    RopeRefCountString /*P*/ Res = new RopeRefCountString();//reinterpret_cast(RopeRefCountString /*P*/ .class, new$char(AllocSize));
    Res.RefCount = 0;
    Res.Data = create_char$ptr(new$char(AllocSize));
    memcpy(Res.Data, Start, Len);
    AllocBuffer.$assign(new IntrusiveRefCntPtr<RopeRefCountString>(Res));
    AllocOffs = Len;
    
    return new RopePiece(new IntrusiveRefCntPtr<RopeRefCountString>(AllocBuffer), 0, Len);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteRope::~RewriteRope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 165,
   FQN="clang::RewriteRope::~RewriteRope", NM="_ZN5clang11RewriteRopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang11RewriteRopeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AllocBuffer.$destroy();
    Chunks.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "Chunks=" + Chunks // NOI18N
              + ", AllocBuffer=" + AllocBuffer // NOI18N
              + ", AllocOffs=" + AllocOffs; // NOI18N
  }
}
