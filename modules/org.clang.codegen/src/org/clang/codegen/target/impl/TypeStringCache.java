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

package org.clang.codegen.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// TypeStringCache caches the meta encodings of Types.
///
/// The reason for caching TypeStrings is two fold:
///   1. To cache a type's encoding for later uses;
///   2. As a means to break recursive member type inclusion.
///
/// A cache Entry can have a Status of:
///   NonRecursive:   The type encoding is not recursive;
///   Recursive:      The type encoding is recursive;
///   Incomplete:     An incomplete TypeString;
///   IncompleteUsed: An incomplete TypeString that has been used in a
///                   Recursive type encoding.
///
/// A NonRecursive entry will have all of its sub-members expanded as fully
/// as possible. Whilst it may contain types which are recursive, the type
/// itself is not recursive and thus its encoding may be safely used whenever
/// the type is encountered.
///
/// A Recursive entry will have all of its sub-members expanded as fully as
/// possible. The type itself is recursive and it may contain other types which
/// are recursive. The Recursive encoding must not be used during the expansion
/// of a recursive type's recursive branch. For simplicity the code uses
/// IncompleteCount to reject all usage of Recursive encodings for member types.
///
/// An Incomplete entry is always a RecordType and only encodes its
/// identifier e.g. "s(S){}". Incomplete 'StubEnc' entries are ephemeral and
/// are placed into the cache during type expansion as a means to identify and
/// handle recursive inclusion of types as sub-members. If there is recursion
/// the entry becomes IncompleteUsed.
///
/// During the expansion of a RecordType's members:
///
///   If the cache contains a NonRecursive encoding for the member type, the
///   cached encoding is used;
///
///   If the cache contains a Recursive encoding for the member type, the
///   cached encoding is 'Swapped' out, as it may be incorrect, and...
///
///   If the member is a RecordType, an Incomplete encoding is placed into the
///   cache to break potential recursive inclusion of itself as a sub-member;
///
///   Once a member RecordType has been expanded, its temporary incomplete
///   entry is removed from the cache. If a Recursive encoding was swapped out
///   it is swapped back in;
///
///   If an incomplete entry is used to expand a sub-member, the incomplete
///   entry is marked as IncompleteUsed. The cache keeps count of how many
///   IncompleteUsed entries it currently contains in IncompleteUsedCount;
///
///   If a member's encoding is found to be a NonRecursive or Recursive viz:
///   IncompleteUsedCount==0, the member's encoding is added to the cache.
///   Else the member is part of a recursive type and thus the recursion has
///   been exited too soon for the encoding to be correct for the member.
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7279,
 FQN="(anonymous namespace)::TypeStringCache", NM="_ZN12_GLOBAL__N_115TypeStringCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCacheE")
//</editor-fold>
public class TypeStringCache implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::Status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7280,
   FQN="(anonymous namespace)::TypeStringCache::Status", NM="_ZN12_GLOBAL__N_115TypeStringCache6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache6StatusE")
  //</editor-fold>
  private enum Status implements Native.NativeUIntEnum {
    NonRecursive(0),
    Recursive(NonRecursive.getValue() + 1),
    Incomplete(Recursive.getValue() + 1),
    IncompleteUsed(Incomplete.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Status valueOf(int val) {
      Status out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Status[] VALUES;
      private static final Status[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Status kind : Status.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Status[min < 0 ? (1-min) : 0];
        VALUES = new Status[max >= 0 ? (1+max) : 0];
        for (Status kind : Status.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Status(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::Entry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7281,
   FQN="(anonymous namespace)::TypeStringCache::Entry", NM="_ZN12_GLOBAL__N_115TypeStringCache5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache5EntryE")
  //</editor-fold>
  private static class/*struct*/ Entry implements Destructors.ClassWithDestructor {
    public std.string Str; // The encoded TypeString for the type.
    public  Status State; // Information about the encoding in 'Str'.
    public std.string Swapped; // A temporary place holder for a Recursive encoding
    // during the expansion of RecordType's members.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::Entry::~Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7281,
     FQN="(anonymous namespace)::TypeStringCache::Entry::~Entry", NM="_ZN12_GLOBAL__N_115TypeStringCache5EntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache5EntryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Swapped.$destroy();
      Str.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::Entry::Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7281,
     FQN="(anonymous namespace)::TypeStringCache::Entry::Entry", NM="_ZN12_GLOBAL__N_115TypeStringCache5EntryC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache5EntryC1Ev")
    //</editor-fold>
    public /*inline*/ Entry() {
      // : Str(), Swapped() 
      //START JInit
      this.Str = new std.string();
      this.Swapped = new std.string();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Str=" + Str // NOI18N
                + ", State=" + State // NOI18N
                + ", Swapped=" + Swapped; // NOI18N
    }
  };
  private std.mapPtrType</*const*/ IdentifierInfo /*P*/ ,  Entry> Map;
  private /*uint*/int IncompleteCount; // Number of Incomplete entries in the Map.
  private /*uint*/int IncompleteUsedCount; // Number of IncompleteUsed entries in the Map.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::TypeStringCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7291,
   FQN="(anonymous namespace)::TypeStringCache::TypeStringCache", NM="_ZN12_GLOBAL__N_115TypeStringCacheC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCacheC1Ev")
  //</editor-fold>
  public TypeStringCache() {
    // : Map(), IncompleteCount(0), IncompleteUsedCount(0) 
    //START JInit
    this.Map = new std.mapPtrType</*const*/ IdentifierInfo /*P*/ ,  Entry>(IdentifierInfo.COMPARATOR, new  Entry());
    this.IncompleteCount = 0;
    this.IncompleteUsedCount = 0;
    //END JInit
  }

  
  /// During the expansion of a RecordType, an incomplete TypeString is placed
  /// into the cache as a means to identify and break recursion.
  /// If there is a Recursive encoding in the cache, it is swapped out and will
  /// be reinserted by removeIncomplete().
  /// All other types of encoding should have been used rather than arriving here.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::addIncomplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7389,
   FQN="(anonymous namespace)::TypeStringCache::addIncomplete", NM="_ZN12_GLOBAL__N_115TypeStringCache13addIncompleteEPKN5clang14IdentifierInfoESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache13addIncompleteEPKN5clang14IdentifierInfoESs")
  //</editor-fold>
  public void addIncomplete(/*const*/ IdentifierInfo /*P*/ ID, 
               std.string StubEnc) {
    if (!(ID != null)) {
      return;
    }
    final Entry /*&*/ E = Map.$at_T$C$R(ID);
    assert ((E.Str.empty() || E.State == Status.Recursive)) : "Incorrectly use of addIncomplete";
    assert (!StubEnc.empty()) : "Passing an empty string to addIncomplete()";
    E.Swapped.swap(E.Str); // swap out the Recursive
    E.Str.swap(StubEnc);
    E.State = Status.Incomplete;
    ++IncompleteCount;
  }

  
  /// Once the RecordType has been expanded, the temporary incomplete TypeString
  /// must be removed from the cache.
  /// If a Recursive was swapped out by addIncomplete(), it will be replaced.
  /// Returns true if the RecordType was defined recursively.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::removeIncomplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7407,
   FQN="(anonymous namespace)::TypeStringCache::removeIncomplete", NM="_ZN12_GLOBAL__N_115TypeStringCache16removeIncompleteEPKN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache16removeIncompleteEPKN5clang14IdentifierInfoE")
  //</editor-fold>
  public boolean removeIncomplete(/*const*/ IdentifierInfo /*P*/ ID) {
    if (!(ID != null)) {
      return false;
    }
    std.mapPtrType.iterator</*const*/ IdentifierInfo /*P*/ /*const*/, Entry> I = Map.find(ID);
    assert (I.$noteq(Map.end())) : "Entry not present";
    final Entry /*&*/ E = I.$arrow().second;
    assert ((E.State == Status.Incomplete || E.State == Status.IncompleteUsed)) : "Entry must be an incomplete type";
    boolean IsRecursive = false;
    if (E.State == Status.IncompleteUsed) {
      // We made use of our Incomplete encoding, thus we are recursive.
      IsRecursive = true;
      --IncompleteUsedCount;
    }
    if (E.Swapped.empty()) {
      Map.erase(new std.mapPtrType.iterator</*const*/ IdentifierInfo /*P*/ /*const*/, Entry>(I));
    } else {
      // Swap the Recursive back.
      E.Swapped.swap(E.Str);
      E.Swapped.clear();
      E.State = Status.Recursive;
    }
    --IncompleteCount;
    return IsRecursive;
  }

  
  /// Add the encoded TypeString to the cache only if it is NonRecursive or
  /// Recursive (viz: all sub-members were expanded as fully as possible).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::addIfComplete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7436,
   FQN="(anonymous namespace)::TypeStringCache::addIfComplete", NM="_ZN12_GLOBAL__N_115TypeStringCache13addIfCompleteEPKN5clang14IdentifierInfoEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache13addIfCompleteEPKN5clang14IdentifierInfoEN4llvm9StringRefEb")
  //</editor-fold>
  public void addIfComplete(/*const*/ IdentifierInfo /*P*/ ID, StringRef Str, 
               boolean IsRecursive) {
    if (!(ID != null) || (IncompleteUsedCount != 0)) {
      return; // No key or it is is an incomplete sub-type so don't add.
    }
    final Entry /*&*/ E = Map.$at_T$C$R(ID);
    if (IsRecursive && !E.Str.empty()) {
      assert (E.State == Status.Recursive && E.Str.size() == Str.size()) : "This is not the same Recursive entry";
      // The parent container was not recursive after all, so we could have used
      // this Recursive sub-member entry after all, but we assumed the worse when
      // we started viz: IncompleteCount!=0.
      return;
    }
    assert (E.Str.empty()) : "Entry already present";
    E.Str.$assignMove(Str.str());
    E.State = IsRecursive ? Status.Recursive : Status.NonRecursive;
  }

  
  /// Return a cached TypeString encoding for the ID. If there isn't one, or we
  /// are recursively expanding a type (IncompleteCount != 0) and the cached
  /// encoding is Recursive, return an empty StringRef.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::lookupStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7457,
   FQN="(anonymous namespace)::TypeStringCache::lookupStr", NM="_ZN12_GLOBAL__N_115TypeStringCache9lookupStrEPKN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCache9lookupStrEPKN5clang14IdentifierInfoE")
  //</editor-fold>
  public StringRef lookupStr(/*const*/ IdentifierInfo /*P*/ ID) {
    if (!(ID != null)) {
      return new StringRef(); // We have no key.
    }
    std.mapPtrType.iterator</*const*/ IdentifierInfo /*P*/ /*const*/, Entry> I = Map.find(ID);
    if (I.$eq(Map.end())) {
      return new StringRef(); // We have no encoding.
    }
    final Entry /*&*/ E = I.$arrow().second;
    if (E.State == Status.Recursive && (IncompleteCount != 0)) {
      return new StringRef(); // We don't use Recursive encodings for member types.
    }
    if (E.State == Status.Incomplete) {
      // The incomplete type is being used to break out of recursion.
      E.State = Status.IncompleteUsed;
      ++IncompleteUsedCount;
    }
    return new StringRef(E.Str.c_str());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeStringCache::~TypeStringCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 7279,
   FQN="(anonymous namespace)::TypeStringCache::~TypeStringCache", NM="_ZN12_GLOBAL__N_115TypeStringCacheD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_115TypeStringCacheD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Map.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Map=" + Map // NOI18N
              + ", IncompleteCount=" + IncompleteCount // NOI18N
              + ", IncompleteUsedCount=" + IncompleteUsedCount; // NOI18N
  }
}
