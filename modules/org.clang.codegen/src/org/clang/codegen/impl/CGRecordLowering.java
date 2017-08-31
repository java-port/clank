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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;

/// The CGRecordLowering is responsible for lowering an ASTRecordLayout to an
/// llvm::Type.  Some of the lowering is straightforward, some is not.  Here we
/// detail some of the complexities and weirdnesses here.
/// * LLVM does not have unions - Unions can, in theory be represented by any
///   llvm::Type with correct size.  We choose a field via a specific heuristic
///   and add padding if necessary.
/// * LLVM does not have bitfields - Bitfields are collected into contiguous
///   runs and allocated as a single storage type for the run.  ASTRecordLayout
///   contains enough information to determine where the runs break.  Microsoft
///   and Itanium follow different rules and use different codepaths.
/// * It is desired that, when possible, bitfields use the appropriate iN type
///   when lowered to llvm types.  For example unsigned x : 24 gets lowered to
///   i24.  This isn't always possible because i24 has storage size of 32 bit
///   and if it is possible to use that extra byte of padding we must use
///   [i8 x 3] instead of i24.  The function clipTailPadding does this.
///   C++ examples that require clipping:
///   struct { int a : 24; char b; }; // a must be clipped, b goes at offset 3
///   struct A { int a : 24; }; // a must be clipped because a struct like B
//    could exist: struct B : A { char b; }; // b goes at offset 3
/// * Clang ignores 0 sized bitfields and 0 sized bases but *not* zero sized
///   fields.  The existing asserts suggest that LLVM assumes that *every* field
///   has an underlying storage type.  Therefore empty structures containing
///   zero sized subobjects such as empty records or zero sized arrays still get
///   a zero sized (empty struct) storage type.
/// * Clang reads the complete type rather than the base type when generating
///   code to access fields.  Bitfields in tail position with tail padding may
///   be clipped in the base class but not the complete class (we may discover
///   that the tail padding is not used in the complete class.) However,
///   because LLVM reads from the complete type it can generate incorrect code
///   if we do not clip the tail padding off of the bitfield in the complete
///   layout.  This introduces a somewhat awkward extra unnecessary clip stage.
///   The location of the clip is stored internally as a sentinal of type
///   SCISSOR.  If LLVM were updated to read base types (which it probably
///   should because locations of things such as VBases are bogus in the llvm
///   type anyway) then we could eliminate the SCISSOR.
/// * Itanium allows nearly empty primary virtual bases.  These bases don't get
///   get their own storage because they're laid out as part of another base
///   or at the beginning of the structure.  Determining if a VBase actually
///   gets storage awkwardly involves a walk of all bases.
/// * VFPtrs and VBPtrs do *not* make a record NotZeroInitializable.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 74,
 FQN="(anonymous namespace)::CGRecordLowering", NM="_ZN12_GLOBAL__N_116CGRecordLoweringE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLoweringE")
//</editor-fold>
public class/*struct*/ CGRecordLowering implements Destructors.ClassWithDestructor {
  // MemberInfo is a helper structure that contains information about a record
  // member.  In additional to the standard member types, there exists a
  // sentinal member type that ensures correct rounding.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 78,
   FQN="(anonymous namespace)::CGRecordLowering::MemberInfo", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoE")
  //</editor-fold>
  public static class/*struct*/ MemberInfo implements NativeCloneable<MemberInfo> {
    public CharUnits Offset;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::InfoKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 80,
     FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::InfoKind", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfo8InfoKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfo8InfoKindE")
    //</editor-fold>
    public enum InfoKind implements Native.NativeUIntEnum {
      VFPtr(0),
      VBPtr(VFPtr.getValue() + 1),
      Field(VBPtr.getValue() + 1),
      Base(Field.getValue() + 1),
      VBase(Base.getValue() + 1),
      Scissor(VBase.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static InfoKind valueOf(int val) {
        InfoKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final InfoKind[] VALUES;
        private static final InfoKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (InfoKind kind : InfoKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new InfoKind[min < 0 ? (1-min) : 0];
          VALUES = new InfoKind[max >= 0 ? (1+max) : 0];
          for (InfoKind kind : InfoKind.values()) {
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
      private InfoKind(int val) { this.value = (/*uint*/int)val;}
      @Override public final /*uint*/int getValue() { return value;}
      //</editor-fold>
    };
    public  InfoKind Kind;
    public org.llvm.ir.Type /*P*/ Data;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 82,
     FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::(anonymous)", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoE_Unnamed_union1")
    //</editor-fold>
    public static class/*union*/ Unnamed_union1 {
      public /*const*/ FieldDecl /*P*/ FD;
      public /*const*/ CXXRecordDecl /*P*/ RD;
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::(anonymous union)::">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 82,
       FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::(anonymous union)::", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfo3$_0C1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfo3$_0C1EOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
        this.FD = $Prm0.FD;
        this.RD = $Prm0.RD;
        $Prm0.FD = null;
        $Prm0.RD = null;
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 82,
       FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::(anonymous union)::operator=", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfo3$_0aSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfo3$_0aSEOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
        assert this != $Prm0;
        this.FD = $Prm0.FD;
        this.RD = $Prm0.RD;      
        $Prm0.FD = null;
        $Prm0.RD = null;        
        return /*Deref*/this;
      }

      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN

      private Unnamed_union1() {}

      private /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
        this.FD = $Prm0.FD;
        this.RD = $Prm0.RD;
      }
      
      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "FD=" + "[FieldDecl]" // NOI18N
                  + ", RD=" + "[CXXRecordDecl]"; // NOI18N
      }
    };
    public Unnamed_union1 Unnamed_field3 = new Unnamed_union1();
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::MemberInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 86,
     FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::MemberInfo", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoC1EN5clang9CharUnitsENS1_8InfoKindEPN4llvm4TypeEPKNS2_9FieldDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoC1EN5clang9CharUnitsENS1_8InfoKindEPN4llvm4TypeEPKNS2_9FieldDeclE")
    //</editor-fold>
    public MemberInfo(CharUnits Offset, InfoKind Kind, org.llvm.ir.Type /*P*/ Data) {
      this(Offset, Kind, Data, 
        (/*const*/ FieldDecl /*P*/ )null);
    }
    public MemberInfo(CharUnits Offset, InfoKind Kind, org.llvm.ir.Type /*P*/ Data, 
        /*const*/ FieldDecl /*P*/ FD/*= null*/) {
      // : Offset(Offset), Kind(Kind), Data(Data), FD(FD) 
      //START JInit
      this.Offset = new CharUnits(Offset);
      this.Kind = Kind;
      this.Data = Data;
      /*Indirect*/this.Unnamed_field3.FD = FD;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::MemberInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 89,
     FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::MemberInfo", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoC1EN5clang9CharUnitsENS1_8InfoKindEPN4llvm4TypeEPKNS2_13CXXRecordDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoC1EN5clang9CharUnitsENS1_8InfoKindEPN4llvm4TypeEPKNS2_13CXXRecordDeclE")
    //</editor-fold>
    public MemberInfo(CharUnits Offset, InfoKind Kind, org.llvm.ir.Type /*P*/ Data, 
        /*const*/ CXXRecordDecl /*P*/ RD) {
      // : Offset(Offset), Kind(Kind), Data(Data), RD(RD) 
      //START JInit
      this.Offset = new CharUnits(Offset);
      this.Kind = Kind;
      this.Data = Data;
      /*Indirect*/this.Unnamed_field3.RD = RD;
      //END JInit
    }

    // MemberInfos are sorted so we define a < operator.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 93,
     FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::operator<", NM="_ZNK12_GLOBAL__N_116CGRecordLowering10MemberInfoltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_116CGRecordLowering10MemberInfoltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ MemberInfo /*&*/ a) /*const*/ {
      return Offset.$less(a.Offset);
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::MemberInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 78,
     FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::MemberInfo", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ MemberInfo(JD$Move _dparam, final MemberInfo /*&&*/$Prm0) {
      // : Offset(static_cast<MemberInfo &&>().Offset), Kind(static_cast<MemberInfo &&>().Kind), Data(static_cast<MemberInfo &&>().Data), Unnamed_field3(static_cast<MemberInfo &&>().) 
      //START JInit
      this.Offset = new CharUnits(JD$Move.INSTANCE, $Prm0.Offset);
      this.Kind = $Prm0.Kind;
      this.Data = $Prm0.Data;
      this.Unnamed_field3 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field3);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::MemberInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 78,
     FQN="(anonymous namespace)::CGRecordLowering::MemberInfo::operator=", NM="_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10MemberInfoaSEOS1_")
    //</editor-fold>
    public /*inline*/ MemberInfo /*&*/ $assignMove(final MemberInfo /*&&*/$Prm0) {
      this.Offset.$assignMove($Prm0.Offset);
      this.Kind = $Prm0.Kind;
      this.Data = $Prm0.Data;
      this.Unnamed_field3.$assignMove($Prm0.Unnamed_field3);
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public MemberInfo() { 
      this.Offset = new CharUnits();
      this.Kind = InfoKind.valueOf(0);
      this.Data = null;
      this.Unnamed_field3 = new Unnamed_union1();      
    }

    public /*inline*/ MemberInfo(final MemberInfo /*&*/$Prm0) {
      // : Offset(static_cast<MemberInfo &&>().Offset), Kind(static_cast<MemberInfo &&>().Kind), Data(static_cast<MemberInfo &&>().Data), Unnamed_field3(static_cast<MemberInfo &&>().) 
      //START JInit
      this.Offset = new CharUnits($Prm0.Offset);
      this.Kind = $Prm0.Kind;
      this.Data = $Prm0.Data;
      this.Unnamed_field3 = new Unnamed_union1($Prm0.Unnamed_field3);
      //END JInit
    }
    
    @Override public MemberInfo clone() {
      return new MemberInfo(this);
    }
    
    private static int compare(MemberInfo LHS, MemberInfo RHS) {
      if (LHS == RHS) return 0;
      if (LHS.$less(RHS)) return -1;
      if (RHS.$less(LHS)) return 1;
      return 0;
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Offset=" + Offset // NOI18N
                + ", Kind=" + Kind // NOI18N
                + ", Data=" + Data // NOI18N
                + ", Unnamed_field3=" + Unnamed_field3; // NOI18N
    }
  };
  // The constructor.
  // namespace {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::CGRecordLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 217,
   FQN="(anonymous namespace)::CGRecordLowering::CGRecordLowering", NM="_ZN12_GLOBAL__N_116CGRecordLoweringC1ERN5clang7CodeGen12CodeGenTypesEPKNS1_10RecordDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLoweringC1ERN5clang7CodeGen12CodeGenTypesEPKNS1_10RecordDeclEb")
  //</editor-fold>
  public CGRecordLowering(final CodeGenTypes /*&*/ Types, /*const*/ RecordDecl /*P*/ D, boolean Packed) {
    // : Types(Types), Context(Types.getContext()), D(D), RD(dyn_cast<CXXRecordDecl>(D)), Layout(Types.getContext().getASTRecordLayout(D)), DataLayout(Types.getDataLayout()), Members(), FieldTypes(), Fields(), BitFields(), NonVirtualBases(), VirtualBases(), IsZeroInitializable(true), IsZeroInitializableAsBase(true), Packed(Packed) 
    //START JInit
    this./*&*/Types=/*&*/Types;
    this./*&*/Context=/*&*/Types.getContext();
    this.D = D;
    this.RD = dyn_cast_CXXRecordDecl(D);
    this./*&*/Layout=/*&*/Types.getContext().getASTRecordLayout(D);
    this./*&*/DataLayout=/*&*/Types.getDataLayout();
    this.Members = new std.vector<MemberInfo>(new MemberInfo());
    this.FieldTypes = new SmallVector<org.llvm.ir.Type /*P*/ >(16, (org.llvm.ir.Type /*P*/ )null);
    this.Fields = new DenseMapTypeUInt</*const*/ FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.BitFields = new DenseMap</*const*/ FieldDecl /*P*/ , CGBitFieldInfo>(DenseMapInfo$LikePtr.$Info(), new CGBitFieldInfo());
    this.NonVirtualBases = new DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.VirtualBases = new DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.IsZeroInitializable = true;
    this.IsZeroInitializableAsBase = true;
    this.Packed = Packed;
    //END JInit
  }

  // Short helper routines.
  /// \brief Constructs a MemberInfo instance from an offset and llvm::Type *.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::StorageInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 99,
   FQN="(anonymous namespace)::CGRecordLowering::StorageInfo", NM="_ZN12_GLOBAL__N_116CGRecordLowering11StorageInfoEN5clang9CharUnitsEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering11StorageInfoEN5clang9CharUnitsEPN4llvm4TypeE")
  //</editor-fold>
  public MemberInfo StorageInfo(CharUnits Offset, org.llvm.ir.Type /*P*/ Data) {
    return new MemberInfo(new CharUnits(Offset), MemberInfo.InfoKind.Field, Data);
  }

  
  /// The Microsoft bitfield layout rule allocates discrete storage
  /// units of the field's formal type and only combines adjacent
  /// fields of the same formal type.  We want to emit a layout with
  /// these discrete storage units instead of combining them into a
  /// continuous run.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::isDiscreteBitFieldABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 108,
   FQN="(anonymous namespace)::CGRecordLowering::isDiscreteBitFieldABI", NM="_ZN12_GLOBAL__N_116CGRecordLowering21isDiscreteBitFieldABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering21isDiscreteBitFieldABIEv")
  //</editor-fold>
  public boolean isDiscreteBitFieldABI() {
    return Context.getTargetInfo().getCXXABI().isMicrosoft()
       || D.isMsStruct(Context);
  }

  
  /// The Itanium base layout rule allows virtual bases to overlap
  /// other bases, which complicates layout in specific ways.
  ///
  /// Note specifically that the ms_struct attribute doesn't change this.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::isOverlappingVBaseABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 117,
   FQN="(anonymous namespace)::CGRecordLowering::isOverlappingVBaseABI", NM="_ZN12_GLOBAL__N_116CGRecordLowering21isOverlappingVBaseABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering21isOverlappingVBaseABIEv")
  //</editor-fold>
  public boolean isOverlappingVBaseABI() {
    return !Context.getTargetInfo().getCXXABI().isMicrosoft();
  }

  
  /// \brief Wraps llvm::Type::getIntNTy with some implicit arguments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::getIntNType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 122,
   FQN="(anonymous namespace)::CGRecordLowering::getIntNType", NM="_ZN12_GLOBAL__N_116CGRecordLowering11getIntNTypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering11getIntNTypeEy")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ getIntNType(long/*uint64_t*/ NumBits) {
    return org.llvm.ir.Type.getIntNTy(Types.getLLVMContext(), 
        (/*uint*/int)$ulong2uint(llvm.alignTo(NumBits, $int2ulong(8))));
  }

  /// \brief Gets an llvm type of size NumBytes and alignment 1.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::getByteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 127,
   FQN="(anonymous namespace)::CGRecordLowering::getByteArrayType", NM="_ZN12_GLOBAL__N_116CGRecordLowering16getByteArrayTypeEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering16getByteArrayTypeEN5clang9CharUnitsE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ getByteArrayType(CharUnits NumBytes) {
    assert (!NumBytes.isZero()) : "Empty byte arrays aren't allowed.";
    org.llvm.ir.Type /*P*/ Type = org.llvm.ir.Type.getInt8Ty(Types.getLLVMContext());
    return NumBytes.$eq(CharUnits.One()) ? Type : (org.llvm.ir.Type /*P*/ )org.llvm.ir.ArrayType.get(Type, NumBytes.getQuantity());
  }

  /// \brief Gets the storage type for a field decl and handles storage
  /// for itanium bitfields that are smaller than their declared type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::getStorageType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 135,
   FQN="(anonymous namespace)::CGRecordLowering::getStorageType", NM="_ZN12_GLOBAL__N_116CGRecordLowering14getStorageTypeEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering14getStorageTypeEPKN5clang9FieldDeclE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ getStorageType(/*const*/ FieldDecl /*P*/ FD) {
    org.llvm.ir.Type /*P*/ Type = Types.ConvertTypeForMem(FD.getType());
    if (!FD.isBitField()) {
      return Type;
    }
    if (isDiscreteBitFieldABI()) {
      return Type;
    }
    return getIntNType($uint2ulong(std.min_uint(FD.getBitWidthValue(Context), 
            (/*uint*/int)$long2uint(Context.toBits(getSize(Type))))));
  }

  /// \brief Gets the llvm Basesubobject type from a CXXRecordDecl.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::getStorageType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 143,
   FQN="(anonymous namespace)::CGRecordLowering::getStorageType", NM="_ZN12_GLOBAL__N_116CGRecordLowering14getStorageTypeEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering14getStorageTypeEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ getStorageType(/*const*/ CXXRecordDecl /*P*/ RD) {
    return Types.getCGRecordLayout(RD).getBaseSubobjectLLVMType();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::bitsToCharUnits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 146,
   FQN="(anonymous namespace)::CGRecordLowering::bitsToCharUnits", NM="_ZN12_GLOBAL__N_116CGRecordLowering15bitsToCharUnitsEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering15bitsToCharUnitsEy")
  //</editor-fold>
  public CharUnits bitsToCharUnits(long/*uint64_t*/ BitOffset) {
    return Context.toCharUnitsFromBits(BitOffset);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 149,
   FQN="(anonymous namespace)::CGRecordLowering::getSize", NM="_ZN12_GLOBAL__N_116CGRecordLowering7getSizeEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering7getSizeEPN4llvm4TypeE")
  //</editor-fold>
  public CharUnits getSize(org.llvm.ir.Type /*P*/ Type) {
    return CharUnits.fromQuantity(DataLayout.getTypeAllocSize(Type));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 152,
   FQN="(anonymous namespace)::CGRecordLowering::getAlignment", NM="_ZN12_GLOBAL__N_116CGRecordLowering12getAlignmentEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering12getAlignmentEPN4llvm4TypeE")
  //</editor-fold>
  public CharUnits getAlignment(org.llvm.ir.Type /*P*/ Type) {
    return CharUnits.fromQuantity($uint2long(DataLayout.getABITypeAlignment(Type)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 155,
   FQN="(anonymous namespace)::CGRecordLowering::isZeroInitializable", NM="_ZN12_GLOBAL__N_116CGRecordLowering19isZeroInitializableEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering19isZeroInitializableEPKN5clang9FieldDeclE")
  //</editor-fold>
  public boolean isZeroInitializable(/*const*/ FieldDecl /*P*/ FD) {
    return Types.isZeroInitializable(FD.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 158,
   FQN="(anonymous namespace)::CGRecordLowering::isZeroInitializable", NM="_ZN12_GLOBAL__N_116CGRecordLowering19isZeroInitializableEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering19isZeroInitializableEPKN5clang10RecordDeclE")
  //</editor-fold>
  public boolean isZeroInitializable(/*const*/ RecordDecl /*P*/ RD) {
    return Types.isZeroInitializable(RD);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::appendPaddingBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 161,
   FQN="(anonymous namespace)::CGRecordLowering::appendPaddingBytes", NM="_ZN12_GLOBAL__N_116CGRecordLowering18appendPaddingBytesEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering18appendPaddingBytesEN5clang9CharUnitsE")
  //</editor-fold>
  public void appendPaddingBytes(CharUnits Size) {
    if (!Size.isZero()) {
      FieldTypes.push_back(getByteArrayType(new CharUnits(Size)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::getFieldBitOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 165,
   FQN="(anonymous namespace)::CGRecordLowering::getFieldBitOffset", NM="_ZN12_GLOBAL__N_116CGRecordLowering17getFieldBitOffsetEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering17getFieldBitOffsetEPKN5clang9FieldDeclE")
  //</editor-fold>
  public long/*uint64_t*/ getFieldBitOffset(/*const*/ FieldDecl /*P*/ FD) {
    return Layout.getFieldOffset(FD.getFieldIndex());
  }

  // Layout routines.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::setBitFieldInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 224,
   FQN="(anonymous namespace)::CGRecordLowering::setBitFieldInfo", NM="_ZN12_GLOBAL__N_116CGRecordLowering15setBitFieldInfoEPKN5clang9FieldDeclENS1_9CharUnitsEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering15setBitFieldInfoEPKN5clang9FieldDeclENS1_9CharUnitsEPN4llvm4TypeE")
  //</editor-fold>
  public void setBitFieldInfo(/*const*/ FieldDecl /*P*/ FD, CharUnits StartOffset, org.llvm.ir.Type /*P*/ StorageType) {
    final CGBitFieldInfo /*&*/ Info = BitFields.$at_T1$RR(FD.getCanonicalDecl$Const());
    Info.IsSigned = FD.getType().$arrow().isSignedIntegerOrEnumerationType();
    Info.Offset = $uint2uint_16bits((/*uint*/int)$ullong2uint((getFieldBitOffset(FD) - Context.toBits(new CharUnits(StartOffset)))));
    Info.Size = $uint2uint_15bits(FD.getBitWidthValue(Context));
    Info.StorageSize = (/*uint*/int)$ulong2uint(DataLayout.getTypeAllocSizeInBits(StorageType));
    Info.StorageOffset.$assign(StartOffset);
    if ($greater_uint($15bits_uint2uint(Info.Size), Info.StorageSize)) {
      Info.Size = $uint2uint_15bits(Info.StorageSize);
    }
    // Reverse the bit offsets for big endian machines. Because we represent
    // a bitfield as a single large integer load, we can imagine the bits
    // counting from the most-significant-bit instead of the
    // least-significant-bit.
    if (DataLayout.isBigEndian()) {
      Info.Offset = $uint2uint_16bits(Info.StorageSize - ($16bits_uint2uint(Info.Offset) + $15bits_uint2uint(Info.Size)));
    }
  }

  /// \brief Lowers an ASTRecordLayout to a llvm type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::lower">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 242,
   FQN="(anonymous namespace)::CGRecordLowering::lower", NM="_ZN12_GLOBAL__N_116CGRecordLowering5lowerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering5lowerEb")
  //</editor-fold>
  public void lower(boolean NVBaseType) {
    // The lowering process implemented in this function takes a variety of
    // carefully ordered phases.
    // 1) Store all members (fields and bases) in a list and sort them by offset.
    // 2) Add a 1-byte capstone member at the Size of the structure.
    // 3) Clip bitfield storages members if their tail padding is or might be
    //    used by another field or base.  The clipping process uses the capstone 
    //    by treating it as another object that occurs after the record.
    // 4) Determine if the llvm-struct requires packing.  It's important that this
    //    phase occur after clipping, because clipping changes the llvm type.
    //    This phase reads the offset of the capstone when determining packedness
    //    and updates the alignment of the capstone to be equal of the alignment
    //    of the record after doing so.
    // 5) Insert padding everywhere it is needed.  This phase requires 'Packed' to
    //    have been computed and needs to know the alignment of the record in
    //    order to understand if explicit tail padding is needed.
    // 6) Remove the capstone, we don't need it anymore.
    // 7) Determine if this record can be zero-initialized.  This phase could have
    //    been placed anywhere after phase 1.
    // 8) Format the complete list of members in a way that can be consumed by
    //    CodeGenTypes::ComputeRecordLayout.
    CharUnits Size = NVBaseType ? Layout.getNonVirtualSize() : Layout.getSize();
    if (D.isUnion()) {
      lowerUnion();
      /*JAVA:return*/return;
    }
    accumulateFields();
    // RD implies C++.
    if ((RD != null)) {
      accumulateVPtrs();
      accumulateBases();
      if (Members.empty()) {
        appendPaddingBytes(new CharUnits(Size));
        /*JAVA:return*/return;
      }
      if (!NVBaseType) {
        accumulateVBases();
      }
    }
    std.stable_sort(Members.begin(), Members.end(), MemberInfo::compare);
    Members.push_back_T$RR(StorageInfo(new CharUnits(Size), getIntNType($int2ulong(8))));
    clipTailPadding();
    determinePacked(NVBaseType);
    insertPadding();
    Members.pop_back();
    calculateZeroInit();
    fillOutputFields();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::lowerUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 286,
   FQN="(anonymous namespace)::CGRecordLowering::lowerUnion", NM="_ZN12_GLOBAL__N_116CGRecordLowering10lowerUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering10lowerUnionEv")
  //</editor-fold>
  public void lowerUnion() {
    CharUnits LayoutSize = Layout.getSize();
    org.llvm.ir.Type /*P*/ StorageType = null;
    boolean SeenNamedMember = false;
    // Iterate through the fields setting bitFieldInfo and the Fields array. Also
    // locate the "most appropriate" storage type.  The heuristic for finding the
    // storage type isn't necessary, the first (non-0-length-bitfield) field's
    // type would work fine and be simpler but would be different than what we've
    // been doing and cause lit tests to change.
    for (/*const*/ FieldDecl /*P*/ Field : D.fields()) {
      if (Field.isBitField()) {
        // Skip 0 sized bitfields.
        if (Field.getBitWidthValue(Context) == 0) {
          continue;
        }
        org.llvm.ir.Type /*P*/ FieldType = getStorageType(Field);
        if (LayoutSize.$less(getSize(FieldType))) {
          FieldType = getByteArrayType(new CharUnits(LayoutSize));
        }
        setBitFieldInfo(Field, CharUnits.Zero(), FieldType);
      }
      Fields.$set(Field.getCanonicalDecl$Const(), 0);
      org.llvm.ir.Type /*P*/ FieldType = getStorageType(Field);
      // Compute zero-initializable status.
      // This union might not be zero initialized: it may contain a pointer to
      // data member which might have some exotic initialization sequence.
      // If this is the case, then we aught not to try and come up with a "better"
      // type, it might not be very easy to come up with a Constant which
      // correctly initializes it.
      if (!SeenNamedMember) {
        SeenNamedMember = (Field.getIdentifier() != null);
        if (!SeenNamedMember) {
          {
            /*const*/ RecordDecl /*P*/ FieldRD = dyn_cast_or_null_RecordDecl(Field.getType().$arrow().getAsTagDecl());
            if ((FieldRD != null)) {
              SeenNamedMember = (FieldRD.findFirstNamedDataMember() != null);
            }
          }
        }
        if (SeenNamedMember && !isZeroInitializable(Field)) {
          IsZeroInitializable = IsZeroInitializableAsBase = false;
          StorageType = FieldType;
        }
      }
      // Because our union isn't zero initializable, we won't be getting a better
      // storage type.
      if (!IsZeroInitializable) {
        continue;
      }
      // Conditionally update our storage type if we've got a new "better" one.
      if (!(StorageType != null)
         || getAlignment(FieldType).$greater(getAlignment(StorageType))
         || (getAlignment(FieldType).$eq(getAlignment(StorageType))
         && getSize(FieldType).$greater(getSize(StorageType)))) {
        StorageType = FieldType;
      }
    }
    // If we have no storage type just pad to the appropriate size and return.
    if (!(StorageType != null)) {
      appendPaddingBytes(new CharUnits(LayoutSize));
      /*JAVA:return*/return;
    }
    // If our storage size was bigger than our required size (can happen in the
    // case of packed bitfields on Itanium) then just use an I8 array.
    if (LayoutSize.$less(getSize(StorageType))) {
      StorageType = getByteArrayType(new CharUnits(LayoutSize));
    }
    FieldTypes.push_back(StorageType);
    appendPaddingBytes(LayoutSize.$sub(getSize(StorageType)));
    // Set packed if we need it.
    if ((LayoutSize.$mod(getAlignment(StorageType)) != 0)) {
      Packed = true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::accumulateFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 349,
   FQN="(anonymous namespace)::CGRecordLowering::accumulateFields", NM="_ZN12_GLOBAL__N_116CGRecordLowering16accumulateFieldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering16accumulateFieldsEv")
  //</editor-fold>
  public void accumulateFields() {
    for (specific_decl_iterator<FieldDecl> Field = D.field_begin(), 
        FieldEnd = D.field_end();
         specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd);)  {
      if (Field.$arrow().isBitField()) {
        specific_decl_iterator<FieldDecl> Start = new specific_decl_iterator<FieldDecl>(Field);
        // Iterate to gather the list of bitfields.
        for (Field.$preInc(); specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd) && Field.$arrow().isBitField(); Field.$preInc())  {
          ;
        }
        accumulateBitFields(new specific_decl_iterator<FieldDecl>(Start), new specific_decl_iterator<FieldDecl>(Field));
      } else {
        Members.push_back_T$RR(new MemberInfo(bitsToCharUnits(getFieldBitOffset(Field.$star())), MemberInfo.InfoKind.Field, 
                getStorageType(Field.$star()), Field.$star()));
        Field.$preInc();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::accumulateBitFields">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 366,
   FQN="(anonymous namespace)::CGRecordLowering::accumulateBitFields", NM="_ZN12_GLOBAL__N_116CGRecordLowering19accumulateBitFieldsEN5clang11DeclContext22specific_decl_iteratorINS1_9FieldDeclEEES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering19accumulateBitFieldsEN5clang11DeclContext22specific_decl_iteratorINS1_9FieldDeclEEES5_")
  //</editor-fold>
  public void accumulateBitFields(specific_decl_iterator<FieldDecl> Field, 
                     specific_decl_iterator<FieldDecl> FieldEnd) {
    // Run stores the first element of the current run of bitfields.  FieldEnd is
    // used as a special value to note that we don't have a current run.  A
    // bitfield run is a contiguous collection of bitfields that can be stored in
    // the same storage block.  Zero-sized bitfields and bitfields that would
    // cross an alignment boundary break a run and start a new one.
    specific_decl_iterator<FieldDecl> Run = new specific_decl_iterator<FieldDecl>(FieldEnd);
    // Tail is the offset of the first bit off the end of the current run.  It's
    // used to determine if the ASTRecordLayout is treating these two bitfields as
    // contiguous.  StartBitOffset is offset of the beginning of the Run.
    long/*uint64_t*/ StartBitOffset = 0;
    long/*uint64_t*/ Tail = $int2ulong(0);
    if (isDiscreteBitFieldABI()) {
      for (; specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc()) {
        long/*uint64_t*/ BitOffset = getFieldBitOffset(Field.$star());
        // Zero-width bitfields end runs.
        if (Field.$arrow().getBitWidthValue(Context) == 0) {
          Run.$assign(FieldEnd);
          continue;
        }
        org.llvm.ir.Type /*P*/ Type = Types.ConvertTypeForMem(Field.$arrow().getType());
        // If we don't have a run yet, or don't live within the previous run's
        // allocated storage then we allocate some storage and start a new run.
        if (specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(Run, FieldEnd) || $greatereq_ulong(BitOffset, Tail)) {
          Run.$assign(Field);
          StartBitOffset = BitOffset;
          Tail = StartBitOffset + DataLayout.getTypeAllocSizeInBits(Type);
          // Add the storage member to the record.  This must be added to the
          // record before the bitfield members so that it gets laid out before
          // the bitfields it contains get laid out.
          Members.push_back_T$RR(StorageInfo(bitsToCharUnits(StartBitOffset), Type));
        }
        // Bitfields get the offset of their storage but come afterward and remain
        // there after a stable sort.
        Members.push_back_T$RR(new MemberInfo(bitsToCharUnits(StartBitOffset), 
                MemberInfo.InfoKind.Field, (org.llvm.ir.Type /*P*/ )null, Field.$star()));
      }
      return;
    }
    for (;;) {
      // Check to see if we need to start a new run.
      if (specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(Run, FieldEnd)) {
        // If we're out of fields, return.
        if (specific_decl_iterator.$eq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd)) {
          break;
        }
        // Any non-zero-length bitfield can start a new run.
        if (Field.$arrow().getBitWidthValue(Context) != 0) {
          Run.$assign(Field);
          StartBitOffset = getFieldBitOffset(Field.$star());
          Tail = StartBitOffset + $uint2ullong(Field.$arrow().getBitWidthValue(Context));
        }
        Field.$preInc();
        continue;
      }
      // Add bitfields to the run as long as they qualify.
      if (specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd) && Field.$arrow().getBitWidthValue(Context) != 0
         && Tail == getFieldBitOffset(Field.$star())) {
        Tail += $uint2ullong(Field.$arrow().getBitWidthValue(Context));
        Field.$preInc();
        continue;
      }
      // We've hit a break-point in the run and need to emit a storage field.
      org.llvm.ir.Type /*P*/ Type = getIntNType(Tail - StartBitOffset);
      // Add the storage member to the record and set the bitfield info for all of
      // the bitfields in the run.  Bitfields get the offset of their storage but
      // come afterward and remain there after a stable sort.
      Members.push_back_T$RR(StorageInfo(bitsToCharUnits(StartBitOffset), Type));
      for (; specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Run, Field); Run.$preInc())  {
        Members.push_back_T$RR(new MemberInfo(bitsToCharUnits(StartBitOffset), 
                MemberInfo.InfoKind.Field, (org.llvm.ir.Type /*P*/ )null, Run.$star()));
      }
      Run.$assign(FieldEnd);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::accumulateBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 441,
   FQN="(anonymous namespace)::CGRecordLowering::accumulateBases", NM="_ZN12_GLOBAL__N_116CGRecordLowering15accumulateBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering15accumulateBasesEv")
  //</editor-fold>
  public void accumulateBases() {
    // If we've got a primary virtual base, we need to add it with the bases.
    if (Layout.isPrimaryBaseVirtual()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Layout.getPrimaryBase();
      Members.push_back_T$RR(new MemberInfo(CharUnits.Zero(), MemberInfo.InfoKind.Base, 
              getStorageType(BaseDecl), BaseDecl));
    }
    // Accumulate the non-virtual bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      if (Base.isVirtual()) {
        continue;
      }
      
      // Bases can be zero-sized even if not technically empty if they
      // contain only a trailing array member.
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      if (!BaseDecl.isEmpty()
         && !Context.getASTRecordLayout(BaseDecl).getNonVirtualSize().isZero()) {
        Members.push_back_T$RR(new MemberInfo(Layout.getBaseClassOffset(BaseDecl), 
                MemberInfo.InfoKind.Base, getStorageType(BaseDecl), BaseDecl));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::accumulateVPtrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 463,
   FQN="(anonymous namespace)::CGRecordLowering::accumulateVPtrs", NM="_ZN12_GLOBAL__N_116CGRecordLowering15accumulateVPtrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering15accumulateVPtrsEv")
  //</editor-fold>
  public void accumulateVPtrs() {
    if (Layout.hasOwnVFPtr()) {
      Members.push_back_T$RR(new MemberInfo(CharUnits.Zero(), MemberInfo.InfoKind.VFPtr, 
              org.llvm.ir.FunctionType.get(getIntNType($int2ulong(32)), /*isVarArg=*/ true).
                  getPointerTo().getPointerTo()));
    }
    if (Layout.hasOwnVBPtr()) {
      Members.push_back_T$RR(new MemberInfo(Layout.getVBPtrOffset(), MemberInfo.InfoKind.VBPtr, 
              org.llvm.ir.Type.getInt32PtrTy(Types.getLLVMContext())));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::accumulateVBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 473,
   FQN="(anonymous namespace)::CGRecordLowering::accumulateVBases", NM="_ZN12_GLOBAL__N_116CGRecordLowering16accumulateVBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering16accumulateVBasesEv")
  //</editor-fold>
  public void accumulateVBases() {
    CharUnits ScissorOffset = Layout.getNonVirtualSize();
    // In the itanium ABI, it's possible to place a vbase at a dsize that is
    // smaller than the nvsize.  Here we check to see if such a base is placed
    // before the nvsize and set the scissor offset to that, instead of the
    // nvsize.
    if (isOverlappingVBaseABI()) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.vbases$Const()) {
        /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
        if (BaseDecl.isEmpty()) {
          continue;
        }
        // If the vbase is a primary virtual base of some base, then it doesn't
        // get its own storage location but instead lives inside of that base.
        if (Context.isNearlyEmpty(BaseDecl) && !hasOwnStorage(RD, BaseDecl)) {
          continue;
        }
        ScissorOffset.$assign(std.min(ScissorOffset, 
                Layout.getVBaseClassOffset(BaseDecl)));
      }
    }
    Members.push_back_T$RR(new MemberInfo(new CharUnits(ScissorOffset), MemberInfo.InfoKind.Scissor, (org.llvm.ir.Type /*P*/ )null, 
            RD));
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      if (BaseDecl.isEmpty()) {
        continue;
      }
      CharUnits Offset = Layout.getVBaseClassOffset(BaseDecl);
      // If the vbase is a primary virtual base of some base, then it doesn't
      // get its own storage location but instead lives inside of that base.
      if (isOverlappingVBaseABI()
         && Context.isNearlyEmpty(BaseDecl)
         && !hasOwnStorage(RD, BaseDecl)) {
        Members.push_back_T$RR(new MemberInfo(new CharUnits(Offset), MemberInfo.InfoKind.VBase, (org.llvm.ir.Type /*P*/ )null, 
                BaseDecl));
        continue;
      }
      // If we've got a vtordisp, add it as a storage type.
      if (Layout.getVBaseOffsetsMap().find$Const(BaseDecl).$arrow().second.hasVtorDisp()) {
        Members.push_back_T$RR(StorageInfo(Offset.$sub(CharUnits.fromQuantity(4)), 
                getIntNType($int2ulong(32))));
      }
      Members.push_back_T$RR(new MemberInfo(new CharUnits(Offset), MemberInfo.InfoKind.VBase, 
              getStorageType(BaseDecl), BaseDecl));
    }
  }

  /// \brief Recursively searches all of the bases to find out if a vbase is
  /// not the primary vbase of some base class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::hasOwnStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 516,
   FQN="(anonymous namespace)::CGRecordLowering::hasOwnStorage", NM="_ZN12_GLOBAL__N_116CGRecordLowering13hasOwnStorageEPKN5clang13CXXRecordDeclES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering13hasOwnStorageEPKN5clang13CXXRecordDeclES4_")
  //</editor-fold>
  public boolean hasOwnStorage(/*const*/ CXXRecordDecl /*P*/ Decl, 
               /*const*/ CXXRecordDecl /*P*/ Query) {
    final /*const*/ ASTRecordLayout /*&*/ DeclLayout = Context.getASTRecordLayout(Decl);
    if (DeclLayout.isPrimaryBaseVirtual() && DeclLayout.getPrimaryBase() == Query) {
      return false;
    }
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : Decl.bases$Const())  {
      if (!hasOwnStorage(Base.getType().$arrow().getAsCXXRecordDecl(), Query)) {
        return false;
      }
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::calculateZeroInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 527,
   FQN="(anonymous namespace)::CGRecordLowering::calculateZeroInit", NM="_ZN12_GLOBAL__N_116CGRecordLowering17calculateZeroInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering17calculateZeroInitEv")
  //</editor-fold>
  public void calculateZeroInit() {
    for (std.vector.iterator</*const*/ MemberInfo /*P*/ > Member = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.begin()), 
        MemberEnd = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.end());
         IsZeroInitializableAsBase && $noteq___normal_iterator$C(Member, MemberEnd); Member.$preInc()) {
      if (Member.$arrow().Kind == MemberInfo.InfoKind.Field) {
        if (!(Member.$arrow().Unnamed_field3.FD != null) || isZeroInitializable(Member.$arrow().Unnamed_field3.FD)) {
          continue;
        }
        IsZeroInitializable = IsZeroInitializableAsBase = false;
      } else if (Member.$arrow().Kind == MemberInfo.InfoKind.Base
         || Member.$arrow().Kind == MemberInfo.InfoKind.VBase) {
        if (isZeroInitializable(Member.$arrow().Unnamed_field3.RD)) {
          continue;
        }
        IsZeroInitializable = false;
        if (Member.$arrow().Kind == MemberInfo.InfoKind.Base) {
          IsZeroInitializableAsBase = false;
        }
      }
    }
  }

  /// \brief Lowers bitfield storage types to I8 arrays for bitfields with tail
  /// padding that is or can potentially be used.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::clipTailPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 546,
   FQN="(anonymous namespace)::CGRecordLowering::clipTailPadding", NM="_ZN12_GLOBAL__N_116CGRecordLowering15clipTailPaddingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering15clipTailPaddingEv")
  //</editor-fold>
  public void clipTailPadding() {
    std.vector.iterator<MemberInfo /*P*/ > Prior = Members.begin();
    CharUnits Tail = getSize(Prior.$arrow().Data);
    for (std.vector.iterator<MemberInfo /*P*/ > Member = Prior.$add(1), 
        MemberEnd = Members.end();
         $noteq___normal_iterator$C(Member, MemberEnd); Member.$preInc()) {
      // Only members with data and the scissor can cut into tail padding.
      if (!(Member.$arrow().Data != null) && Member.$arrow().Kind != MemberInfo.InfoKind.Scissor) {
        continue;
      }
      if (Member.$arrow().Offset.$less(Tail)) {
        assert (Prior.$arrow().Kind == MemberInfo.InfoKind.Field && !(Prior.$arrow().Unnamed_field3.FD != null)) : "Only storage fields have tail padding!";
        Prior.$arrow().Data = getByteArrayType(bitsToCharUnits(llvm.alignTo($uint2ulong(cast_IntegerType(Prior.$arrow().Data).getIntegerBitWidth()), $int2ulong(8))));
      }
      if ((Member.$arrow().Data != null)) {
        Prior.$assign(Member);
      }
      Tail.$assignMove(Prior.$arrow().Offset.$add(getSize(Prior.$arrow().Data)));
    }
  }

  /// \brief Determines if we need a packed llvm struct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::determinePacked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 567,
   FQN="(anonymous namespace)::CGRecordLowering::determinePacked", NM="_ZN12_GLOBAL__N_116CGRecordLowering15determinePackedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering15determinePackedEb")
  //</editor-fold>
  public void determinePacked(boolean NVBaseType) {
    if (Packed) {
      return;
    }
    CharUnits Alignment = CharUnits.One();
    CharUnits NVAlignment = CharUnits.One();
    CharUnits NVSize = !NVBaseType && (RD != null) ? Layout.getNonVirtualSize() : CharUnits.Zero();
    for (std.vector.iterator</*const*/ MemberInfo /*P*/ > Member = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.begin()), 
        MemberEnd = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.end());
         $noteq___normal_iterator$C(Member, MemberEnd); Member.$preInc()) {
      if (!(Member.$arrow().Data != null)) {
        continue;
      }
      // If any member falls at an offset that it not a multiple of its alignment,
      // then the entire record must be packed.
      if ((Member.$arrow().Offset.$mod(getAlignment(Member.$arrow().Data)) != 0)) {
        Packed = true;
      }
      if (Member.$arrow().Offset.$less(NVSize)) {
        NVAlignment.$assign(std.max(NVAlignment, getAlignment(Member.$arrow().Data)));
      }
      Alignment.$assign(std.max(Alignment, getAlignment(Member.$arrow().Data)));
    }
    // If the size of the record (the capstone's offset) is not a multiple of the
    // record's alignment, it must be packed.
    if ((Members.back().Offset.$mod(Alignment) != 0)) {
      Packed = true;
    }
    // If the non-virtual sub-object is not a multiple of the non-virtual
    // sub-object's alignment, it must be packed.  We cannot have a packed
    // non-virtual sub-object and an unpacked complete object or vise versa.
    if ((NVSize.$mod(NVAlignment) != 0)) {
      Packed = true;
    }
    // Update the alignment of the sentinal.
    if (!Packed) {
      Members.back().Data = getIntNType(Context.toBits(new CharUnits(Alignment)));
    }
  }

  /// \brief Inserts padding everwhere it's needed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::insertPadding">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 601,
   FQN="(anonymous namespace)::CGRecordLowering::insertPadding", NM="_ZN12_GLOBAL__N_116CGRecordLowering13insertPaddingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering13insertPaddingEv")
  //</editor-fold>
  public void insertPadding() {
    std.vector<std.pair<CharUnits, CharUnits>> Padding = null;
    try {
      Padding/*J*/= new std.vector<std.pair<CharUnits, CharUnits>>(new std.pairTypeType<CharUnits, CharUnits>(new CharUnits(), new CharUnits()));
      CharUnits Size = CharUnits.Zero();
      for (std.vector.iterator</*const*/ MemberInfo /*P*/ > Member = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.begin()), 
          MemberEnd = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.end());
           $noteq___normal_iterator$C(Member, MemberEnd); Member.$preInc()) {
        if (!(Member.$arrow().Data != null)) {
          continue;
        }
        CharUnits Offset = new CharUnits(Member.$arrow().Offset);
        assert (Offset.$greatereq(Size));
        // Insert padding if we need to.
        if (Offset.$noteq(
            Size.alignTo(Packed ? CharUnits.One() : getAlignment(Member.$arrow().Data))
        )) {
          Padding.push_back_T$RR(std.make_pair(Size, Offset.$sub(Size)));
        }
        Size.$assignMove(Offset.$add(getSize(Member.$arrow().Data)));
      }
      if (Padding.empty()) {
        return;
      }
      // Add the padding to the Members list and sort it.
      for (std.vector.iterator</*const*/ std.pair<CharUnits, CharUnits> /*P*/ > Pad = new std.vector.iterator</*const*/ std.pair<CharUnits, CharUnits> /*P*/ >(Padding.begin()), PadEnd = new std.vector.iterator</*const*/ std.pair<CharUnits, CharUnits> /*P*/ >(Padding.end());
           $noteq___normal_iterator$C(Pad, PadEnd); Pad.$preInc())  {
        Members.push_back_T$RR(StorageInfo(new CharUnits(Pad.$arrow().first), getByteArrayType(new CharUnits(Pad.$arrow().second))));
      }
      std.stable_sort(Members.begin().toPointer(), Members.end().toPointer(), MemberInfo::$less);
    } finally {
      if (Padding != null) { Padding.$destroy(); }
    }
  }

  /// \brief Fills out the structures that are ultimately consumed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::fillOutputFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 627,
   FQN="(anonymous namespace)::CGRecordLowering::fillOutputFields", NM="_ZN12_GLOBAL__N_116CGRecordLowering16fillOutputFieldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLowering16fillOutputFieldsEv")
  //</editor-fold>
  public void fillOutputFields() {
    for (std.vector.iterator</*const*/ MemberInfo /*P*/ > Member = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.begin()), 
        MemberEnd = new std.vector.iterator</*const*/ MemberInfo /*P*/ >(Members.end());
         $noteq___normal_iterator$C(Member, MemberEnd); Member.$preInc()) {
      if ((Member.$arrow().Data != null)) {
        FieldTypes.push_back(Member.$arrow().Data);
      }
      if (Member.$arrow().Kind == MemberInfo.InfoKind.Field) {
        if ((Member.$arrow().Unnamed_field3.FD != null)) {
          Fields.$set(Member.$arrow().Unnamed_field3.FD.getCanonicalDecl$Const(), FieldTypes.size() - 1);
        }
        // A field without storage must be a bitfield.
        if (!(Member.$arrow().Data != null)) {
          setBitFieldInfo(Member.$arrow().Unnamed_field3.FD, new CharUnits(Member.$arrow().Offset), FieldTypes.back());
        }
      } else if (Member.$arrow().Kind == MemberInfo.InfoKind.Base) {
        NonVirtualBases.$set(Member.$arrow().Unnamed_field3.RD, FieldTypes.size() - 1);
      } else if (Member.$arrow().Kind == MemberInfo.InfoKind.VBase) {
        VirtualBases.$set(Member.$arrow().Unnamed_field3.RD, FieldTypes.size() - 1);
      }
    }
  }

  // Input memoization fields.
  public final CodeGenTypes /*&*/ Types;
  public final /*const*/ ASTContext /*&*/ Context;
  public /*const*/ RecordDecl /*P*/ D;
  public /*const*/ CXXRecordDecl /*P*/ RD;
  public final /*const*/ ASTRecordLayout /*&*/ Layout;
  public final /*const*/ DataLayout /*&*/ DataLayout;
  // Helpful intermediate data-structures.
  public std.vector<MemberInfo> Members;
  // Output fields, consumed by CodeGenTypes::ComputeRecordLayout.
  public SmallVector<org.llvm.ir.Type /*P*/ > FieldTypes;
  public DenseMapTypeUInt</*const*/ FieldDecl /*P*/ > Fields;
  public DenseMap</*const*/ FieldDecl /*P*/ , CGBitFieldInfo> BitFields;
  public DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > NonVirtualBases;
  public DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > VirtualBases;
  public /*JBIT bool*/ boolean IsZeroInitializable /*: 1*/;
  public /*JBIT bool*/ boolean IsZeroInitializableAsBase /*: 1*/;
  public /*JBIT bool*/ boolean Packed /*: 1*/;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::CGRecordLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 212,
   FQN="(anonymous namespace)::CGRecordLowering::CGRecordLowering", NM="_ZN12_GLOBAL__N_116CGRecordLoweringC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLoweringC1ERKS0_")
  //</editor-fold>
  protected/*private*/ CGRecordLowering(final /*const*/ CGRecordLowering /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 213,
   FQN="(anonymous namespace)::CGRecordLowering::operator=", NM="_ZN12_GLOBAL__N_116CGRecordLoweringaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLoweringaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ CGRecordLowering /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGRecordLowering::~CGRecordLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp", line = 74,
   FQN="(anonymous namespace)::CGRecordLowering::~CGRecordLowering", NM="_ZN12_GLOBAL__N_116CGRecordLoweringD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGRecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_116CGRecordLoweringD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VirtualBases.$destroy();
    NonVirtualBases.$destroy();
    BitFields.$destroy();
    Fields.$destroy();
    FieldTypes.$destroy();
    Members.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Types=" + Types // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", D=" + "[RecordDecl]" // NOI18N
              + ", RD=" + "[CXXRecordDecl]" // NOI18N
              + ", Layout=" + Layout // NOI18N
              + ", DataLayout=" + DataLayout // NOI18N
              + ", Members=" + Members // NOI18N
              + ", FieldTypes=" + FieldTypes // NOI18N
              + ", Fields=" + "[DenseMapTypeUInt$FieldDecl]" // NOI18N
              + ", BitFields=" + BitFields // NOI18N
              + ", NonVirtualBases=" + "[DenseMapTypeUInt$CXXRecordDecl]" // NOI18N
              + ", VirtualBases=" + "[DenseMapTypeUInt$CXXRecordDecl]" // NOI18N
              + ", IsZeroInitializable=" + IsZeroInitializable // NOI18N
              + ", IsZeroInitializableAsBase=" + IsZeroInitializableAsBase // NOI18N
              + ", Packed=" + Packed; // NOI18N
  }
}
